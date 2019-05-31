package com.capgemini.exceptions.Impl;

import com.capgemini.exception.TransactionException;

public class TransactionExceptionImpl extends Exception implements TransactionException{
    /**
	 * 
	 */
	private static final long serialVersionUID = -797391336855464733L;
	private int code;
    private String message;

    public TransactionExceptionImpl(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TransactionExceptionImpl [code=");
		builder.append(code);
		builder.append(", message=");
		builder.append(message);
		builder.append("]");
		return builder.toString();
	}

    
}
