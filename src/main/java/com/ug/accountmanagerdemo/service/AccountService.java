package com.ug.accountmanagerdemo.service;

import java.util.List;

import com.ug.accountmanagerdemo.model.Account;

public interface AccountService {

	Account createAccount(Account account, String owner);
	
	List<Account> getAllAcounts();
}
