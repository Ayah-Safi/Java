package com.ayah.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import com.ayah.dojosandninjas.models.Dojo;
import org.springframework.stereotype.Service;
import com.ayah.dojosandninjas.repositories.DojoRepository;


@Service
public class DojoService {
	
	@Autowired
    private final DojoRepository dojoRepository;
	
	
    public DojoService(DojoRepository dojoRepository) {
        this.dojoRepository = dojoRepository;
    }
    
    // returns all the Travels
    public List<Dojo> allDojos() {
        return dojoRepository.findAll();
    }
    // creates a Travel
    public Dojo addDojos(Dojo dojo) {
        return dojoRepository.save(dojo);
    }
    // retrieves a Travel
    public Dojo findDojo(Long id) {
        Optional<Dojo> optionalTravel = dojoRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
	public Dojo updateDojo(Dojo dojo) {
		    Optional<Dojo> optionalTravel = dojoRepository.findById(dojo.getId());
		    
	        if(optionalTravel.isPresent()) {
		        dojo.setName(dojo.getName());
		        return  dojoRepository.save(dojo);
	        
	        } else {
	        	
	            return null;
	        }
	    }
	
	public void deleteDojo(Long id) {
		dojoRepository.deleteById(id);
		
	}
}