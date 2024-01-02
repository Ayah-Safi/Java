package com.ayah.hellohuman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class HelloHumanApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloHumanApplication.class, args);
		}
	 @RequestMapping("/")
	 public String index() {
         return "Hello Human";
 }
	 
	@RequestMapping("/fname")
	public String indexFirstName(@RequestParam(value="fname") String firstName){
        return "Hello, "+ firstName;
    }
	
	@RequestMapping("/fnamelname")
	public String indexFirstandLastNames(@RequestParam(value="fname") String firstName,@RequestParam(value="lname") String lastName) {
        return "Hello, "+ firstName + " " + lastName;
    }
	
	@RequestMapping("/times")
	public String indexTimes(@RequestParam(value="fname") String firstName, @RequestParam(value="times") Integer times) {
		String displayMessage = "";
		for (int i = 0; i < times;i++) {
			displayMessage += "Hello "+firstName+" ";
		}
		return displayMessage;
	}

}
