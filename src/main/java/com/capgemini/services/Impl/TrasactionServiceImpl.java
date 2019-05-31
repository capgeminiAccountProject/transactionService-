package com.capgemini.services.Impl;

import java.time.LocalDateTime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.capgemini.beans.Account;
import com.capgemini.beans.DepositRequest;
import com.capgemini.beans.TokenRequest;
import com.capgemini.beans.TokenResponse;
import com.capgemini.beans.Transaction;
import com.capgemini.beans.TransactionResponse;
import com.capgemini.beans.TransferAmtRequest;
import com.capgemini.beans.WithdrawRequest;
import com.capgemini.exceptions.Impl.TransactionExceptionImpl;
import com.capgemini.repository.AccountCrudRepository;
import com.capgemini.repository.TransactionCrudRepository;
import com.capgemini.services.TrasactionService;
import com.capgemini.util.AppConstants;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class TrasactionServiceImpl implements TrasactionService {

	@Autowired
	AccountCrudRepository accountCrudRepository;

	@Autowired
	TransactionCrudRepository transactionCrudRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(TrasactionServiceImpl.class);

	@Override
	public TransactionResponse depositAmount(DepositRequest depositRequest) {
		TransactionResponse response = new TransactionResponse();
		try {
			Account account = getAccountByAccountNum(depositRequest.getAccountNumber());
			double initialBal = account.getBalance();
			double newBal = depositRequest.getAmount() + initialBal;
			account.setBalance(newBal);
			accountCrudRepository.save(account);

			Transaction transaction = new Transaction();
			transaction.setAmount(depositRequest.getAmount());
			transaction.setTo_account(depositRequest.getAccountNumber());
			transaction.setTransaction_type("Deposit");
			transaction.setCreate_time(LocalDateTime.now().toString());
			int id = transactionCrudRepository.save(transaction).getId_transactioin();

			response.setStatus("success");
			response.setMessage("Your Money got deposited successfully, transaction no. is: " + id);
		} catch (TransactionExceptionImpl e) {
			response.setMessage(e.getMessage());
			response.setStatus("404");
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public TransactionResponse withdrawAmount(WithdrawRequest withdrawRequest) {

		TransactionResponse response = new TransactionResponse();
		try {
			Account account = getAccountByAccountNum(withdrawRequest.getAccountNumber());
			double initialBal = account.getBalance();
			if (withdrawRequest.getAmount() > initialBal) {
				response.setMessage("Sorry you dont have sufficient amount in your account");
				response.setStatus("404");
				// return response;
			} else {
				double newBal = initialBal - withdrawRequest.getAmount();
				account.setBalance(newBal);
				accountCrudRepository.save(account);

				Transaction transaction = new Transaction();
				transaction.setAmount(withdrawRequest.getAmount());
				transaction.setFrom_account(withdrawRequest.getAccountNumber());
				transaction.setTransaction_type("Withdrawl");
				transaction.setCreate_time(LocalDateTime.now().toString());
				int id = transactionCrudRepository.save(transaction).getId_transactioin();

				response.setStatus(AppConstants.SUCCESS);
				response.setMessage("Your Money got successfully withdrawn, transaction no. is: " + id);
			}
		} catch (TransactionExceptionImpl e) {
			response.setMessage(e.getMessage());
			response.setStatus("404");
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public TransactionResponse transferAmount(TransferAmtRequest transferAmtRequest) {

		TransactionResponse response = new TransactionResponse();
		try {
			Account fromAccount = getAccountByAccountNum(transferAmtRequest.getFromAccountNumber());
			Account toAccount = getAccountByAccountNum(transferAmtRequest.getToAccountNumber());
			double initialFromBal = fromAccount.getBalance();
			double transferAmount = transferAmtRequest.getAmount();
			if (transferAmount > initialFromBal) {
				response.setMessage("Sorry you dont have sufficient amount in your account");
				response.setStatus("404");
				// return response;
			} else {
				double newBal = initialFromBal - transferAmount;
				fromAccount.setBalance(newBal);
				accountCrudRepository.save(fromAccount);

				toAccount.setBalance(transferAmount + toAccount.getBalance());
				accountCrudRepository.save(toAccount);

				Transaction transaction = new Transaction();
				transaction.setAmount(transferAmtRequest.getAmount());
				transaction.setFrom_account(transferAmtRequest.getFromAccountNumber());
				transaction.setTo_account(transferAmtRequest.getToAccountNumber());
				transaction.setTransaction_type("Transfer");
				transaction.setCreate_time(LocalDateTime.now().toString());
				int id = transactionCrudRepository.save(transaction).getId_transactioin();

				response.setStatus("success");
				response.setMessage("Your Money got successfully Transferred, transaction No. is " + id);
			}
		} catch (TransactionExceptionImpl e) {
			response.setMessage(e.getMessage());
			response.setStatus("404");
			e.printStackTrace();
		}

		return response;
	}

	@Override
	public Account getAccountByAccountNum(int accountNum) throws TransactionExceptionImpl {

		return accountCrudRepository.findById(accountNum)
				.orElseThrow(() -> new TransactionExceptionImpl(404, "AccountNum not available"));

	}
	
	@Override
	public String validateToken(String token) {
		final String uri = "https://token-001-fluent-klipspringer.cfapps.io/checktokenuser";
		TokenResponse tokenResponse = new TokenResponse();
		try {
			
			RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.add("authorization", token);
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			TokenRequest tokenRequest = new TokenRequest();
			tokenRequest.setEmail("sam@mailinator.com");
			tokenRequest.setToken(token);
			
			ObjectMapper mapper = new ObjectMapper();
			String tokenRequestString = mapper.writeValueAsString(tokenRequest);

			HttpEntity<String> entity = new HttpEntity<>(tokenRequestString, headers);

			String response = restTemplate.postForObject(uri, entity, String.class);
			tokenResponse = mapper.readValue(response, TokenResponse.class);
			logger.info("response status: " + tokenResponse.getStatus());
		} catch (Exception e) {
			tokenResponse.setStatus(AppConstants.FAILURE);
		}
		return tokenResponse.getStatus();

	}

}
