package com.kata.Bank.services;





import java.time.LocalDateTime;
import java.util.List;

import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kata.Bank.Dto.Client;
import com.kata.Bank.Dto.Account;
import com.kata.Bank.Dto.Statement;
import com.kata.Bank.Dto.Transaction;
import com.kata.Bank.Enum.Operation;
import com.kata.Bank.exceptions.InvalidStatementsExceptions;
import com.kata.Bank.exceptions.InvalidTransactionExceptions;



public class BankService {
	
    private static Logger logger = LoggerFactory.getLogger(BankService.class);


	
	public Transaction deposit(Account cpt, LocalDateTime date, double amount,Operation type) throws InvalidTransactionExceptions {
		
		return this.saveTransaction(cpt,date,amount,type,false);

	}
	
	public Transaction withdrawal(Account cpt ,  LocalDateTime date, double amount,Operation type) throws InvalidTransactionExceptions {
		
		return this.saveTransaction(cpt,date,-amount,type,true);
	}


	public Transaction saveTransaction (Account cpt , LocalDateTime date, double amount, Operation type,boolean checkifEnough ) throws InvalidTransactionExceptions  {
		Transaction tr=this.createTransaction(date,amount,type);
		this.TransactionValidity(cpt , amount, checkifEnough);
		Statement st=this.createStatement(tr,cpt.getSolde());
		cpt.getStatements().add(st);
		this.updateSolde(cpt,amount);
		return tr;
	}
	
	public Statement createStatement(Transaction t , double balance) {
		
		return new Statement(t,balance);
	}
	
	public Transaction createTransaction (LocalDateTime date , double amount , Operation type) {
		Transaction tr=new Transaction(date,amount,type);
		return tr;
	}

	public void TransactionValidity(Account cpt,double amount, boolean checkifEnough) throws InvalidTransactionExceptions {
		
		
		if(cpt.getSolde() - Math.abs(amount)   < 0 && checkifEnough==true)
			throw new InvalidTransactionExceptions("le montant à retirer doit étre inférieur à " + cpt.getSolde());
		

	}
	
   
    public void updateSolde(Account cpt , double amount) {
			cpt.setSolde(cpt.getSolde()+amount);
	}
    
    public void getTransactionsHistory(Account cpt) throws InvalidTransactionExceptions, InvalidStatementsExceptions {
        if(cpt.getStatements().isEmpty())
           throw new InvalidStatementsExceptions("pas d'operations effectués sur votre compte");
        
    	 logger.info("-----------------------History of operations---------");
    	 List<Statement> sortedList = cpt.getStatements().stream()
    				.sorted((st1, st2)-> st1.compareTo(st2) )
    				.collect(Collectors.toList())	;
    						
    	 sortedList.forEach(s-> logger.info(s.toString()));
        
    
    
    }

    
    public void printTransaction(Transaction op,Account cpt) {
    	logger.info("--------------Operation Printed-------------");
    	logger.info("Nom client : " + cpt.getClient().getNom());
    	logger.info("Numero de compte : " + cpt.getNumero() );
    	logger.info(op.toString());
    	logger.info("--------------End Operation ----------------");

    }
    
    public Account createAccount(Client client,Long numero) {
    	return new Account(client,numero);
    }
    
    public Client createClient(int id,String nom,String prenom) {
    	return new Client(id,nom,prenom);
    }
}
