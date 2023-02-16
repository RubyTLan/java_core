package com.tian.omikuji_form.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class OmikujiController {
	
	@GetMapping("/omikuji")
	public String omikujiForm() {
		return "/form/form.jsp";
	}
	@PostMapping("/session")
	public String sessionForm(
			@RequestParam("number")Integer number,
			@RequestParam("city")String city,
			@RequestParam("name")String name,
			@RequestParam("hobby")String hobby,
			@RequestParam("living")String living,
			@RequestParam("nice")String nice,			
			HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("name", name);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("nice", nice);
		
		return "redirect:/omikuji/show";		
	}
	
	@GetMapping("/omikuji/show")
	public String omikujiResult() {
		return "/form/display.jsp";
	}

}
