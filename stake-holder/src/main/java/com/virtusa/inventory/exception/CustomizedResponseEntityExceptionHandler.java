package com.virtusa.inventory.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetail, HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@ExceptionHandler(LoyaltyCardNotFoundException.class)
	public final ResponseEntity<Object> handleLoyaltyCardNotFoundException(LoyaltyCardNotFoundException ex,
			WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetail, HttpStatus.NOT_FOUND);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ErrorDetail errorDetail = new ErrorDetail(new Date(), "Validation Failed", ex.getBindingResult().toString());
		return new ResponseEntity(errorDetail, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(CustomerNotFoundException.class)
	public final ResponseEntity<Object> handleCustomerNotFoundException(CustomerNotFoundException ex,
			WebRequest request) {

		ErrorDetail errorDetail = new ErrorDetail(new Date(), ex.getMessage(), request.getDescription(false));
		return new ResponseEntity(errorDetail, HttpStatus.NOT_FOUND);
	}
	
	protected ResponseEntity<Object> handlMethodNotValid(MethodArgumentNotValidException ex, 
			HttpHeaders headers, HttpStatus httpStatus, WebRequest request){
		ErrorDetail errorDetail = new ErrorDetail(new Date(), "Validation Failed111", ex.getBindingResult().toString());
		return new ResponseEntity(errorDetail, HttpStatus.BAD_REQUEST);
	}

}
