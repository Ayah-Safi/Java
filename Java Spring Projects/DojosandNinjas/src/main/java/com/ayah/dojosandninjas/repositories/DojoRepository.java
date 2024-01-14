package com.ayah.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ayah.dojosandninjas.models.Dojo;

public interface DojoRepository extends CrudRepository<Dojo, Long> {
	
	// this method retrieves all dojos from the database
    List<Dojo> findAll();

}
