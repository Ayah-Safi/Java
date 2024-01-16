package com.ayah.qnj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ayah.qnj.services.ApiService;

@Controller
public class MainController {
	@Autowired
	private ApiService apiService;
	
	@RequestMapping("/")
	public String index(Model model) {
		List<Object[]> sloveneSpeakingCountries = apiService.sloveneSpeakingCountries();
		model.addAttribute("sloveneSpeakingCountries", sloveneSpeakingCountries);
		
		List<Object[]> citiesPerCountry = apiService.citiesPerCountry();
		model.addAttribute("citiesPerCountry", citiesPerCountry);
		
		List<Object[]> mexicanCityPop = apiService.mexicanCityPop();
		model.addAttribute("mexicanCityPop", mexicanCityPop);
		
		List<Object[]> countryLanguages = apiService.countryLanguages();
		model.addAttribute("countryLanguages", countryLanguages);
		
		List<Object[]> countrySurfaceArea = apiService.countrySurfaceArea();
		model.addAttribute("countrySurfaceArea", countrySurfaceArea);
		
		List<Object[]> constitutionalMonarchies = apiService.constitutionalMonarchies();
		model.addAttribute("constitutionalMonarchies", constitutionalMonarchies);
		
		List<Object[]> argentinaCities = apiService.argentinaCities();
		model.addAttribute("argentinaCities", argentinaCities);
		
		List<Object[]> countriesPerRegion = apiService.countriesPerRegion();
		model.addAttribute("countriesPerRegion", countriesPerRegion);
		
		return "index.jsp";
	}
}