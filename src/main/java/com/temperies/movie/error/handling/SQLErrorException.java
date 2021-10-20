package com.temperies.movie.error.handling;

public class SQLErrorException extends RuntimeException {

	private static final long serialVersionUID = -3628079372400766389L;

	public SQLErrorException(String message, Throwable cause) {  
		super(message, cause); 
	}
	
}
