package com.joao.springproject.Services.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import jakarta.servlet.http.HttpServletRequest;

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(ObjectNotFounException.class)
	public ResponseEntity<StandardException> objectNotFound(ObjectNotFounException e, HttpServletRequest request) {

		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardException err = new StandardException(System.currentTimeMillis(), "Não encontrado", request.getRequestURI(),e.getMessage() , status.value());
		return ResponseEntity.status(status).body(err);
	}
}