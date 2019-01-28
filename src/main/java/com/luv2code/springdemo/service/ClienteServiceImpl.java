package com.luv2code.springdemo.service;

	import java.util.List;

	import org.springframework.beans.factory.annotation.Autowired;
	import org.springframework.stereotype.Service;
	import org.springframework.transaction.annotation.Transactional;

	import com.luv2code.springdemo.dao.ClienteDao;
	import com.luv2code.springdemo.entity.Cliente;
	@Service
	public class ClienteServiceImpl implements ClienteService {
		// need to inject cliente dao
			@Autowired
			private ClienteDao clienteDAO;
			
			@Override
			@Transactional
			public List<Cliente> getCliente() {
				return clienteDAO.getCliente();
			}

			@Override
			@Transactional
			public void saveCliente(Cliente theCliente) {
				clienteDAO.saveCliente(theCliente);
			}

			@Override
			@Transactional
			public Cliente getCliente(int theId) {
				
				return clienteDAO.getCliente(theId);
			}

			@Override
			@Transactional
			public void deleteCliente(int theId) {
				
				clienteDAO.deleteCliente(theId);
			}
	}

	


