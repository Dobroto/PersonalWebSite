package edu.tu.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tu.springdemo.entity.Experience;

@Repository
public class ExperienceDAOImpl implements ExperienceDAO{

	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Experience> getExperiences() {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query<Experience> theQuery = currentSession.createQuery("from Experience", Experience.class);
		
		List<Experience> experiences = theQuery.getResultList();
		
		return experiences;
	}

	@Override
	public void addExperience(Experience theExperience) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		currentSession.saveOrUpdate(theExperience);
	}

	@Override
	public Experience getExperience(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Experience theExperience = currentSession.get(Experience.class, theId);
		
		return theExperience;
	}

	@Override
	public void deleteExperience(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Experience where id=:experienceId");
		
		theQuery.setParameter("experienceId", theId);
		
		theQuery.executeUpdate();
	}

}
