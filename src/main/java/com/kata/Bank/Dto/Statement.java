package com.kata.Bank.Dto;

import java.time.LocalDate;

public class Statement implements Comparable<Statement> {
 
	private Transaction transaction;
	private double balance;
	
	
	public Statement(Transaction transaction, double balance) {
		super();
		this.transaction = transaction;
		this.balance = balance;
	}

	public Transaction getTransaction() {
		return transaction;
	}

	public void setTransaction(Transaction transaction) {
		this.transaction = transaction;
	}

	

	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int compareTo(Statement o) {
		return this.getTransaction().compareTo(o.getTransaction());
	}

	@Override
	public String toString() {
		return   transaction + ", balance=" + balance +" €";
	}
	
	
	
	
}
