package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Cliente;



public interface ClienteService {
	

	public List<Cliente> getCliente();
	public void saveCliente(Cliente theId);

	public Cliente getCliente(int theId);

	public void deleteCliente(int theId);

	
}


