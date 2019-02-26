package edu.tu.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tu.springdemo.dao.EducationDAO;
import edu.tu.springdemo.entity.Education;

@Service
public class EducationServiceImpl implements EducationService{

	//need to inject education dao
	@Autowired
	private EducationDAO educationDAO;
	
	@Override
	@Transactional
	public List<Education> getEducations() {
		return educationDAO.getEducations();
	}

	@Override
	@Transactional
	public void addEducation(Education theEducation) {
		educationDAO.addEducation(theEducation);
	}

	@Override
	@Transactional
	public Education getEducation(int theId) {
		return educationDAO.getEducation(theId);
	}

	@Override
	@Transactional
	public void deleteEducation(int theId) {
		educationDAO.deleteEducation(theId);
	}

}
