package br.lucas.lemmy.exception;

public class BadRequestException extends RuntimeException {

	public BadRequestException(String msg) {
		super(msg);
	}
	
}
