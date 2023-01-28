package com.kata.Bank.Dto;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import com.kata.Bank.Enum.Operation;

public class Transaction implements Comparable<Transaction> {

	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
	private LocalDateTime date;
	private double amount;
    private Operation type;
    
    
     


	public Transaction(LocalDateTime date, double amount, Operation type) {
		super();
		this.date = date;
		this.amount = amount;
		this.type = type;
	}



	public LocalDateTime getDate() {
		return date;
	}



	public void setDate(LocalDateTime date) {
		this.date = date;
	}


    

	public double getAmount() {
		return amount;
	}



	public void setAmount(double amount) {
		this.amount = amount;
	}



	public Operation getType() {
		return type;
	}

	public void setType(Operation type) {
		this.type = type;
	}
	

	
	
	public int compareTo(Transaction tr1) {
		
		
		return this.getDate().compareTo(tr1.getDate());
	}



	@Override
	public String toString() {
		return "date=" + date.format(formatter) +","+ "type=" + type+", montant=" + Math.abs(amount) +" €" ;
	}
	

  

	


}
