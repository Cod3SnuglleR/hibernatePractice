package com.lti.exception;

public class AccountException extends RuntimeException {

	public AccountException() {
		super();
		
	}

	public AccountException(String arg0, Throwable arg1, boolean arg2, boolean arg3) {
		super(arg0, arg1, arg2, arg3);
		
	}

	public AccountException(String arg0, Throwable arg1) {
		super(arg0, arg1);
		
	}

	public AccountException(String arg0) {
		super(arg0);
	
	}

	public AccountException(Throwable arg0) {
		super(arg0);
		
	}

}
