package com.example.FlmBank.Model;

public class LoginModel {
	
	private long aadhaarNumber;
	private String password;
	
	public LoginModel() {
		
	}

	public LoginModel(long aadhaarNumber, String password) {
		super();
		this.aadhaarNumber = aadhaarNumber;
		this.password = password;
	}

	public long getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
