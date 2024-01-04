package com.ayah.counter.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class Counter {
	@RequestMapping("/")
	public String index(HttpSession session) {
	
	// If the count is not already in session
	if (session.getAttribute("count") == null) {
	// Use setAttribute to initialize the count in session
		session.setAttribute("count",0);
	}
	else {
	// increment the count by 1 using getAttribute and setAttribute
		int count = (Integer) session.getAttribute("count")+1;
		session.setAttribute("count",count);
	}
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String counter() {
		return "counter.jsp";
	}
	
	//	Ninja Bonus: Increment the count by 2
    @RequestMapping("/doubleCounter")
    public String doubleCounter(HttpSession session) {
    	
        if (session.getAttribute("count") == null) {
            session.setAttribute("count", 0);
        } else {
            int count = (Integer) session.getAttribute("count") + 2;
            session.setAttribute("count", count);
        }
        return "doubleCounter.jsp";
    }
    
    
}
