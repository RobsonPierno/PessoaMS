package com.streaming.pessoa.exception;

public class PessoaNotFoundException extends NotFoundException {

	private static final long serialVersionUID = -8517619399827055786L;
	
	@Override
	protected String getEntityName() {
		return "Pessoa";
	}
}
