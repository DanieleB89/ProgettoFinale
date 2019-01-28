package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Corso;

@Repository
public class CorsoDaoImpl implements CorsoDao {

		@Autowired
		private SessionFactory sessionFactory;
				
		@Override
		public List<Corso> getCorso() {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			// create a query  ... sort by last name
			Query<Corso> theQuery = 
					currentSession.createQuery("from Corso ",
												Corso.class);
			
			// execute query and get result list
			List<Corso> corsos = theQuery.getResultList();
					
			// return the results		
			return corsos;
		}

		@Override
		public void saveCorso(Corso theCorso) {

			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// save/upate the corso ... finally LOL
			currentSession.saveOrUpdate(theCorso);
			
		}

		@Override
		public Corso getCorso(int theId) {

			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// now retrieve/read from database using the primary key
			Corso theCorso = currentSession.get(Corso.class, theId);
			
			return theCorso;
		}

		@Override
		public void deleteCorso(int theId) {

			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// delete object with primary key
			Query theQuery = 
					currentSession.createQuery("delete from Corso where id=:corsoId");
			theQuery.setParameter("corsoId", theId);
			
			theQuery.executeUpdate();		
		}

}




