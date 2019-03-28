package com.qa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.qa.entities.Account;
import com.qa.repository.AccountRepository;
@Controller
@RequestMapping
public class GetterController {
	
	AccountRepository repo;
	
	public GetterController(AccountRepository repo) {
		this.repo = repo;
	}
	
	@GetMapping("/add")
	public String addNewUser() {
		Account n = new Account();
		n.setEmail("Test");
		n.setPassword("Weapon");
		repo.save(n);
		return "Saved";
	}
	
	@GetMapping(path="/all")
	public @ResponseBody Iterable<Account> getAllUsers(){
		return repo.findAll();
	}

}
