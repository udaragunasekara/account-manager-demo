package com.ug.accountmanagerdemo.service;

import java.util.List;
import java.util.Optional;

import com.ug.accountmanagerdemo.model.Account;

public interface AccountService {

	Account createAccount(Account account, String owner);
	
	List<Account> getAllAcounts();
	
	Optional<Account> getAccount(Long id);
}
