package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.CorsoDao;
import com.luv2code.springdemo.entity.Corso;
@Service
public class CorsoServiceImpl implements CorsoService {
	// need to inject corso dao
		@Autowired
		private CorsoDao corsoDAO;
		
		@Override
		@Transactional
		public List<Corso> getCorso() {
			return corsoDAO.getCorso();
		}

		@Override
		@Transactional
		public void saveCorso(Corso theCorso) {

			corsoDAO.saveCorso(theCorso);
		}

		@Override
		@Transactional
		public Corso getCorso(int theId) {
			
			return corsoDAO.getCorso(theId);
		}

		@Override
		@Transactional
		public void deleteCorso(int theId) {
			
			corsoDAO.deleteCorso(theId);
		}
}

