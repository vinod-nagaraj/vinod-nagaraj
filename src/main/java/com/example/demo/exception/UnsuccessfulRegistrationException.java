package com.example.demo.exception;

public class UnsuccessfulRegistrationException extends Exception {
	private static final long serialVersionUID = 1L;

	public UnsuccessfulRegistrationException(String message) {
		super(message);
	}

}