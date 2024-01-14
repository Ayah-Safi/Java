package com.ayah.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ayah.dojosandninjas.models.Ninja;

public interface NinjaRepository extends CrudRepository <Ninja, Long>  {
	
	// this method retrieves all ninjas from the database
    List<Ninja> findAll();


}
