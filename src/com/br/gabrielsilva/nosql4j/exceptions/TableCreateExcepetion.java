package com.br.gabrielsilva.nosql4j.exceptions;

public class TableCreateExcepetion extends Exception {
	
	private static final long serialVersionUID = 4669792660954467421L;

	public TableCreateExcepetion(String message) {
        super(message);
    }

    public TableCreateExcepetion(String message, Throwable cause) {
        super(message, cause);
    }
}