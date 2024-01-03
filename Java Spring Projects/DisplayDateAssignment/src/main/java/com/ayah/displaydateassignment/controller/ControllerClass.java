package com.ayah.displaydateassignment.controller;

import java.text.SimpleDateFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.Date;

@Controller
public class ControllerClass {
	@RequestMapping("/")
	public String home() {
		return "home.jsp";
	}
	@RequestMapping("/date")
	public String date(Model model) {
		 String formattedDate = new SimpleDateFormat("EEEE, MMM d, yyyy").format(new Date());
		 model.addAttribute("date", formattedDate);
		 return "date.jsp";
	}
	@RequestMapping("/time")
	public String time(Model model) {
		String formattedTime = new SimpleDateFormat("h:mm a").format(new Date());
	    model.addAttribute("time", formattedTime);
		return "time.jsp";
	}
	

	

}
