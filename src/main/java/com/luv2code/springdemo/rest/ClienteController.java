package com.luv2code.springdemo.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.luv2code.springdemo.entity.Cliente;
import com.luv2code.springdemo.service.ClienteService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class ClienteController {

	// autowire the ClienteService
	@Autowired
	private ClienteService clienteService;
	
	// add mapping for GET /clientes
	@GetMapping("/clienti")
	public List<Cliente> getCliente() {
		
		return clienteService.getCliente();
		
	}
	
	// add mapping for GET /clientes/{clienteId}
	
	@GetMapping("/clienti/{idcliente}")
	public Cliente getCliente(@PathVariable int idcliente) {
		
		Cliente theCliente = clienteService.getCliente(idcliente);
		
//		if (theCliente == null) {
//			throw new ClienteNotFoundException("Cliente id not found - " + clienteId);
//		}
//		
		return theCliente;
	}
	
	// add mapping for POST /clientes  - add new cliente
	
	@PostMapping("/clienti")
	public Cliente addCliente(@RequestBody Cliente theCliente) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theCliente.setidcliente(0);
		
		clienteService.saveCliente(theCliente);
		
		return theCliente;
	}
	
	// add mapping for PUT /cliente - update existing cliente
	
	@PutMapping("/clienti")
	public Cliente updateCliente(@RequestBody Cliente theCliente) {
		
		clienteService.saveCliente(theCliente);
		
		return theCliente;
		
	}
	
	// add mapping for DELETE /clientes/{clienteId} - delete cliente
	
	@DeleteMapping("/clienti/{idcliente}")
	public void deleteCliente(@PathVariable int idcliente) {
		
		Cliente tempCliente = clienteService.getCliente(idcliente);
		
		// throw exception if null
		
				if (tempCliente == null) {
			try {
				throw new ClienteNotFoundException("Cliente non trovato - " + idcliente);
				
			} catch (ClienteNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					}
				
		clienteService.deleteCliente(idcliente);
		
		
	}
	
}

