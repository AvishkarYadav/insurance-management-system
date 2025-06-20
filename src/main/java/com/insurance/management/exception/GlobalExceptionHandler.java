package com.insurance.management.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = { CustomerNotFoundException.class })
	public ResponseEntity<CustomerException> getCustomerHandlerException(CustomerNotFoundException customerNotFoundException) {
		CustomerException customerException = new CustomerException(customerNotFoundException.getMessage(),
				HttpStatus.NOT_FOUND);
		return new ResponseEntity<>(customerException, HttpStatus.NOT_FOUND);
	}

}
