package com.sanitas.calculator.controller.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sanitas.calculator.exceptions.OperationNoImplementException;

@ControllerAdvice
public class OperationExceptionHandler {
	
	@ExceptionHandler(OperationNoImplementException.class)
	public ResponseEntity<?> exceptionNoImplementOperation(){
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("not implement operation");
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<?> exceptionHandler(){
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("operation not support");
	}

}
