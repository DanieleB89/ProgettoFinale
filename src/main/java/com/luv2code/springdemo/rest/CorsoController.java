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

import com.luv2code.springdemo.entity.Corso;
import com.luv2code.springdemo.service.CorsoService;


@RestController
@CrossOrigin
@RequestMapping("/api")
public class CorsoController {

	// autowire the CorsoService
	@Autowired
	private CorsoService corsoService;
	
	// add mapping for GET /corsos
	@GetMapping("/corso")
	public List<Corso> getCorso() {
		
		return corsoService.getCorso();
		
	}
	
	// add mapping for GET /corsos/{corsoId}
	
	@GetMapping("/corsi/{corsoId}")
	public Corso getCorso(@PathVariable int corsoId) {
		
		Corso theCorso = corsoService.getCorso(corsoId);
		
//		if (theCorso == null) {
//			throw new CorsoNotFoundException("Corso id not found - " + corsoId);
//		}
//		
		return theCorso;
	}
	
	// add mapping for POST /corsos  - add new corso
	
	@PostMapping("/corso")
	public Corso addCorso(@RequestBody Corso theCorso) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theCorso.setId(0);
		
		corsoService.saveCorso(theCorso);
		
		return theCorso;
	}
	
	// add mapping for PUT /corso - update existing corso
	
	@PutMapping("/corso")
	public Corso updateCorso(@RequestBody Corso theCorso) {
		
		corsoService.saveCorso(theCorso);
		
		return theCorso;
		
	}
	
	// add mapping for DELETE /corsos/{corsoId} - delete corso
	
	@DeleteMapping("/corso/{corsoId}")
	public void deleteCorso(@PathVariable int corsoId) {
		
		Corso tempCorso = corsoService.getCorso(corsoId);
		
		// throw exception if null
		
//		if (tempCorso == null) {
//			throw new CorsoNotFoundException("Corso id not found - " + corsoId);
//		}
				
		corsoService.deleteCorso(corsoId);
		
		//return "Deleted corso id - " + corsoId;
	}
	
}



