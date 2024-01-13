package com.ayah.burgertracker.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.ayah.burgertracker.models.Burger;
import com.ayah.burgertracker.repositories.BurgerRepository;


@Service
public class BurgerService {
	
    private final BurgerRepository burgerRepository;
    
    public BurgerService(BurgerRepository burgerRepository) {
        this.burgerRepository = burgerRepository;
    }
    
    // returns all the Burgers
    public List<Burger> allBurgers() {
        return burgerRepository.findAll();
    }
    // creates a Burger
    public Burger addBurger(Burger burger) {
        return burgerRepository.save(burger);
    }
    // retrieves a Burger
    public Burger findBurger(Long id) {
        Optional<Burger> optionalBurger = burgerRepository.findById(id);
        if(optionalBurger.isPresent()) {
            return optionalBurger.get();
        } else {
            return null;
        }
    }
	public Burger updateBurger(Long id, String burgerName, String resturantName, Integer rating, String notes) {
		 Optional<Burger> optionalBurger = burgerRepository.findById(id);
	        if(optionalBurger.isPresent()) {
	        Burger BurgertoUpdate =  optionalBurger.get();
	        BurgertoUpdate.setBurgerName(burgerName);
	        BurgertoUpdate.setResturantName(resturantName);
	        BurgertoUpdate.setRating(rating);
	        BurgertoUpdate.setNotes(notes);
	        return  burgerRepository.save(BurgertoUpdate);       
	        } else {
	            return null;
	        }
	    }
	
	public void deleteBurger(Long id) {
		burgerRepository.deleteById(id);
		
	}

}
