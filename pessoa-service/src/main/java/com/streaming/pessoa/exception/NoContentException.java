package com.streaming.pessoa.exception;

public abstract class NoContentException extends RuntimeException {

	private static final long serialVersionUID = -8442806889429334352L;
	
	@Override
	public String getMessage() {
		return "No entity found: " + this.getEntityName();
	}
	
	protected abstract String getEntityName(); 
}
