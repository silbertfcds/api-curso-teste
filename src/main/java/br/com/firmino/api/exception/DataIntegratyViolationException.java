package br.com.firmino.api.exception;

public class DataIntegratyViolationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public DataIntegratyViolationException(String message) {
		super(message);
	}
	
}
