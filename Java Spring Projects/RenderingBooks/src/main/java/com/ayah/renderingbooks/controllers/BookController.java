package com.ayah.renderingbooks.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ayah.renderingbooks.models.Book;
import com.ayah.renderingbooks.services.BookService;

@Controller
public class BookController {
	
	 private final BookService bookService;
	    public BookController(BookService bookService){
	        this.bookService = bookService;
	    }
	
	 @RequestMapping("/books/{id}")
	 public String index(@PathVariable("id") Long id,Model model) {
		 
		 Book book = bookService.findBook(id);
		 String title =  book.getTitle();
		 String  desc = book.getDescription();
		 String langauge = book.getLanguage();
		 Integer numOfPages = book.getNumberOfPages();
		 
		 model.addAttribute("title", title);
		 model.addAttribute("desc", desc);
		 model.addAttribute("langauge", langauge);
		 model.addAttribute("numOfPages", numOfPages);
		 return "show.jsp";
	 }
	 //This method return all books and send them to the front end
	 @RequestMapping("/books")
	    public String index(Model model) {
	        List<Book> books = bookService.allBooks();
	        model.addAttribute("books", books);
	        return "booksTable.jsp";
	    }

}
