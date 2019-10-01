/**
 * @author cleilton
 * File: RestExceptionHandler.java - Date: Sep 19, 2019
 */
package br.com.springboot.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.springboot.error.ErrorDetails;
import br.com.springboot.error.ResourceNotFoundDatails;
import br.com.springboot.error.ResourceNotFoundExcepetion;
import br.com.springboot.error.ValidationErrorDetails;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(ResourceNotFoundExcepetion.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundExcepetion rnfException) {
		ResourceNotFoundDatails rnfDetails = ResourceNotFoundDatails.newBuilder().Timestamp(new Date().getTime())
				.Status(HttpStatus.NOT_FOUND.value()).Title("Resource not found").Details(rnfException.getMessage())
				.DeveloperMessage(rnfException.getClass().getName()).build();

		return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();

		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

		ValidationErrorDetails vErrorDetails = ValidationErrorDetails.newBuilder().Timestamp(new Date().getTime())
				.Status(HttpStatus.BAD_REQUEST.value()).Title("Field Validation Error").Details("Field Validation Error")
				.DeveloperMessage(manvException.getClass().getName()).Field(fields).FieldMessage(fieldMessages).build();

		return new ResponseEntity<>(vErrorDetails, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers, HttpStatus status,
			WebRequest request) {

		ErrorDetails errorDetails = ErrorDetails.builder().Timestamp(new Date().getTime()).Status(status.value())
				.Title("Internal Exception").Details(ex.getMessage()).DeveloperMessage(ex.getClass().getName()).build();

		return new ResponseEntity<>(errorDetails, headers, status);
	}

}
