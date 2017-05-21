package br.com.own.exceptions;

public class InvalidRequest extends RuntimeException {
	
	private static final long serialVersionUID = -2555823891940970121L;

	public InvalidRequest(String erro){
		super(erro);
	}
	
}
