package com.example.demo.service;

import java.time.LocalDate;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.example.demo.dto.TransactionDetailsRequestDto;
import com.example.demo.dto.TransactionDetailsResponseDto;
import com.example.demo.entity.Beneficiary;
import com.example.demo.entity.TransactionDetails;
import com.example.demo.exception.InsufficientBalanceException;
import com.example.demo.repository.BeneficiaryRepository;
import com.example.demo.repository.TransactionDetailsRepository;
import com.example.demo.repository.UserRepository;
import com.example.demo.utility.TransactionUtil;

@Service
public class TransactionDetailsServiceImpl implements TransactionDetailsService {
	@Autowired
	UserRepository userRepository;

	@Autowired
	TransactionDetailsRepository transactionDetailsRepository;

	@Autowired
	BeneficiaryRepository beneficiaryRepository;

	@Override
	public TransactionDetailsResponseDto trasactions(TransactionDetailsRequestDto transactionDetailsRequestDto)
			throws InsufficientBalanceException {
		TransactionDetailsResponseDto transactionDetailsResponseDto;
		// Optional<User> user =
		// userRepository.findById(transactionDetailsRequestDto.getFromUserId());
		com.example.demo.entity.User user = userRepository.findById(transactionDetailsRequestDto.getFromUserId()).get();
		Beneficiary beneficiary = beneficiaryRepository.findById(transactionDetailsRequestDto.getBeneficiaryId()).get();
		if (user.getAmount() <= 0) {
			throw new InsufficientBalanceException(TransactionUtil.INSUFFICIENT_BALANCE_ERROR_STATUS);
		} else {
			TransactionDetails transactionDetails = new TransactionDetails();

			BeanUtils.copyProperties(transactionDetailsRequestDto, transactionDetails);
			transactionDetails.setTransactionType("CREDITED");
			transactionDetails.setTransactionDate(LocalDate.now());
			double fromUserBalance = user.getAmount() - transactionDetailsRequestDto.getAmount();
			transactionDetails.setFromUserAccountBalance(fromUserBalance);

			transactionDetailsRepository.save(transactionDetails);
			user.setAmount(fromUserBalance);
			userRepository.save(user);

			double beneficiaryBalance = beneficiary.getAmount() + transactionDetailsRequestDto.getAmount();
			beneficiary.setAmount(beneficiaryBalance);
			beneficiaryRepository.save(beneficiary);
			transactionDetailsResponseDto = new TransactionDetailsResponseDto();
			transactionDetailsResponseDto.setMessage(TransactionUtil.TRANSACTION_SUCCESSFUL_STATUS);
			transactionDetailsResponseDto.setStatusCode(HttpStatus.OK.value());
		}
		return transactionDetailsResponseDto;
	}

	
	}
