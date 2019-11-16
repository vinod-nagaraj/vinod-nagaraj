package com.example.demo.service;

import com.example.demo.dto.BeneficiaryRequestDto;
import com.example.demo.dto.BeneficiaryResponseDto;
import com.example.demo.exception.UnsuccessfulRegistrationException;

public interface BeneficiaryService {
	public BeneficiaryResponseDto addBeneficiary(BeneficiaryRequestDto beneficiaryRequestDto)
			throws UnsuccessfulRegistrationException;

}
