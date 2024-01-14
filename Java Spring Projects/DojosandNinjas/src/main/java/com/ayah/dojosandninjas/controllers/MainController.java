package com.ayah.dojosandninjas.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.ayah.dojosandninjas.models.Dojo;
import com.ayah.dojosandninjas.models.Ninja;
import com.ayah.dojosandninjas.services.DojoService;
import com.ayah.dojosandninjas.services.NinjaService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	DojoService dojoService;
	@Autowired
	NinjaService ninjaService;
	
	@GetMapping("/")
	public String index(@ModelAttribute("dojo") Dojo dojo) {
		return "dojo.jsp";
	}
	
	@PostMapping("/dojos/new")
	public String addDojo(@Valid @ModelAttribute("dojo") Dojo dojo,
			BindingResult result) {
		if(result.hasErrors()) {
			return"dojo.jsp";
		}
		else {
			dojoService.addDojos(dojo);
			return "redirect:/";
			
		}
	}
	
	@GetMapping("ninjas/new")
	public String ninja(@ModelAttribute("ninja") Ninja ninja, Model model) {
		List<Dojo> allDojos = dojoService.allDojos();
		model.addAttribute("allDojos", allDojos);
		return "ninja.jsp";
	}
	
    @PostMapping("/ninjas/new")
    public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result) {
    		ninjaService.addNinja(ninja);
	    	return "redirect:/ninjas/new";
    }
    
	
	@GetMapping("dojo/{id}")
	public String displayDojo(@PathVariable("id") Long id, Model model){
		Dojo dojo = dojoService.findDojo(id);
		model.addAttribute("dojo",dojo);
		return "locations.jsp";
	}

}
