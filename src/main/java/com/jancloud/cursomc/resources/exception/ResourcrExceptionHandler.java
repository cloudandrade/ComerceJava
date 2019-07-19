package com.jancloud.cursomc.resources.exception;

import javax.servlet.http.HttpServlet;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.jancloud.cursomc.service.exception.ObjectNotFoundException;

@ControllerAdvice
public class ResourcrExceptionHandler {

	@ExceptionHandler(ObjectNotFoundException.class) // request >> serve para retornar o erro mais detalhado para o desenvolvedor
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e/*, HttpServlet request */){
		
		StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
		
	}
	
}
