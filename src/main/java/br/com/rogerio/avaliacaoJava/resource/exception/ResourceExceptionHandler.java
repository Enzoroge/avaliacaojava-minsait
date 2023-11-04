package br.com.rogerio.avaliacaoJava.resource.exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.rogerio.avaliacaoJava.service.exceptions.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e){
		StandardError error = new StandardError(System.currentTimeMillis(),
				HttpStatus.NOT_FOUND.value(), e.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
	}
	
		
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ValidationError> handleValidationException(MethodArgumentNotValidException e){
	    ValidationError error = new ValidationError(System.currentTimeMillis(),
	            HttpStatus.BAD_REQUEST.value(), "Erro na validação do campo");

	    for(FieldError x : e.getBindingResult().getFieldErrors()) {
	        error.addError(x.getField(), x.getDefaultMessage());
	    }

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}
	
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<StandardError> handleDataIntegrityViolation(DataIntegrityViolationException e) {
	    StandardError error = new StandardError(System.currentTimeMillis(),
	            HttpStatus.BAD_REQUEST.value(), "O contato deve estar associado a uma pessoa");
	  

	    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
	}

	


}
	