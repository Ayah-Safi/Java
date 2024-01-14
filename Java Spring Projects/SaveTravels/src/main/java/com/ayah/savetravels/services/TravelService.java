package com.ayah.savetravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ayah.savetravels.models.Travel;
import com.ayah.savetravels.repositories.TravelRepository;



@Service
public class TravelService {
	
	@Autowired
    private final TravelRepository travelRepository;
    
    public TravelService(TravelRepository travelRepository) {
        this.travelRepository = travelRepository;
    }
    
    // returns all the Travels
    public List<Travel> allTravels() {
        return travelRepository.findAll();
    }
    // creates a Travel
    public Travel addTravelExpense(Travel Travel) {
        return travelRepository.save(Travel);
    }
    // retrieves a Travel
    public Travel findTravel(Long id) {
        Optional<Travel> optionalTravel = travelRepository.findById(id);
        if(optionalTravel.isPresent()) {
            return optionalTravel.get();
        } else {
            return null;
        }
    }
	public Travel updateTravel(Travel travel) {
		    Optional<Travel> optionalTravel = travelRepository.findById(travel.getId());
		    
		    
	        if(optionalTravel.isPresent()) {
	        	
		        travel.setExpensesName(travel.getExpensesName());
		        travel.setVendor(travel.getVendor());
		        travel.setAmount(travel.getAmount());
		        travel.setDescription(travel.getDescription());
		        return  travelRepository.save(travel);
	        
	        } else {
	        	
	            return null;
	        }
	    }
	
	public void deleteTravel(Long id) {
		travelRepository.deleteById(id);
		
	}
	

}
