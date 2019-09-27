package com.ug.accountmanagerdemo.controller;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import com.ug.accountmanagerdemo.request.AuthRequest;
import com.ug.accountmanagerdemo.response.AuthResponse;

@SpringBootTest
class LoginControllerTest {

	@Autowired
	private LoginController loginController;

	@Test
	void test_given_valid_user_credential_then_generate_token() throws Exception {
		ResponseEntity<AuthResponse> response = loginController.createAuthenticationToken(
				AuthRequest.builder().username("admin").password("adminPassword0987!").build());
		
		assertNotNull(response);
		assertNotNull(response.getBody().getToken());
	}

}
