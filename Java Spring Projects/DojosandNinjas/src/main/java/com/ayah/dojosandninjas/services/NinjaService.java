package com.ayah.dojosandninjas.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ayah.dojosandninjas.models.Ninja;
import com.ayah.dojosandninjas.repositories.NinjaRepository;


@Service
public class NinjaService {
	

    private final NinjaRepository ninjaRepository;
	
	
    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }
    
    // returns all the Ninjas
    public List<Ninja> allNinjas() {
        return ninjaRepository.findAll();
    }
    // creates a Ninja
    public Ninja addNinja(Ninja ninja) {
        return ninjaRepository.save(ninja);
    }
    // retrieves a Ninjas
    public Ninja findNinja(Long id) {
        Optional<Ninja> optionalNinja = ninjaRepository.findById(id);
        if(optionalNinja.isPresent()) {
            return optionalNinja.get();
        } else {
            return null;
        }
    }
	public Ninja updateNinja(Ninja ninja) {
		Optional<Ninja> optionalNinja = ninjaRepository.findById(ninja.getId());
		    
	        if(optionalNinja.isPresent()) {
		        ninja.setfName(ninja.getfName());
		        return  ninjaRepository.save(ninja);
	        
	        } else {
	        	
	            return null;
	        }
	    }
	
	public void deleteNinja(Long id) {
		ninjaRepository.deleteById(id);
		
	}
}