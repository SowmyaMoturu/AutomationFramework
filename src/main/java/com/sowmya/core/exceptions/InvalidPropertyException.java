package com.sowmya.core.exceptions;

public class InvalidPropertyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InvalidPropertyException(String key) {
		super("Invalid Property Key :" + key);
	}

}
