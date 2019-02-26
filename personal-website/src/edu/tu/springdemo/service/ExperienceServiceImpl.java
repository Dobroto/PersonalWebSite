package edu.tu.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tu.springdemo.dao.ExperienceDAO;
import edu.tu.springdemo.entity.Experience;

@Service
public class ExperienceServiceImpl implements ExperienceService{

	@Autowired
	private ExperienceDAO experienceDAO;
	
	@Override
	@Transactional
	public List<Experience> getExperiences() {
		return experienceDAO.getExperiences();
	}

	@Override
	@Transactional
	public void addExperience(Experience theExperience) {
		experienceDAO.addExperience(theExperience);
	}

	@Override
	@Transactional
	public Experience getExperience(int theId) {
		return experienceDAO.getExperience(theId);
	}

	@Override
	@Transactional
	public void deleteExperience(int theId) {
		experienceDAO.deleteExperience(theId);
	}

}
