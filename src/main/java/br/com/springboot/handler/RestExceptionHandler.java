/**
 * @author cleilton
 * File: RestExceptionHandler.java - Date: Sep 19, 2019
 */
package br.com.springboot.handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import br.com.springboot.error.ResourceNotFoundDatails;
import br.com.springboot.error.ResourceNotFoundExcepetion;

@ControllerAdvice
public class RestExceptionHandler {
	@ExceptionHandler(ResourceNotFoundExcepetion.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundExcepetion rnfException) {
		ResourceNotFoundDatails rnfDetails = ResourceNotFoundDatails.Builder().Timestamp(new Date().getTime())
				.Status(HttpStatus.NOT_FOUND.value()).Title("Resource not found").Datails(rnfException.getMessage())
				.DeveloperMessage(rnfException.getClass().getName()).newBuilder();

		return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);

	}
}
