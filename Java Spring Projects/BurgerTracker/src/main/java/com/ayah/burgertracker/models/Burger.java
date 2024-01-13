package com.ayah.burgertracker.models;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="burger")
public class Burger {
	
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    @NotNull
	    @Size(min=1, max=255, message="Burger name must not be null")
	    private String burgerName;
	    
	    @NotNull
	    @Size(min=1, max=255, message="Restaurant name must not be null")
	    private String resturantName;
	    
	    @NotNull
	    @Min(value=1, message="Rating should be greater than 0 and less than 5.")
	    @Max(value=5, message="Rating should be greater than 0 and less than 5.")
	    private Integer rating;
	   
	    @NotNull
	    @Size(min = 5, max = 500, message="Please fill the notes, it's required to submit the form.")
	    private String notes;
	    
	    // This will not allow the createdAt column to be updated after creation
	    @Column(updatable=false)
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date createdAt;
	    
	    @DateTimeFormat(pattern="yyyy-MM-dd")
	    private Date updatedAt;
	    
	    public Burger() {
	    	
	    }
	    
	    public Burger(String burgerName, String resturantName, Integer rating, String notes) {
	        this.burgerName = burgerName;
	        this.resturantName = resturantName;
	        this.rating = rating;
	        this.notes = notes;
	    }
	    
		//getters and setters
	    public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getBurgerName() {
			return burgerName;
		}
		public void setBurgerName(String burgerName) {
			this.burgerName = burgerName;
		}
		public String getResturantName() {
			return resturantName;
		}
		public void setResturantName(String resturantName) {
			this.resturantName = resturantName;
		}
		public Integer getRating() {
			return rating;
		}
		public void setRating(Integer rating) {
			this.rating = rating;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public Date getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Date createdAt) {
			this.createdAt = createdAt;
		}
		public Date getUpdatedAt() {
			return updatedAt;
		}
		public void setUpdatedAt(Date updatedAt) {
			this.updatedAt = updatedAt;
		}
		@PrePersist
		protected void onCreate(){
		   this.createdAt = new Date();
		}
		@PreUpdate
	    protected void onUpdate(){
	        this.updatedAt = new Date();
	    }
	}


