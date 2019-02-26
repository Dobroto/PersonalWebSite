package edu.tu.springdemo.dao;

import java.util.List;

import edu.tu.springdemo.entity.Skill;

public interface SkillDAO {

	public List<Skill> getSkills();

	public void addSkill(Skill theSkill);

	public Skill getSkill(int theId);

	public void deleteSkill(int theId);
}
