package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.RegistrationRequestDto;
import com.example.demo.dto.RegistrationResponseDto;
import com.example.demo.entity.User;
import com.example.demo.exception.UnsuccessfulRegistrationException;
import com.example.demo.repository.UserRepository;
import com.example.demo.utility.UserUtil;

@Service
public class RegistrationServiceImpl implements RegistrationService {
	@Autowired
	UserRepository userRepository;

	@Override
	public RegistrationResponseDto registerUser(RegistrationRequestDto registrationRequestDto)
			throws UnsuccessfulRegistrationException {
		User user = new User();
		BeanUtils.copyProperties(registrationRequestDto, user);
		userRepository.save(user);
		RegistrationResponseDto registrationResponseDto = new RegistrationResponseDto();
		registrationResponseDto.setMessage(UserUtil.REGISTRATION_SUCCESS_STATUS);
		registrationResponseDto.setStatus(HttpStatus.CREATED.value());
		return registrationResponseDto;
	}

	
	}


