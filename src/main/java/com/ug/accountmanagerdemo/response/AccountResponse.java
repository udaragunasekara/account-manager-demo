package com.ug.accountmanagerdemo.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountResponse {

	private Long id;
	
	private String name;
	
	private String description;
	
	private String ownedBy;
}
