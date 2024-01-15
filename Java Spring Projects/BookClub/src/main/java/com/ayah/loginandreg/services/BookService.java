package com.ayah.loginandreg.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayah.loginandreg.models.Book;
import com.ayah.loginandreg.repositories.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public BookService(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public List<Book> allBooks() {
		return bookRepository.findAll();
	}

	// creates a User
	public Book createBook(Book book) {
		return bookRepository.save(book);
	}

	// retrieves a User
	public Book findBook(Long id) {
		Optional<Book> optionalBook = bookRepository.findById(id);
		if (optionalBook.isPresent()) {
			return optionalBook.get();
		} else {
			return null;
		}
	}
	// updates a Book
	public Book updateBook(Long bookId, Book updatedBook) {
	    Optional<Book> optionalBook = bookRepository.findById(bookId);
	    if (optionalBook.isPresent()) {
	        Book book = optionalBook.get();
	        // Update the book properties with the values from updatedBook
	        book.setTitle(updatedBook.getTitle());
	        book.setAuthor(updatedBook.getAuthor());
	        book.setThoughts(updatedBook.getThoughts());
	        return bookRepository.save(book);
	    } else {
	        return null; // Book with the specified ID not found
	    }
	}
	// delete a User
	public void deleteBook(Long id) {
		bookRepository.deleteById(id);

	}
}
