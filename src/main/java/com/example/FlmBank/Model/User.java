package com.example.FlmBank.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User {
	
	@Id
	@Column(name="aadhaar")
	private long aadhaarNumber;
	private String firstName;
	private String lastName; 
	private double initialDeposit;
	private String password;
	private String confirmPassword;
	private String gender;
	private String dob; 
	private long mobileNumber; 
	
	public User() {}
	
	

	public User(long aadhaarNumber, String firstName, String lastName, double initialDeposit, String password,
			String confirmPassword, String gender, String dob, long mobileNumber) {
		super();
		this.aadhaarNumber = aadhaarNumber;
		this.firstName = firstName;
		this.lastName = lastName;
		this.initialDeposit = initialDeposit;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.gender = gender;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
	}



	public long getAadhaarNumber() {
		return aadhaarNumber;
	}

	public void setAadhaarNumber(long aadhaarNumber) {
		this.aadhaarNumber = aadhaarNumber;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public double getInitialDeposit() {
		return initialDeposit;
	}

	public void setInitialDeposit(double initialDeposit) {
		this.initialDeposit = initialDeposit;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}
	
	
	
}
