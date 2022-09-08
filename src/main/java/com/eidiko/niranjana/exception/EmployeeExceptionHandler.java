package com.eidiko.niranjana.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class EmployeeExceptionHandler {

	@ExceptionHandler(value = EmployeeNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleEmployeeNotFound(EmployeeNotFoundException exception) {
		System.out.println("EmployeeExceptionHandler.handleEmployeeNotFound()");
		ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), exception.getMessage(), "404-Employee Not Found");
		return new ResponseEntity<ErrorDetails>(errorDetails, HttpStatus.NOT_FOUND);
	}
}
