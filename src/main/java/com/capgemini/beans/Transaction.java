package com.capgemini.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_transactioin;

	private String transaction_type;
	private int from_account;
	private int to_account;
	private double amount;
	private String create_time;

	/**
	 * @return the id_transactioin
	 */
	public int getId_transactioin() {
		return id_transactioin;
	}

	/**
	 * @param id_transactioin the id_transactioin to set
	 */
	public void setId_transactioin(int id_transactioin) {
		this.id_transactioin = id_transactioin;
	}

	/**
	 * @return the transaction_type
	 */
	public String getTransaction_type() {
		return transaction_type;
	}

	/**
	 * @param transaction_type the transaction_type to set
	 */
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}

	/**
	 * @return the from_account
	 */
	public int getFrom_account() {
		return from_account;
	}

	/**
	 * @param from_account the from_account to set
	 */
	public void setFrom_account(int from_account) {
		this.from_account = from_account;
	}

	/**
	 * @return the to_account
	 */
	public int getTo_account() {
		return to_account;
	}

	/**
	 * @param to_account the to_account to set
	 */
	public void setTo_account(int to_account) {
		this.to_account = to_account;
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

	/**
	 * @return the create_time
	 */
	public String getCreate_time() {
		return create_time;
	}

	/**
	 * @param create_time the create_time to set
	 */
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Transaction [id_transactioin=");
		builder.append(id_transactioin);
		builder.append(", transaction_type=");
		builder.append(transaction_type);
		builder.append(", from_account=");
		builder.append(from_account);
		builder.append(", to_account=");
		builder.append(to_account);
		builder.append(", amount=");
		builder.append(amount);
		builder.append(", create_time=");
		builder.append(create_time);
		builder.append("]");
		return builder.toString();
	}

	

}
