package com.ayah.loginandreg.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ayah.loginandreg.models.LoginUser;
import com.ayah.loginandreg.models.User;
import com.ayah.loginandreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {
	
	 // Add once service is implemented:
     @Autowired
     UserService userService;
	
     @GetMapping("/")
     public String index(Model model) {
    
        // Bind empty User and LoginUser objects to the JSP
        // to capture the form input
         model.addAttribute("newUser", new User());
         model.addAttribute("newLogin", new LoginUser());
         return "index.jsp";
     }
     
     @GetMapping("/home")
     public String successPage(HttpSession session, Model model) {
    	 // Check if the user is logged in (e.g., by checking if a specific attribute exists in the session)
    	    if (session.getAttribute("userId") == null) {
    	        // User is not logged in, so redirect them to the login and registration page
    	        return "redirect:/";
    	    }
    	    else {
    	    	 return "home.jsp";
    	    }
    	
     }
     
     
     @PostMapping("/register")
     public String register(@Valid @ModelAttribute("newUser") User newUser, 
             BindingResult result,
             Model model,
             HttpSession session) {
         
         // TO-DO Later -- call a register method in the service 
         // to do some extra validations and create a new user!
    	 User user = userService.register(newUser, result);
    	 
         if(result.hasErrors()) {
             // Be sure to send in the empty LoginUser before 
             // re-rendering the page.
             model.addAttribute("newLogin", new LoginUser());
             return "index.jsp";
         }
         	
         else {
        	 
        	 // No errors! 
             // TO-DO Later: Store their ID from the DB in session, 
             // in other words, log them in.
        	 session.setAttribute("userId", user.getId());
        	 session.setAttribute("userName", user.getUserName());
        	 return "redirect:/home";
         }
     }
	
     
     @PostMapping("/login")
     public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, 
             BindingResult result, Model model, HttpSession session) {
         
         // Add once service is implemented:
          User user = userService.login(newLogin, result);
     
         if(result.hasErrors()) {
             model.addAttribute("newUser", new User());
             return "index.jsp";
         }
     
         // No errors! 
         // TO-DO Later: Store their ID from the DB in session, 
         // in other words, log them in.
         session.setAttribute("userId", user.getId());
         session.setAttribute("userName", user.getUserName());
         return "redirect:/home";
     }
     
     @GetMapping("/logout")
     public String logout(HttpSession session) {
         // Clear the user's session
         session.invalidate();
         
         // Redirect the user to the login and registration page
         return "redirect:/";
     }
     

}
