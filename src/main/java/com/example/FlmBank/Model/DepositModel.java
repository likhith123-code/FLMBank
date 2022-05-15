package com.example.FlmBank.Model;

public class DepositModel {

	private long aadhaarNumber;
	private double depositAmount;
	
	public DepositModel() {}
	
	public DepositModel(long aadhaarNumber, double depositAmount) {
		super();
		this.aadhaarNumber = aadhaarNumber;
		this.depositAmount = depositAmount;
	}
	public long getAadhaarNumber() {
		return aadhaarNumber;
	}
	public void setAadhaarNumber(long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}
	public double getDepositAmount() {
		return depositAmount;
	}
	public void setDepositAmount(double depositAmount) {
		this.depositAmount = depositAmount;
	}
	
	
	
}
