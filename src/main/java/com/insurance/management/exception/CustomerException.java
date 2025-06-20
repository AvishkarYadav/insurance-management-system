package com.insurance.management.exception;

import org.springframework.http.HttpStatus;

//For message and status
public class CustomerException {

	private String message;
	private HttpStatus httpStatus;

	public CustomerException(String message, HttpStatus httpStatus) {
		super();
		this.message = message;
		this.httpStatus = httpStatus;
	}

	public CustomerException() {

	}

	public String getMessage() {
		return message;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

}
