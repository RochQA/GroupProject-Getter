package com.qa.repository;

import org.springframework.data.repository.CrudRepository;

import com.qa.entities.Account;

public interface AccountRepository extends CrudRepository<Account, Long> {
	 
}
