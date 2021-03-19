package com.myWebApp.accountdatadbservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myWebApp.accountdatadbservice.models.Account;
import com.myWebApp.accountdatadbservice.repositories.AccountRepository;

@RestController
@RequestMapping ("/cbs")
public class AccountController {
	
	@Autowired
	private AccountRepository accountRepository;
	
	@GetMapping ("/getaccount/{acnumber}")
	public Optional<Account> getAccount (@PathVariable("acnumber") String acnumber) {
		return accountRepository.findById(acnumber);
	}
	
	@PostMapping ("/saveaccount")
	public ResponseEntity<Account> createAccount(@RequestBody Account account) {
	    try {
	        Account _account = accountRepository
	            .save(new Account(account.getAcnumber(), account.getCustid(), account.getbid() ,account.getOpening_balance(), account.getAod(),account.getAtype(),account.getAstatus()));
	        return new ResponseEntity<>(_account, HttpStatus.CREATED);
	      } catch (Exception e) {
	    	  System.out.println("Error : " + e.getMessage().toString());
	        return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	      }
	}
	

}
