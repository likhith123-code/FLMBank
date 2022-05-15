package com.example.FlmBank.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.FlmBank.Model.DepositModel;
import com.example.FlmBank.Model.User;
import com.example.FlmBank.Model.WithdrawModel;
import com.example.FlmBank.Repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	public UserRepository userRepository;

	// creating a new user
	public boolean createUser(User user) {
		User create = userRepository.save(user);
		if(create!=null) 
			return true;
		return false;
	}

	// withdraw the amount from account
	public ResponseEntity<?> withdrawAmount(WithdrawModel user) {
		
		User a = userRepository.findByAadhaar(user.getAadhaarNumber());
		if(a==null)
			return new ResponseEntity<String>("User with Aadhaar Not Found",HttpStatus.NOT_FOUND);
		
		double existingAmount = a.getInitialDeposit();
		double withdrawAmount = user.getWithdrawAmount();
		
		if(existingAmount<withdrawAmount) {
			return new ResponseEntity<String>("Amount Not Sufficient",HttpStatus.BAD_REQUEST);
		}
		
		double newAmount = existingAmount-withdrawAmount;
		
		a.setInitialDeposit(newAmount);
		
		User updated = userRepository.save(a);
		
		if(updated!=null)
			return new ResponseEntity<String>("Withdrwal Successfull",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Something Error Occured",HttpStatus.BAD_REQUEST);
	}

	// Deposit the amount
	public ResponseEntity<?> depositAmount(DepositModel user) {
		
		User a = userRepository.findByAadhaar(user.getAadhaarNumber());
		if(a==null)
			return new ResponseEntity<String>("User with Aadhaar Not Found",HttpStatus.NOT_FOUND);
		
		double existingAmount = a.getInitialDeposit();
		
		double depositAmount = user.getDepositAmount();
	
		double newAmount = existingAmount + depositAmount;
		
		a.setInitialDeposit(newAmount);
		
		User updated = userRepository.save(a);
		
		if(updated!=null)
			return new ResponseEntity<String>("Deposit Successfull",HttpStatus.OK);
		else
			return new ResponseEntity<String>("Something Error Occured",HttpStatus.BAD_REQUEST);
		
	}
	
	// 
	public ResponseEntity<?> getBalance(long aadhaar) {
		
		User a = userRepository.findByAadhaar(aadhaar);
		if(a!=null) {
			return new ResponseEntity<String>("Balance : "+a.getInitialDeposit(),HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("User with Aadhaar Not Found",HttpStatus.NOT_FOUND);
		}
	}
	
	
}
