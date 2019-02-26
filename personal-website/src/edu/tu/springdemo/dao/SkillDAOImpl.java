package edu.tu.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tu.springdemo.entity.Education;
import edu.tu.springdemo.entity.Skill;

@Repository
public class SkillDAOImpl implements SkillDAO {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Skill> getSkills() {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Skill> theQuery = currentSession.createQuery("from Skill", Skill.class);
		
		//execute query and get result list
		List<Skill> skills = theQuery.getResultList();
		
		//return the results
		return skills;
	}

	@Override
	public void addSkill(Skill theSkill) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//add/update the skill
		currentSession.saveOrUpdate(theSkill);
	}

	@Override
	public Skill getSkill(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using the primary key
		Skill theSkill = currentSession.get(Skill.class, theId);
		
		return theSkill;
	}

	@Override
	public void deleteSkill(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Skill where id=:skillId");
		
		theQuery.setParameter("skillId", theId);
		
		theQuery.executeUpdate();
	}

}
