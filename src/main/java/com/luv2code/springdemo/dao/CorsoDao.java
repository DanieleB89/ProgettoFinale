package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Corso;


public interface CorsoDao {

	public List<Corso> getCorso();

	public void saveCorso(Corso theCorso);

	public Corso getCorso(int theId);

	public void deleteCorso(int theId);
	
}
