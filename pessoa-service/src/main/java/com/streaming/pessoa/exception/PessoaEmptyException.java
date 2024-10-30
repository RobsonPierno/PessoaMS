package com.streaming.pessoa.exception;

public class PessoaEmptyException extends NoContentException {

	private static final long serialVersionUID = -8517619399827055786L;

	@Override
	protected String getEntityName() {
		return "Pessoa";
	}
	
}
