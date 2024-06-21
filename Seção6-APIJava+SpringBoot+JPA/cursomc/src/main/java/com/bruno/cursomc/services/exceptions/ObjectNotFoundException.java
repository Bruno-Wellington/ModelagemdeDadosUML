package com.bruno.cursomc.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	//construtor
	public ObjectNotFoundException(String msg) {
		super(msg);
	}
	
	//construtor
	public ObjectNotFoundException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
