package com.capgemini.services.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.beans.Account;
import com.capgemini.beans.DepositRequest;
import com.capgemini.beans.TransactionResponse;
import com.capgemini.beans.TransferAmtRequest;
import com.capgemini.beans.WithdrawRequest;
import com.capgemini.exceptions.Impl.TransactionExceptionImpl;
import com.capgemini.repository.TransactionCrudRepository;
import com.capgemini.services.TrasactionService;
@Service
public class TrasactionServiceImpl implements TrasactionService{

	@Autowired
	TransactionCrudRepository accountCrudRepository;

	
	@Override
	public TransactionResponse depositAmount(DepositRequest depositRequest) {
		TransactionResponse response = new TransactionResponse();
		try {
			Account account = getAccountByAccountNum(depositRequest.getAccountNumber());
			double initialBal = account.getBalance();
			double newBal = depositRequest.getAmount() + initialBal;
			account.setBalance(newBal);
			accountCrudRepository.save(account);

		} catch (TransactionExceptionImpl e) {
			response.setMessage(e.getMessage());
			response.setStatus("404");
			e.printStackTrace();
		}
		
		
		return response;
	}

	@Override
	public TransactionResponse withdrawAmount(WithdrawRequest withdrawRequest) {
		
		TransactionResponse response = new TransactionResponse("success", "Transaction Success");
		return response;
	}

	@Override
	public TransactionResponse transferAmount(TransferAmtRequest transferAmtRequest) {
		// TODO Auto-generated method stub
		return null;
	}

	public Account getAccountByAccountNum(int accountNum) throws TransactionExceptionImpl {

		return accountCrudRepository.findById(accountNum)
				.orElseThrow(() -> new TransactionExceptionImpl(404, "AccountNum not available"));

	}
	
}
