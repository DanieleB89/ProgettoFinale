package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Cliente;



public interface ClienteDao {
	public List<Cliente> getCliente();

	public void saveCliente(Cliente theCliente);

	public Cliente getCliente(int theId);

	public void deleteCliente(int theId);

	

}
