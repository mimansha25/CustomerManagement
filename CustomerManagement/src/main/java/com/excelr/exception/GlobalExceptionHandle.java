package com.excelr.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandle {
	


	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ErrorResponse>  myExceptionResponse(IdNotFoundException ex)
	{
		  ErrorResponse errorResponse = new ErrorResponse();
		  errorResponse.setErrorMessage(ex.getMsg());
		  errorResponse.setStatus(HttpStatus.NOT_FOUND.toString());
		  
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(InValidFirstnameOrLastnameException.class)
	public ResponseEntity<ErrorResponse> invalidPriceResponse(InValidFirstnameOrLastnameException ex)
	{
		 ErrorResponse errorResponse = new ErrorResponse();
		  errorResponse.setErrorMessage(ex.getMsg());
		  errorResponse.setStatus(HttpStatus.BAD_REQUEST.toString());
		
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.BAD_REQUEST);
	}
	
	

}
