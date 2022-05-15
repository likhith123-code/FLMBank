package com.example.FlmBank.Model;

public class WithdrawModel {

	private long aadhaarNumber;
	private double withdrawAmount;
	
	public WithdrawModel(){}
	
	
	public WithdrawModel(long aadhaarNumber, double withdrawAmount) {
		super();
		this.aadhaarNumber = aadhaarNumber;
		this.withdrawAmount = withdrawAmount;
	}


	public long getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public double getWithdrawAmount() {
		return withdrawAmount;
	}
	public void setWithdrawAmount(double withdrawAmount) {
		this.withdrawAmount = withdrawAmount;
	} 
	
	
	
}
