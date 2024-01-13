package com.ayah.burgertracker.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ayah.burgertracker.models.Burger;



public interface BurgerRepository extends CrudRepository<Burger, Long> {
	
	// this method retrieves all Burgers from the database
    List<Burger> findAll();

}
