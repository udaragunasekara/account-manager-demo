package com.ug.accountmanagerdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ug.accountmanagerdemo.model.Account;
import com.ug.accountmanagerdemo.request.AccountRequest;
import com.ug.accountmanagerdemo.response.AccountResponse;
import com.ug.accountmanagerdemo.service.AccountService;

@RestController
@RequestMapping("/api")
public class BFFController {

	@Autowired
	private AccountService accountsService;

	@PostMapping("/accounts")
	public ResponseEntity<AccountResponse> createAccount(@Valid @RequestBody AccountRequest accountRequest) {
		String ownerName = SecurityContextHolder.getContext().getAuthentication().getName();

		Account createdAccount = accountsService.createAccount(fromAccountRequest(accountRequest), ownerName);

		return ResponseEntity.ok(toAccountResponse(createdAccount));
	}
	
	private Account fromAccountRequest(@Valid AccountRequest accountRequest) {
		// TODO Should ideally use something like Mapstruct to do this automatically.
		// Don't have time to config now
		Account account = Account.builder().name(accountRequest.getName()).description(accountRequest.getDescription())
				.build();
		return account;
	}

	private AccountResponse toAccountResponse(Account account) {
		return AccountResponse.builder().id(account.getId()).name(account.getName()).description(account.getDescription())
				.ownedBy(account.getOwnedBy().getUsername()).build();
	}
}
