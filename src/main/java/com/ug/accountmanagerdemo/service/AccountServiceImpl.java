package com.ug.accountmanagerdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ug.accountmanagerdemo.model.Account;
import com.ug.accountmanagerdemo.model.User;
import com.ug.accountmanagerdemo.repository.AccountRepository;
import com.ug.accountmanagerdemo.repository.UserRepository;

@Service
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepository accountsRepo;
	
	@Autowired
	private UserRepository userRepo;
	
	@Transactional
	@Override
	public Account createAccount(Account account, String ownerName) {
		Optional<User> owner = userRepo.findByUsername(ownerName);
		User user = owner.orElseThrow(()-> new IllegalArgumentException("User Not found in the db"));
		account.setOwnedBy(user);
		
		return accountsRepo.save(account);
	}

}
