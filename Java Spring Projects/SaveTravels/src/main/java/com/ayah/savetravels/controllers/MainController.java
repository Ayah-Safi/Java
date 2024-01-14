package com.ayah.savetravels.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import com.ayah.savetravels.models.Travel;
import com.ayah.savetravels.services.TravelService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	@Autowired
	TravelService travelService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("travel") Travel travel, Model model) {
		List<Travel> allExpenses = travelService.allTravels();
		model.addAttribute("allExpenses",allExpenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String processExpense(@Valid @ModelAttribute("travel") Travel travel,BindingResult result , Model model) {
		if(result.hasErrors()) {
			List<Travel> allExpenses = travelService.allTravels();
			model.addAttribute("allExpenses",allExpenses);
			return "index.jsp";
		}
		else {
			travelService.addTravelExpense(travel);
			return"redirect:/";
		}
	}
	// Route to show the edit form
    @GetMapping("/expenses/edit/{id}")
    public String edit(@PathVariable("id") Long id, Model model) {
        Travel travel = travelService.findTravel(id);
        if (travel == null) {
            return "redirect:/";
        }
        model.addAttribute("travel", travel);
        return "edit.jsp";
    }

    // Route to process the edit
    @PutMapping("/expenses/edit/{id}")
    public String updateExpense(@PathVariable("id") Long id, @Valid @ModelAttribute("travel") Travel travel, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "edit.jsp";
        } else {
            travelService.updateTravel(travel);
            return "redirect:/";
        }
    }
    
    // Route to delete an expense
    @GetMapping("/expenses/delete/{id}")
    public String deleteExpense(@PathVariable("id") Long id) {
        travelService.deleteTravel(id);
        return "redirect:/";
    }
    
    //Route to render expenses details
    @GetMapping("/expenses/show/{id}")
    public String showExpense(@PathVariable("id") Long id, Model model) {
    	Travel expense = travelService.findTravel(id);
    	model.addAttribute("expense",expense);
    	return "showExpense.jsp";	
    }

	
}

