package com.example.FlmBank.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.FlmBank.Model.DepositModel;
import com.example.FlmBank.Model.LoginModel;
import com.example.FlmBank.Model.User;
import com.example.FlmBank.Model.WithdrawModel;
import com.example.FlmBank.Repository.UserRepository;
import com.example.FlmBank.Service.UserService;


@RestController
public class UserController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	public UserRepository userRepository;

	// Home page of the web site
	@GetMapping("/")
	public ResponseEntity<?> homePage() {
		return new ResponseEntity<String>("Welcome to FLM Bank",HttpStatus.OK);
	}
	
	// Create New User
	@PostMapping("/signup")
	public ResponseEntity<?> addUser(@RequestBody User user) {
		boolean value = userService.createUser(user);
		if(value)
			return new ResponseEntity<String>("User Created Successfully",HttpStatus.CREATED);
		
		return new ResponseEntity<String>("Creation Failure",HttpStatus.BAD_REQUEST);
	}
	
	// Login with existing credentials
	@PostMapping("/login")
	public ResponseEntity<?> checkUser(@RequestBody LoginModel user) {
		User a = userRepository.findByAadhaar(user.getAadhaarNumber());
		if(!(a==null)) {
			if(user.getPassword().equals(a.getPassword())) {
				return new ResponseEntity<String>("Logged In Successfull",HttpStatus.OK);
			}
			return new ResponseEntity<String>("Credentials Wrong",HttpStatus.NOT_FOUND);
				
		}
		else {
			return new ResponseEntity<String>("Credentials Wrong",HttpStatus.NOT_FOUND);
		}
	}
	
	// Withdraw the amount
	@PutMapping("/withdraw")
	public ResponseEntity<?> withdrawAmount(@RequestBody WithdrawModel user) {
		return userService.withdrawAmount(user);
	}
	
	// deposit the amount
	@PutMapping("/deposit")
	public ResponseEntity<?> depositAmount(@RequestBody DepositModel user) {
		return userService.depositAmount(user);
	}
	
	// Display the amount
	@GetMapping("/getAmount")
	public ResponseEntity<?> getAmount(long aadhaar) {
		return userService.getBalance(aadhaar);
	}
}
