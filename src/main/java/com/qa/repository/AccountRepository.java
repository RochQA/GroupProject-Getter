package com.qa.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.qa.entities.Account;
@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {
	 
}
