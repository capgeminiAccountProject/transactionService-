package com.capgemini.beans;

public class TokenResponse {

	private String token;
	private String status;
	private String tokenException;
	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}
	/**
	 * @param token the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the tokenException
	 */
	public String getTokenException() {
		return tokenException;
	}
	/**
	 * @param tokenException the tokenException to set
	 */
	public void setTokenException(String tokenException) {
		this.tokenException = tokenException;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TokenResponse [token=");
		builder.append(token);
		builder.append(", status=");
		builder.append(status);
		builder.append(", tokenException=");
		builder.append(tokenException);
		builder.append("]");
		return builder.toString();
	}
	
	
}
