package edu.tu.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.tu.springdemo.entity.Education;

@Repository
public class EducationDAOImpl implements EducationDAO{

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Education> getEducations() {

		//get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//create a query
		Query<Education> theQuery = currentSession.createQuery("from Education", Education.class);
		
		//execute query and get result list
		List<Education> educations = theQuery.getResultList();
		
		//return the results
		return educations;
	}

	@Override
	public void addEducation(Education theEducation) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//add/update the education
		currentSession.saveOrUpdate(theEducation);
	}

	@Override
	public Education getEducation(int theId) {
		//get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		//now retrieve/read from database using the primary key
		Education theEducation = currentSession.get(Education.class, theId);
		
		return theEducation;
	}

	@Override
	public void deleteEducation(int theId) {
		Session currentSession = sessionFactory.getCurrentSession();
		
		Query theQuery = currentSession.createQuery("delete from Education where id=:educationId");
		
		theQuery.setParameter("educationId", theId);
		
		theQuery.executeUpdate();
	}

}









