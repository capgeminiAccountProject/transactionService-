package com.capgemini.beans;

public class DepositRequest {
	int accountNumber;
	int amount;
	
	
	
	public DepositRequest() {
		super();
	}

	public DepositRequest(int accountNumber, int amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	/**
	 * @return the accountNumber
	 */
	public int getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(int accountNumber) {
		this.accountNumber = accountNumber;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	
}
