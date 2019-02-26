package edu.tu.springdemo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import edu.tu.springdemo.entity.Experience;
import edu.tu.springdemo.service.ExperienceService;

@Controller
@RequestMapping("/experience")
public class ExperienceController {

	@Autowired
	private ExperienceService experienceService;
	
	@GetMapping("/list")
	public String listExperiences(Model theModel) {
		
		//get experiences from service
		List<Experience> theExperiences = experienceService.getExperiences();
		
		//add the customers to the model
		theModel.addAttribute("experiences", theExperiences);
		
		return "list-work-experiences";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Experience theExperience = new Experience();
		
		theModel.addAttribute("experience", theExperience);
		
		return "experience-form";
	}
	
	@PostMapping("/addExperience")
	public String addExperience(@ModelAttribute("experience") Experience theExperience) {
		
		//save the experience using our service
		experienceService.addExperience(theExperience);
		return "redirect:/experience/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("experienceId") int theId, Model theModel) {
		
		//get the experience from our service
		Experience theExperience = experienceService.getExperience(theId);
		
		//set experience as a model attribute to pre-populate the form
		theModel.addAttribute("experience", theExperience);
		
		//send over to our form
		return "experience-form";
	}
	
	@GetMapping("/delete")
	public String deleteExperience(@RequestParam("experienceId") int theId) {
		//delete the experience
		experienceService.deleteExperience(theId);
		
		return "redirect:/experience/list";
	}
}
