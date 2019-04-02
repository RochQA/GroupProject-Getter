package com.qa.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.qa.entities.Account;
import com.qa.entities.Constants;
import com.qa.repository.AccountRepository;
@RestController
public class AccountGetterController {
	
	AccountRepository repo;
	
	public AccountGetterController(AccountRepository repo) {
		this.repo = repo;
	}
	
	@PostMapping("/createAccount")
	public String addNewUser(@RequestBody Account account) {
		repo.save(account);
		return Constants.SAVED;
	}
	
	@PutMapping("/getAccount")
	public Optional<Account> getAccount(@RequestBody Long accountId){
		return repo.findById(accountId);
	}
	@GetMapping("/getterAllAccounts")
	public List<Account> getAllAccounts(){
		return (List<Account>) repo.findAll();
	}
	@PutMapping("/updateAccount")
	public String updateAccount(@RequestBody Account account) {
		repo.save(account);
		return Constants.UPDATED;
	}
	@DeleteMapping("/deleteAccount")
	public String deleteAccount(@RequestBody Long accountId) {
		repo.deleteById(accountId);
		return Constants.DELETED;		
	}
}
