package com.sowmya.core.exceptions;

public class TargetNotValidException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public TargetNotValidException(String target) {
		super("Invalid Target type : " + target);
	}

}
