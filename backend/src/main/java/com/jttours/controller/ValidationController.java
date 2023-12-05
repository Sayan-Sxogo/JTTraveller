package com.jttours.controller;

import java.util.ArrayList;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class ValidationController {

	@ExceptionHandler
	public static ResponseEntity<?> Validation(ConstraintViolationException exception) {
		String property = new ArrayList<>(exception.getConstraintViolations()).get(0).getPropertyPath().toString();
		String errorMessage = new ArrayList<>(exception.getConstraintViolations()).get(0).getMessage();
		return new ResponseEntity<>(property.toString() + " : " + errorMessage, HttpStatus.BAD_REQUEST);
	}
}
