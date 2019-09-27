package com.ug.accountmanagerdemo.request;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class AccountRequest {

	@NotBlank
	private String name;
	
	private String description;
	
}
