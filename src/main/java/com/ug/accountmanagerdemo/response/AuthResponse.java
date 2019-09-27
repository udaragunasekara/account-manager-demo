package com.ug.accountmanagerdemo.response;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AuthResponse implements Serializable {

	private String token;
	
	private String type;
}
