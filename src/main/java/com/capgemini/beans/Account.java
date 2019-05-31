package com.capgemini.beans;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_account")
public class Account {

	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int account_num;
	
	private String firstName;
	private String lastName;
	private String dob;
	private String ssn;
	private String email;
	private String mobileNumber;

	private String homeAddress;
	private String mailingAddress;

	private String accountType;

	private double min_balance;

	/**
	 * @return the idAccount
	 */
	public int getIdAccount() {
		return account_num;
	}

	/**
	 * @param idAccount the idAccount to set
	 */
	public void setIdAccount(int idAccount) {
		this.account_num = idAccount;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the dob
	 */
	public String getDob() {
		return dob;
	}

	/**
	 * @param dob the dob to set
	 */
	public void setDob(String dob) {
		this.dob = dob;
	}

	/**
	 * @return the ssn
	 */
	public String getSsn() {
		return ssn;
	}

	/**
	 * @param ssn the ssn to set
	 */
	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @param mobileNumber the mobileNumber to set
	 */
	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @return the homeAddress
	 */
	public String getHomeAddress() {
		return homeAddress;
	}

	/**
	 * @param homeAddress the homeAddress to set
	 */
	public void setHomeAddress(String homeAddress) {
		this.homeAddress = homeAddress;
	}

	/**
	 * @return the mailingAddress
	 */
	public String getMailingAddress() {
		return mailingAddress;
	}

	/**
	 * @param mailingAddress the mailingAddress to set
	 */
	public void setMailingAddress(String mailingAddress) {
		this.mailingAddress = mailingAddress;
	}

	/**
	 * @return the accountType
	 */
	public String getAccountType() {
		return accountType;
	}

	/**
	 * @param accountType the accountType to set
	 */
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	/**
	 * @return the balance
	 */
	public double getBalance() {
		return min_balance;
	}

	/**
	 * @param balance the balance to set
	 */
	public void setBalance(double balance) {
		this.min_balance = balance;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Account [account_num=");
		builder.append(account_num);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", dob=");
		builder.append(dob);
		builder.append(", ssn=");
		builder.append(ssn);
		builder.append(", email=");
		builder.append(email);
		builder.append(", mobileNumber=");
		builder.append(mobileNumber);
		builder.append(", homeAddress=");
		builder.append(homeAddress);
		builder.append(", mailingAddress=");
		builder.append(mailingAddress);
		builder.append(", accountType=");
		builder.append(accountType);
		builder.append(", min_balance=");
		builder.append(min_balance);
		builder.append("]");
		return builder.toString();
	}

}
