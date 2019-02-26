package edu.tu.springdemo.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tu.springdemo.dao.SkillDAO;
import edu.tu.springdemo.entity.Skill;

@Service
public class SkillServiceImpl implements SkillService{

	@Autowired
	private SkillDAO skillDAO;
	
	@Override
	@Transactional
	public List<Skill> getSkills() {
		return skillDAO.getSkills();
	}

	@Override
	@Transactional
	public void addSkill(Skill theSkill) {
		skillDAO.addSkill(theSkill);
	}

	@Override
	@Transactional
	public Skill getSkill(int theId) {
		return skillDAO.getSkill(theId);
	}

	@Override
	@Transactional
	public void deleteSkill(int theId) {
		skillDAO.deleteSkill(theId);
	}
}
