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

import edu.tu.springdemo.entity.Skill;
import edu.tu.springdemo.service.SkillService;

@Controller
@RequestMapping("/skill")
public class SkillController {

	@Autowired
	private SkillService skillService;
	
	@GetMapping("/list")
	public String listSkills(Model theModel) {
		
		//get educations from service
		List<Skill> theSkills = skillService.getSkills();
		
		//add the customers to the model
		theModel.addAttribute("skills", theSkills);
		
		return "list-skills";
	}
	
	@GetMapping("/showFormForAdd")
	public String showFormForAdd(Model theModel) {
		
		//create model attribute to bind form data
		Skill theSkill = new Skill();
		
		theModel.addAttribute("skill", theSkill);
		
		return "skill-form";
	}
	
	@PostMapping("/addSkill")
	public String addSkill(@ModelAttribute("skill") Skill theSkill) {
		
		//save the education using our service
		skillService.addSkill(theSkill);
		return "redirect:/skill/list";
	}
	
	@GetMapping("/showFormForUpdate")
	public String showFormForUpdate(@RequestParam("skillId") int theId, Model theModel) {
		
		//get the education from our service
		Skill theSkill = skillService.getSkill(theId);
		
		//set education as a model attribute to pre-populate the form
		theModel.addAttribute("skill", theSkill);
		
		//send over to our form
		return "skill-form";
	}
	
	@GetMapping("/delete")
	public String deleteSkill(@RequestParam("skillId") int theId) {
		//delete the education
		skillService.deleteSkill(theId);
		
		return "redirect:/skill/list";
	}

}
