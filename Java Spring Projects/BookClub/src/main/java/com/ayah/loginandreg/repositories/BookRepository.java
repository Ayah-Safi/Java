package com.ayah.loginandreg.repositories;


import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.ayah.loginandreg.models.Book;


@Repository
public interface BookRepository extends CrudRepository<Book, Long>{
	
	// this method retrieves all books from the database
    List<Book> findAll();
    

}
