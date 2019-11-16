package com.example.demo.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.exception.InvalidUserException;

public interface LoginService {
	public LoginResponseDto login(@RequestBody LoginRequestDto loginRequestDto)throws InvalidUserException;
}
