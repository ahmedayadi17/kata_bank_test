package com.kata.Bank;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDateTime;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.kata.Bank.Dto.Account;
import com.kata.Bank.Dto.Client;
import com.kata.Bank.Dto.Transaction;
import com.kata.Bank.Enum.Operation;
import com.kata.Bank.exceptions.InvalidTransactionExceptions;
import com.kata.Bank.services.BankService;

class BankServiceTest {
	
	private BankService BankServiceUnderTest ;
	private Client client;
	private Account account;
	private Transaction trans;
	private Transaction exprectedTr;
	
	@BeforeEach
	public void initBankService() {
		System.out.println("Appel avant chaque test");
		BankServiceUnderTest = new BankService();
		client=BankServiceUnderTest.createClient(1234, "ayadi", "ahmed");
		
		account=BankServiceUnderTest.createAccount(client, Long.valueOf(123898));
		account.setSolde(1000);
		
	}
     
	
	
	@Test
	public void shoulddepositWithSuccess() throws InvalidTransactionExceptions  {
			
		exprectedTr= BankServiceUnderTest.createTransaction(LocalDateTime.of(2020, 10, 23, 22, 38), 1000, Operation.DEPOSER);

		trans=BankServiceUnderTest.deposit(account, LocalDateTime.of(2020, 10, 23, 22, 38), 1000, Operation.DEPOSER) ;
		System.out.println(trans.toString());
		
		assertNotNull(trans);
		Assertions.assertEquals(exprectedTr, trans);
		
	}
	
	@Test
	public void shouldwithdrawalWithError() throws InvalidTransactionExceptions  {
			
		Transaction exprectedTr= BankServiceUnderTest.createTransaction(LocalDateTime.of(2020, 10, 23, 22, 38), 2000, Operation.DEPOSER);

		trans=BankServiceUnderTest.withdrawal(account, LocalDateTime.of(2020, 10, 23, 22, 38), 2000, Operation.DEPOSER) ;
	    System.out.println(trans.toString());
		
		assertNotNull(trans);
		Assertions.assertEquals(exprectedTr, trans);
		
	}
	
	
	@Test
	public void shouldwithdrawalWithSuccess() throws InvalidTransactionExceptions  {
			
		Transaction exprectedTr= BankServiceUnderTest.createTransaction(LocalDateTime.of(2020, 10, 23, 22, 38), 1000, Operation.DEPOSER);

		trans=BankServiceUnderTest.withdrawal(account, LocalDateTime.of(2020, 10, 23, 22, 38), 1000, Operation.DEPOSER) ;
	    System.out.println(trans.toString());
		
		assertNotNull(trans);
		Assertions.assertEquals(exprectedTr, trans);
		
	}
	

	
	@AfterEach
	public void undefBankService() {
		System.out.println("Appel après chaque test");
		BankServiceUnderTest = null;
	}
	

}
