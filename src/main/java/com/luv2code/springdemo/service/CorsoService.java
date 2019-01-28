package com.luv2code.springdemo.service;

import java.util.List;
import com.luv2code.springdemo.entity.Corso;


public interface CorsoService {
	public List<Corso> getCorso();

	public void saveCorso(Corso theCorso);

	public Corso getCorso(int theId);

	public void deleteCorso(int theId);
}
