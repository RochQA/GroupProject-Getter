package com.qa.tests;
import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.controller.AccountGetterController;
import com.qa.entities.Account;
import com.qa.repository.AccountRepository;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
@SpringBootTest
public class AccountControllerTests {

	@Mock
	private AccountRepository accountRepo;
	
	@InjectMocks
	private AccountGetterController agc;
	
	private Account account;
	private Account account2;
	
	private Optional<Account> op = Optional.empty();
	private List<Account> accountList;
	
	@Before
	public void setup() {
	account = new Account();
	account2 = new Account();
	
	account.setId(1L);
	account2.setId(2L);
	accountList = new ArrayList<Account>();
	
	accountList.add(account);
	accountList.add(account2);
	}
	
	@Test
	public void testCreate() {
		Mockito.when(accountRepo.save(account)).thenReturn(account);
		assertEquals(agc.addNewUser(account),"Saved");
	}	
	
	@Test
	public void testGetAccount() {
		Mockito.when(accountRepo.findById(1L)).thenReturn(op);
		assertEquals(agc.getAccount(1L),op);
	}
	
	@Test
	public void testGetAllAccounts() {
		Mockito.when(accountRepo.findAll()).thenReturn(accountList);
		assertEquals(agc.getAllAccounts(), accountList);
	}
	
	@Test
	public void testUpdateAccounts() {
		Mockito.when(accountRepo.save(account)).thenReturn(account);
		assertEquals(agc.updateAccount(account),"Updated");
	}
	
	@Test
	public void testDeleteAccounts() {
		assertEquals(agc.deleteAccount(1L),"deleted");
	}
}
