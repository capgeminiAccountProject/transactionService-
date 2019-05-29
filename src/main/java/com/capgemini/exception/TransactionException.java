package com.capgemini.exception;

public interface TransactionException {
	int getCode();

	void setCode(int code);

	String getMessage();

	void setMessage(String message);
}
