package com.ayah.ninjagoldgame.controllers;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;

@Controller
public class NinjaController {
	private static final int debtLimit = -50;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
        if (session.getAttribute("gold") == null) {
            session.setAttribute("gold", 0);
        }
        return "index.jsp";
    }
	@RequestMapping("/debtorsPrison")
	public String debtorsPrison(HttpSession session, Model model) {
	    // You can add any logic here specific to the debtors' prison view
	    return "debtorsPrison.jsp";
	}
	@PostMapping("/earn")
	public String earnGold(
            @RequestParam(value="whichform") String location,
            HttpSession session, Model model) {
        
        // Get the current gold from the session or initialize to 0 if not present
        Integer gold = (Integer) session.getAttribute("gold");
        if (gold == null) {
            gold = 0;
        }
        
        Random rand = new Random();
        Integer earnedGold = 0;
        String activity;
        String color = null;
        SimpleDateFormat date =  new SimpleDateFormat("MMMM d Y h:mm a");
        Date currentDate = new Date();

        switch (location) {
            case "farm":
                earnedGold = rand.nextInt(10,21); 
                String farmDate = date.format(currentDate);
                activity = "You entered a farm and earned " + earnedGold + " gold. " + "(" + farmDate + ")";
                color  = "green";
                if (gold < debtLimit) {
                    return "redirect:/debtorsPrison";
                }
                break;
            case "cave":
            	String caveDate = date.format(currentDate);
                activity = "You entered a cave and earned " + earnedGold + " gold." + "(" + caveDate + ")";
                color  = "green";
                if (gold < debtLimit) {
                    return "redirect:/debtorsPrison";
                }
                break;
            case "house":
            	String houseDate = date.format(currentDate);
                earnedGold = rand.nextInt(2,6); 
                activity = "You entered a house and earned " + earnedGold + " gold." + "(" + houseDate + ")";;
                color  = "green";
                if (gold < debtLimit) {
                    return "redirect:/debtorsPrison";
                }
                break;
            case "quest":
            	String questDate = date.format(currentDate);
                earnedGold = rand.nextInt(-50,50);
                if (earnedGold >= 0) {
                    activity = "You completed a quest and earned " + earnedGold + " gold." + "(" + questDate + ")";;
                    color  = "green";
                } else {
                    activity = "You failed a quest and lost " + Math.abs(earnedGold) + " gold. Ouch" + "(" + questDate + ")";;
                    color  = "red";
                }
                if (gold < debtLimit) {
                    return "redirect:/debtorsPrison";
                }
                break;
            case "spa":
            	String spaDate = date.format(currentDate);
                earnedGold = rand.nextInt(-20,-5); 
                activity = "You entered a spa and lost " + Math.abs(earnedGold) + " gold." + "(" + spaDate + ")";;
                color  = "red";
                if (gold < debtLimit) {
                    return "redirect:/debtorsPrison";
                }
                break;
            case "reset":
            	session.invalidate();
                return "redirect:/";
            default:
                activity = "Unknown location. No gold earned.";
                break;
        }
        
        
        gold += earnedGold;
        session.setAttribute("gold", gold);

        @SuppressWarnings("unchecked")
        List<Activity> activities = (List<Activity>) session.getAttribute("activities");
        if (activities == null) {
            activities = new ArrayList<>();
        } else {
            Collections.reverse(activities);
        }
        activities.add(0, new Activity(activity, color));
        session.setAttribute("activities", activities);
        session.setAttribute("color",color);
  

        model.addAttribute("color",color);
        model.addAttribute("gold", gold);
        model.addAttribute("activities", activities);
        
        return "redirect:/";
    }
}