package com.sowmya.core.exceptions;

public class UnsupportedBrowserException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public UnsupportedBrowserException(String browserName) {
		super("Unsupported Browser : " + browserName);
	}

}
