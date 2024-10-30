package com.streaming.pessoa.exception;

public abstract class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = -3073440191910793770L;
	
	@Override
	public String getMessage() {
		return "No entity found: " + this.getEntityName();
	}
	
	protected abstract String getEntityName();
}
