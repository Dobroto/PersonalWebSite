package edu.tu.springdemo.service;

import java.util.List;

import edu.tu.springdemo.entity.Experience;

public interface ExperienceService {
	
	public List<Experience> getExperiences();

	public void addExperience(Experience theExperience);

	public Experience getExperience(int theId);

	public void deleteExperience(int theId);
}
