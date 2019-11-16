package com.example.demo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.InvalidUserException;
import com.example.demo.repository.BeneficiaryRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utility.UserUtil;

@Service
public class LoginServiceImpl implements LoginService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	
	  @Override 
	  public LoginResponseDto login(LoginRequestDto loginRequestDto)
	  throws InvalidUserException { 
		  
	  
	  LoginResponseDto loginResponseDto; 
	  Optional<User> user =userRepository.findByUserrNameAndUserPassword(LoginRequestDto.getUserName(),
	  LoginRequestDto.getPassword());
	  if (!user.isPresent()) 
	  { throw new
	  InvalidUserException(UserUtil.LOGIN_FAILURE_STATUS); } 
	  else {
	  loginResponseDto = new LoginResponseDto();
	  loginResponseDto.setMessage(UserUtil.LOGIN_SUCCESS_STATUS);
	  loginResponseDto.setStatus(HttpStatus.OK.value()); 
	
	} return loginResponseDto;
}}
	  
	

	