package com.luv2code.springdemo.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public class ClienteRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ClienteErrorResponse> handleException(ClienteNotFoundException exc) {
		
		// create ClienteErrorResponse
		
		ClienteErrorResponse error = new ClienteErrorResponse(
											HttpStatus.NOT_FOUND.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	
	// Add another exception handler ... to catch any exception (catch all)

	@ExceptionHandler
	public ResponseEntity<ClienteErrorResponse> handleException(Exception exc) {
		
		// create ClienteErrorResponse
		
		ClienteErrorResponse error = new ClienteErrorResponse(
											HttpStatus.BAD_REQUEST.value(),
											exc.getMessage(),
											System.currentTimeMillis());
		
		// return ResponseEntity
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
	}

}
