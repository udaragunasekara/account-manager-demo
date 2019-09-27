package com.ug.accountmanagerdemo.service;

import com.ug.accountmanagerdemo.model.Account;

public interface AccountService {

	Account createAccount(Account account, String owner);
}
