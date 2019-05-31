package com.capgemini.beans;

/*import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Toint;*/


public class TransferAmtRequest {
	int fromAccountNumber;
	int toAccountNumber;
	double amount;
	
	
	public TransferAmtRequest() {
		super();
	}

	public TransferAmtRequest(int fromAccountNumber, int toAccountNumber, double amount) {
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
	public double getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransferAmtRequest [fromAccountNumber=");
		builder.append(fromAccountNumber);
		builder.append(", toAccountNumber=");
		builder.append(toAccountNumber);
		builder.append(", amount=");
		builder.append(amount);
		builder.append("]");
		return builder.toString();
	}
	
}
