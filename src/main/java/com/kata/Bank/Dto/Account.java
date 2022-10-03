package com.kata.Bank.Dto;

import java.util.ArrayList;

import java.util.List;

public class Account {

	private Client client;
	private Long numero;
	private double solde;
    private List<Statement> statements = new ArrayList<Statement>();
	
	public Account(Client client, Long numero) {
		super();
		this.client = client;
		this.numero = numero;
		this.solde=0;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}


	
	
	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}


	public List<Statement> getStatements() {
		return statements;
	}

	public void setStatements(List<Statement> statements) {
		this.statements = statements;
	}

	@Override
	public String toString() {
		return "Compte [client=" + client + ", numero=" + numero + ", solde=" + solde + ", statement=" + statements
				+ "]";
	}

	


	
	
}
