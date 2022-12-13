//To define custom exceptions
package com.store.exception;

import java.lang.Exception;

public class UserException extends Exception {
	// constructor of user exception class to print the message
	public UserException(String msg) {
		super(msg);
	}

}
//use user exception to print proper error msg for adding password by user