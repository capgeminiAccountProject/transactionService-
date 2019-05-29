package com.capgemini.beans;

/*import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
*/

public class WithdrawRequest {
	int accountNumber;
	int amount;
	
	public WithdrawRequest(int accountNumber, int amount) {
		this.accountNumber = accountNumber;
		this.amount = amount;
	}

	public WithdrawRequest() {
		super();
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
