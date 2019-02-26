package edu.tu.springdemo.dao;

import java.util.List;

import edu.tu.springdemo.entity.Education;

public interface EducationDAO {

	public List<Education> getEducations();

	public void addEducation(Education theEducation);

	public Education getEducation(int theId);

	public void deleteEducation(int theId);
}
