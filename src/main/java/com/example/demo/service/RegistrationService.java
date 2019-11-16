package com.example.demo.service;

import org.springframework.web.bind.annotation.RequestBody;

import com.example.demo.dto.RegistrationRequestDto;
import com.example.demo.dto.RegistrationResponseDto;
import com.example.demo.exception.UnsuccessfulRegistrationException;

public interface RegistrationService {
	public RegistrationResponseDto registerUser(@RequestBody RegistrationRequestDto registrationRequestDto)
			throws  UnsuccessfulRegistrationException;

}
