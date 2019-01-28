package com.luv2code.springdemo.dao;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Cliente;

@Repository
public class ClienteDaoImpl implements ClienteDao {

		@Autowired
		private SessionFactory sessionFactory;
				
		@Override
		public List<Cliente> getCliente() {
			
			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
					
			// create a query  ... sort by last name
			Query<Cliente> theQuery = 
					currentSession.createQuery("from Cliente ",
												Cliente.class);
			
			// execute query and get result list
			List<Cliente> clientes = theQuery.getResultList();
					
			// return the results		
			return clientes;
		}

		@Override
		public void saveCliente(Cliente theCliente) {

			// get current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// save/upate the cliente ... finally LOL
			currentSession.saveOrUpdate(theCliente);
			
		}

		@Override
		public Cliente getCliente(int theId) {

			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// now retrieve/read from database using the primary key
			Cliente theCliente = currentSession.get(Cliente.class, theId);
			
			return theCliente;
		}

		@Override
		public void deleteCliente(int theId) {

			// get the current hibernate session
			Session currentSession = sessionFactory.getCurrentSession();
			
			// delete object with primary key
			//Query theQuery = 
				//	currentSession.createQuery("delete from Cliente where id=:idcliente");
			//theQuery.setParameter("idcliente", theId);
			//theQuery.executeUpdate();		
			Cliente toDelete=currentSession.get(Cliente.class, theId);
			currentSession.delete(toDelete);
			
		}

}
