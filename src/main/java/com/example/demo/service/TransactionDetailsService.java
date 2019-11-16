package com.example.demo.service;

import com.example.demo.dto.TransactionDetailsRequestDto;
import com.example.demo.dto.TransactionDetailsResponseDto;
import com.example.demo.exception.InsufficientBalanceException;

public interface TransactionDetailsService {
	public TransactionDetailsResponseDto trasactions(TransactionDetailsRequestDto transactionDetailsRequestDto)
			throws InsufficientBalanceException;

}
