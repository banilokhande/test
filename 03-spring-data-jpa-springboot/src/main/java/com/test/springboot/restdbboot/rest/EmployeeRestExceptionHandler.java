package com.test.springboot.restdbboot.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeRestExceptionHandler {

	//Add an exception handler for EmployeeNotFoundException
	 
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleNotFoundException (EmployeeNotFoundException exc){
		//Create Customer Error Response
		
		EmployeeErrorResponse error= new EmployeeErrorResponse(HttpStatus.NOT_FOUND.value(), exc.getMessage(), System.currentTimeMillis());
		
		
		//Return Response entity
		return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
	}    
	//Add general Exception handler
	
	@ExceptionHandler
	public ResponseEntity<EmployeeErrorResponse> handleAllException (Exception exc){
		//Create Customer Error Response
		
		EmployeeErrorResponse error= new EmployeeErrorResponse(HttpStatus.BAD_REQUEST.value(), exc.getMessage(), System.currentTimeMillis());
		
		
		//Return Response entity
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	
	}
}
