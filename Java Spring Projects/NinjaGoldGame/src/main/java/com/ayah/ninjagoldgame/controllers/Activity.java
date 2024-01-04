package com.ayah.ninjagoldgame.controllers;

public class Activity {
	private String text;
    private String color;

    // Constructor
    public Activity(String text, String color) {
        this.text = text;
        this.color = color;
    }

    // Getters and Setters
    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}


