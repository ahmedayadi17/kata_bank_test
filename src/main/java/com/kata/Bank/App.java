package com.kata.Bank;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

import com.kata.Bank.Dto.Client;
import com.kata.Bank.Dto.Account;
import com.kata.Bank.Dto.Transaction;
import com.kata.Bank.Enum.Operation;
import com.kata.Bank.exceptions.InvalidStatementsExceptions;
import com.kata.Bank.exceptions.InvalidTransactionExceptions;
import com.kata.Bank.services.BankService;

public class App 
{  
	 
	  
	
    public static void main( String[] args ) throws InvalidTransactionExceptions, InvalidStatementsExceptions
    
    { 
    	System.out.println("test1");
    	BigDecimal bg;
    	BankService bs=new BankService();          
	    Client client=bs.createClient(12345, "AYADI","ahmed");
		Account cpt = bs.createAccount(client, Long.valueOf(123898));
		Transaction op=bs.deposit(cpt,LocalDateTime.of(2020, 10, 23, 22, 38) , 7000, Operation.DEPOSER);
		bs.withdrawal(cpt,LocalDateTime.of(2022, 10, 23, 18, 38), 200, Operation.RETIRER);
		bs.getTransactionsHistory(cpt);
	
		bs.deposit(cpt,LocalDateTime.of(2022, 10, 23, 12, 38), 800, Operation.DEPOSER);
		bs.printTransaction(op, cpt);
		bs.getTransactionsHistory(cpt);
		
		bg=new BigDecimal(2);
		System.out.println("currency" + bg.toString());
    }
}
