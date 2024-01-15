package com.ayah.loginandreg.services;

import java.util.List;
import java.util.Optional;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.ayah.loginandreg.models.LoginUser;
import com.ayah.loginandreg.models.User;
import com.ayah.loginandreg.repositories.UserRepository;


import io.micrometer.common.util.StringUtils;

@Service
public class UserService {
	
    @Autowired
    private UserRepository userRepository;
    
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    // returns all the Users
    public List<User> allUsers() {
        return userRepository.findAll();
    }
    // creates a User
    public User createUser(User user) {
        return userRepository.save(user);
    }
    // retrieves a User
    public User findUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()) {
            return optionalUser.get();
        } else {
            return null;
        }
    }
    
    // updates a User
	public User updateUser(User user) {
		    Optional<User> optionalUser = userRepository.findById(user.getId());
	        if(optionalUser.isPresent()) {
	     
		        user.setUserName(user.getUserName());
		        user.setEmail(user.getEmail());
		        user.setPassword(user.getPassword());
		        return  userRepository.save(user);
	        
	        } else {
	        	
	            return null;
	        }
	    }
	
	// delete a User
	public void deleteUser(Long id) {
		userRepository.deleteById(id);
		
	}
	
	
	//register and login methods
	 public User register(User newUser, BindingResult result) {
	        // Validate username
	        if (StringUtils.isEmpty(newUser.getUserName()) || newUser.getUserName().length() < 3 || !isValidUsername(newUser.getUserName())) {
	        	result.rejectValue("username", "Invalid", "Username must be at least 3 characters long, not blank, and contain only letters (a-z, A-Z).");
	        }

	        // Validate email
	        if (StringUtils.isEmpty(newUser.getEmail()) || !isValidEmail(newUser.getEmail())) {
	            result.rejectValue("email", "Invalid", "Email is not valid.");
	        } else {
	            Optional<User> potentialUser = userRepository.findByEmail(newUser.getEmail());
	            if (potentialUser.isPresent()) {
	                result.rejectValue("email", "Matches", "An account with that email already exists.");
	            }
	        }

	        // Validate password
	        if (StringUtils.isEmpty(newUser.getPassword()) || newUser.getPassword().length() < 8) {
	            result.rejectValue("password", "Invalid", "Password must be at least 8 characters long and not blank.");
	        }

	        // Validate password confirmation
	        if (!newUser.getPassword().equals(newUser.getConfirm())) {
	            result.rejectValue("confirm", "Invalid", "The Confirm Password must match Password.");
	        }

	        if (result.hasErrors()) {
	            return null; // Validation failed
	        }

	        // Hash the password and save the user
	    	String hashedPassword = BCrypt.hashpw(newUser.getPassword(), BCrypt.gensalt());
	        newUser.setPassword(hashedPassword);
	        return userRepository.save(newUser);
	    }

	    // Helper method to validate email format
	    private boolean isValidEmail(String email) {
	    	// Define a simpler regex pattern for a valid email address
	        String regex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
	        return Pattern.compile(regex).matcher(email).matches();
	    }
	    
	    public static boolean isValidUsername(String username) {
	        // Define a regex pattern to validate the username (only letters)
	        String usernameRegex = "^[A-Za-z]+$";
	        
	        // Use a regex pattern to validate the username
	        Pattern usernamePattern = Pattern.compile(usernameRegex);
	        Matcher usernameMatcher = usernamePattern.matcher(username);

	        // Check if the username is valid (contains only letters)
	        return usernameMatcher.matches();
	    }
	    
	    
	    public User login(LoginUser newLogin, BindingResult result) {

			Optional<User> optionalUser = userRepository.findByEmail(newLogin.getEmail());
	        
	    	
	    	if(!optionalUser.isPresent()) {
	    		result.rejectValue("email", "Matches", "User not found!");
	    		return null;
	    	}
	    
	    	User user = optionalUser.get();
	        
	   
	    	if(!BCrypt.checkpw(newLogin.getPassword(), user.getPassword())) {
	    	    result.rejectValue("password", "Matches", "Invalid Password!");
	    	}
	  
	    	
	    	if(result.hasErrors()) {
	    		return null;
	    	}
	    	
	        
	        return user;
	        
	    }

}
