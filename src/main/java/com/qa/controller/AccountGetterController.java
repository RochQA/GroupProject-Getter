package com.qa.controller;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.qa.entities.Account;
import com.qa.repository.AccountRepository;
@Controller
@RequestMapping
public class AccountGetterController {
	
	AccountRepository repo;
	
	public AccountGetterController(AccountRepository repo) {
		this.repo = repo;
	}
	
	@PostMapping("/createAccount")
	public String addNewUser(@RequestBody Account account) {
		repo.save(account);
		return "Saved";
	}
	
	@GetMapping("/getAccount")
	public Optional<Account> getAccount(@RequestBody Long accountId){
		return repo.findById(accountId);
	}
	@GetMapping("/getAllAccounts")
	public Iterable<Account> getAllAccounts(){
		return repo.findAll();
	}
	@PutMapping("/updateAccount")
	public String updateAccount(@RequestBody Account account) {
		repo.save(account);
		return "Updated";
	}
	@DeleteMapping("/deleteAccount")
	public String deleteAccount(@RequestBody Long accountId) {
		repo.deleteById(accountId);
		return "deleted";		
	}
}
