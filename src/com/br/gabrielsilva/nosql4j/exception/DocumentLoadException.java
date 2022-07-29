package com.br.gabrielsilva.nosql4j.exception;

public class DocumentLoadException extends Exception {
	
	private static final long serialVersionUID = -9094907887196734976L;

	public DocumentLoadException(String message) {
        super(message);
    }

    public DocumentLoadException(String message, Throwable cause) {
        super(message, cause);
    }
}