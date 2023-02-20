package com.tian.dojos_ninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tian.dojos_ninjas.models.Dojo;
import com.tian.dojos_ninjas.models.Ninja;
import com.tian.dojos_ninjas.services.DojoService;
import com.tian.dojos_ninjas.services.NinjaService;


@Controller
public class MainController {
	@Autowired
	private DojoService dojoService;
	@Autowired
	private NinjaService ninjaService;
	
	//create Dojo
	//display form
	@GetMapping("/dojos/new")
	public String newDojo(
			@ModelAttribute("newDojo")Dojo dojo) {
		return "dojo.jsp";
	}
	//process form
	@PostMapping("/dojos/new")
	public String processNewDojo(
			@Valid @ModelAttribute("newDojo")Dojo dojo, BindingResult result,Model model
			) {	
		if (result.hasErrors()) {
            return "dojo.jsp";
        } else {
            dojoService.createDojo(dojo);
            return "redirect:/dojos/new";
        }
	}
	
	//create Ninja
	
	//display form
	@GetMapping("/ninjas/new")
	public String newNinja(
			@ModelAttribute("newNinja")Ninja ninja,Model model) {
		List<Dojo> dojoList=dojoService.allDojos();
		model.addAttribute("dojoList",dojoList);
		return "ninja.jsp";
	}
	
	//process form
	@PostMapping("/ninjas/new")
	public String processNewNinja(
			@Valid @ModelAttribute("newNinja")Ninja ninja, BindingResult result,Model model
			) {	
		if (result.hasErrors()) {
			List<Dojo> dojoList=dojoService.allDojos();
			model.addAttribute("dojoList",dojoList);
            return "ninja.jsp";
        } else {
            ninjaService.createNinja(ninja);
            return "redirect:/ninjas/new";
        }
	}
	
	//dojo_ninjas dash board 
	@GetMapping("/dojos/{id}")
	public String dojoNinjas(
			@PathVariable("id")Long id,
			Model model) {
		model.addAttribute("dojo",dojoService.oneDojo(id));
		return "dojo_ninjas.jsp";
	}
	
	
	
	


}
