package com.capgemini.beans;

public class TokenRequest {

	private String email;
	private String token;
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
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TokenRequest [email=");
		builder.append(email);
		builder.append(", token=");
		builder.append(token);
		builder.append("]");
		return builder.toString();
	}
	
	
}
