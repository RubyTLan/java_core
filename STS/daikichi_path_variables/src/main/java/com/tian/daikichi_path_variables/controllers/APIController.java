package com.tian.daikichi_path_variables.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/daikichi")

public class APIController {
	
	@RequestMapping("/")//by default it is a GET
	public String daikichi(){
		return "welcome";
	}
	
	@RequestMapping("/today")
	public String today(){
		return "Today is good luck!";
	}
	
	@RequestMapping("/tomorrow")
	public String tomorrow(){
		return "Tomorrow an opportunity!";
	}
	
	@RequestMapping(value="/travel/{city}", method=RequestMethod.GET)
	public String travel(@PathVariable("city")String city){
		return "Congratulations! You will soon travel to "+city;
	}
	
	@GetMapping("/lotto/{number}")//GetMapping,PostMapping,PutMapping,DeleteMapping
	public String lotto(@PathVariable("number")Integer num){
		if(num%2==0) {
			return "You will take a grand journey in the near future, but be weary of tempting offers";			
		}else {
			return "You have enjoyed the fruits of your labor but now is a great time to spend time with family and friends.";
		}
	}


}
