package com.example.demo.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.BeneficiaryRequestDto;
import com.example.demo.dto.BeneficiaryResponseDto;
import com.example.demo.entity.Beneficiary;
import com.example.demo.exception.UnsuccessfulRegistrationException;
import com.example.demo.repository.BeneficiaryRepository;
import com.example.demo.utility.UserUtil;

@Service
public class BeneficiaryImpl implements BeneficiaryService {

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	@Override
	public BeneficiaryResponseDto addBeneficiary(BeneficiaryRequestDto beneficiaryRequestDto) throws UnsuccessfulRegistrationException {
		

		Beneficiary beneficiary = new Beneficiary();

		if (beneficiaryRequestDto == null) {
			throw new UnsuccessfulRegistrationException(UserUtil.REGISTRATION_FAILURE_STATUS);
		} else {

			BeanUtils.copyProperties(beneficiaryRequestDto, beneficiary);

			beneficiaryRepository.save(beneficiary);
			BeneficiaryResponseDto beneficiaryResponseDto = new BeneficiaryResponseDto();
			beneficiaryResponseDto.setMessage("Beneficiary added succesfully");
			beneficiaryResponseDto.setStatusCode(HttpStatus.CREATED.value());
			return beneficiaryResponseDto;
		}
	}

}
