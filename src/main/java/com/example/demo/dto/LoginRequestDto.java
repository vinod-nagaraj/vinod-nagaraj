package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LoginRequestDto {
	private static String userName;
	private static String password;
	public static String getUserName() {
		return userName;
	}
	public static void setUserName(String userName) {
		LoginRequestDto.userName = userName;
	}
	public static String getPassword() {
		return password;
	}
	public static void setPassword(String password) {
		LoginRequestDto.password = password;
	}
	
		
	}

