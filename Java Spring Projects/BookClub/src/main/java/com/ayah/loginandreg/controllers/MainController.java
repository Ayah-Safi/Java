package com.ayah.loginandreg.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.ayah.loginandreg.models.Book;
import com.ayah.loginandreg.models.LoginUser;
import com.ayah.loginandreg.models.User;
import com.ayah.loginandreg.services.BookService;
import com.ayah.loginandreg.services.UserService;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;

@Controller
public class MainController {

	// Add once service is implemented:
	@Autowired
	UserService userService;
	@Autowired
	BookService bookService;

	public MainController(BookService bookService) {
		this.bookService = bookService;
	}

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
		// Check if the user is logged in (e.g., by checking if a specific attribute
		// exists in the session)
		if (session.getAttribute("userId") == null) {
			// User is not logged in, so redirect them to the login and registration page
			return "redirect:/";
		} else {
			// Get the user ID from the session
			Long userId = (Long) session.getAttribute("userId");
			// Use the user ID to retrieve the user from your userService
			User currentUser = userService.getUser(userId);
			List<Book> allBook = bookService.allBooks();
			model.addAttribute("currentUser",currentUser);
			model.addAttribute("allBooks", allBook);
			return "home.jsp";
		}

	}

	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("newUser") User newUser, BindingResult result, Model model,
			HttpSession session) {

		// TO-DO Later -- call a register method in the service
		// to do some extra validations and create a new user!
		User user = userService.register(newUser, result);

		if (result.hasErrors()) {
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
	public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin, BindingResult result, Model model,
			HttpSession session) {

		// Add once service is implemented:
		User user = userService.login(newLogin, result);

		if (result.hasErrors()) {
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

	@GetMapping("/addBook")
	public String addBook(HttpSession session, Model model) {
		// Check if the user is logged in (e.g., by checking if a specific attribute
		// exists in the session)
		if (session.getAttribute("userId") == null) {
			// User is not logged in, so redirect them to the login and registration page
			return "redirect:/";
		} else {
			model.addAttribute("book", new Book());
			return "addBook.jsp";
		}

	}

	@PostMapping("/addBook")
	public String addBook(@Valid @ModelAttribute("book") Book book, BindingResult result, HttpSession session,
			Model model) {
		if (result.hasErrors()) {
			return "addBook.jsp";
		} else {
			// Get the user ID from the session
			Long userId = (Long) session.getAttribute("userId");
			// Use the user ID to retrieve the user from your userService
			User currentUser = userService.getUser(userId);
			book.setUser(currentUser);
			bookService.createBook(book);
			session.setAttribute("successMessage", "Book added successfully");
			return "redirect:/home"; // Redirect to the home page
		}
	}

	@GetMapping("/showBook/{bookId}")
	public String showBook(@PathVariable("bookId") Long bookId, HttpSession session, Model model) {
		// Check if the user is logged in (e.g., by checking if a specific attribute
		// exists in the session)
		if (session.getAttribute("userId") == null) {
			// User is not logged in, so redirect them to the login and registration page
			return "redirect:/";
		} else {
			// Fetch the user
			Long userId = (Long) session.getAttribute("userId"); // Assuming userId is stored in the session
			// Fetch the book
			Book book = bookService.findBook(bookId);
			if (book != null && book.getUser() != null && book.getUser().getId().equals(userId)) {
				// The book was posted by the logged-in user
				model.addAttribute("book", book);
				return "showBookOfLoggedUser.jsp";
			} else {
				model.addAttribute("book", book);
				return "showBook.jsp";
			}

		}
	}

	@GetMapping("/editBook/{editId}")
	public String editBook(@PathVariable("editId") Long editId,HttpSession session, Model model) {
		// Check if the user is logged in (e.g., by checking if a specific attribute
		// exists in the session)
		if (session.getAttribute("userId") == null) {
			// User is not logged in, so redirect them to the login and registration page
			return "redirect:/";
		} else {
			Book book = bookService.findBook(editId);
			model.addAttribute("book", book);
			return "editBook.jsp";
		}

	}
	@PutMapping("/updateBook/{bookId}")
	public String editBook(@PathVariable("bookId") Long bookId, @Valid @ModelAttribute("book") Book book,
	                       HttpSession session, Model model) {
	    // Check if the user is logged in (e.g., by checking if a specific attribute
	    // exists in the session)
	    if (session.getAttribute("userId") == null) {
	        // User is not logged in, so redirect them to the login and registration page
	        return "redirect:/";
	    } else {
	       
	        // Update the book with the new information
	        bookService.updateBook(bookId, book);
	        return "redirect:/home"; // Redirect to the home page after updating the book
	    }
	}
	
	@GetMapping("/deleteBook/{deleteId}")
	public String deleteBook(@PathVariable("deleteId") Long deleteId, HttpSession session) {
	    // Check if the user is logged in (e.g., by checking if a specific attribute
	    // exists in the session)
	    if (session.getAttribute("userId") == null) {
	        // User is not logged in, so redirect them to the login and registration page
	        return "redirect:/";
	    } else {
	        // Perform the deletion of the book with the specified deleteId
	        bookService.deleteBook(deleteId);
	        return "redirect:/home"; // Redirect to the home page after deleting the book
	    }
	}


}
