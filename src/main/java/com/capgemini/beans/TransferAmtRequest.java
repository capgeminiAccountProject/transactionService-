package com.capgemini.beans;

/*import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Toint;*/


public class TransferAmtRequest {
	int fromAccountNumber;
	int toAccountNumber;
	int amount;
	
	public TransferAmtRequest(int fromAccountNumber, int toAccountNumber, int amount) {
		this.fromAccountNumber = fromAccountNumber;
		this.toAccountNumber = toAccountNumber;
		this.amount = amount;
	}

	/**
	 * @return the fromAccountNumber
	 */
	public int getFromAccountNumber() {
		return fromAccountNumber;
	}

	/**
	 * @param fromAccountNumber the fromAccountNumber to set
	 */
	public void setFromAccountNumber(int fromAccountNumber) {
		this.fromAccountNumber = fromAccountNumber;
	}

	/**
	 * @return the toAccountNumber
	 */
	public int getToAccountNumber() {
		return toAccountNumber;
	}

	/**
	 * @param toAccountNumber the toAccountNumber to set
	 */
	public void setToAccountNumber(int toAccountNumber) {
		this.toAccountNumber = toAccountNumber;
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
