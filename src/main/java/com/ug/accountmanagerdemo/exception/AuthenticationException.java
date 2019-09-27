package com.ug.accountmanagerdemo.exception;

public class AuthenticationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public AuthenticationException(String message, Throwable e) {
		super(message, e);
	}

}
