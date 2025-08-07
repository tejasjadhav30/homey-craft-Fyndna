package com.fyndna.project.UserService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(EmailIdNotExistException.class)
	public ResponseEntity<?> handleEmailIdNotExistException(EmailIdNotExistException e)
	{
		return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(InvalidMobileNumberException.class)
	public ResponseEntity<String> handleInvalidMobileNumberException(InvalidMobileNumberException ex)
	{
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}

}

