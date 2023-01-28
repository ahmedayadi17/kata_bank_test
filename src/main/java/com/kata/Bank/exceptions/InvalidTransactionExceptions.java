package com.kata.Bank.exceptions;

@SuppressWarnings("serial")
public class InvalidTransactionExceptions extends RuntimeException{

	public InvalidTransactionExceptions(String message) {
		super(message);
	}

}
