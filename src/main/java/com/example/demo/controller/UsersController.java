package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginRequestDto;
import com.example.demo.dto.LoginResponseDto;
import com.example.demo.dto.RegistrationRequestDto;
import com.example.demo.dto.RegistrationResponseDto;
import com.example.demo.exception.InvalidUserException;
import com.example.demo.exception.UnsuccessfulRegistrationException;
import com.example.demo.service.LoginService;
import com.example.demo.service.RegistrationService;

@RestController
@RequestMapping("/fundtransafer")
public class UsersController {

	@Autowired
	LoginService loginService;

	@Autowired
	RegistrationService registrationService;

	@PostMapping("/registration")
	public ResponseEntity<RegistrationResponseDto> registerUsers(
			@RequestBody RegistrationRequestDto registrationRequestDto) throws UnsuccessfulRegistrationException {
		RegistrationResponseDto registrationResponseDto = registrationService.registerUser(registrationRequestDto);
		return new ResponseEntity<RegistrationResponseDto>(registrationResponseDto, HttpStatus.CREATED);
	}

	
	  @PostMapping("/login") public ResponseEntity<LoginResponseDto>
	  loginUser(@RequestBody LoginRequestDto loginRequestDto) throws
	  InvalidUserException { LoginResponseDto loginResponseDto =
	  loginService.login(loginRequestDto); return new
	 ResponseEntity<>(loginResponseDto, HttpStatus.OK); }
	 
	
}
