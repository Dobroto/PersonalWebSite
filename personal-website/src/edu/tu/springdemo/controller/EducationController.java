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

import edu.tu.springdemo.entity.Education;
import edu.tu.springdemo.service.EducationService;

@Controller
@RequestMapping("/education")
public class EducationController {

	//need to inject our customer service
	@Autowired
	private EducationService educationService;
	
	@GetMapping("/list")
	public String listEducations(Model theModel) {
		
		//get educations from service
		List<Education> theEducations = educationService.getEducations();
		
		//add the customers to the model
		theModel.addAttribute("educations", theEducations);
		
		return "list-educations";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Education theEducation = new Education();
		
		theModel.addAttribute("education", theEducation);
		
		return "education-form";
	}
	
	@PostMapping("/addEducation")
	public String addEducation(@ModelAttribute("education") Education theEducation) {
		
		//save the education using our service
		educationService.addEducation(theEducation);
		return "redirect:/education/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("educationId") int theId, Model theModel) {
		
		//get the education from our service
		Education theEducation = educationService.getEducation(theId);
		
		//set education as a model attribute to pre-populate the form
		theModel.addAttribute("education", theEducation);
		
		//send over to our form
		return "education-form";
	}
	
	@GetMapping("/delete")
	public String deleteEducation(@RequestParam("educationId") int theId) {
		//delete the education
		educationService.deleteEducation(theId);
		
		return "redirect:/education/list";
	}

}










