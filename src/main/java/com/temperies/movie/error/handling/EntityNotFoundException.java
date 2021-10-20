package com.temperies.movie.error.handling;

public class EntityNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3923763585986511371L;

	public EntityNotFoundException(String message) {  
		super(message); 
	}
	
}
