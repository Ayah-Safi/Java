package com.ayah.savetravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ayah.savetravels.models.Travel;


public interface TravelRepository  extends CrudRepository<Travel, Long> {
	
	// this method retrieves all Travels from the database
    List<Travel> findAll();

}
