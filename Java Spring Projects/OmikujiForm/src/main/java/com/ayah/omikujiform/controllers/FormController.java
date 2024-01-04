package com.ayah.omikujiform.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class FormController {
	@RequestMapping("/omikuji")
	public String index() {
		return "form.jsp";
	}
	
	@GetMapping("/result")
	public String displayResult() {
		return "result.jsp";
	}
	
	
	@PostMapping("/send")
	public String formHandling(
			   	@RequestParam(value="number") Integer number,
			    @RequestParam(value="city") String city, 
			    @RequestParam(value="person") String person,
			    @RequestParam(value="endeavor") String endeavor,
			    @RequestParam(value="living_thing") String living_thing,
			    @RequestParam(value="nice_thing") String nice_thing,
			    HttpSession session
			    ) {
		
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("endeavor", endeavor);
		session.setAttribute("living_thing", living_thing);
		session.setAttribute("nice_thing", nice_thing);
		
		
		
		return "redirect:/result";
	}
	
	
	

}
