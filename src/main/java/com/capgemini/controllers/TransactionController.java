package com.capgemini.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.Account;
import com.capgemini.beans.DepositRequest;
import com.capgemini.beans.TransactionResponse;
import com.capgemini.beans.WithdrawRequest;
import com.capgemini.services.Impl.TrasactionServiceImpl;

@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {
	
	@Autowired
    private TrasactionServiceImpl trasactionServiceImpl;
	
	/*
	 * @PutMapping(value = "/withdraw") public ResponseEntity<TransactionResponse>
	 * withdrawAmount(@RequestBody WithdrawRequest withdrawRequest) {
	 * TransactionResponse response=
	 * trasactionServiceImpl.withdrawAmount(withdrawRequest); return
	 * ResponseEntity.ok().body(response);
	 * 
	 * }
	 */
	@PutMapping(value = "/deposit")
	public TransactionResponse depositAmount(@RequestBody DepositRequest depositRequest) {
		TransactionResponse response= trasactionServiceImpl.depositAmount(depositRequest);
		return response;

	}
	@PutMapping(value = "/withdraw")
	public TransactionResponse withdrawAmount(@RequestBody WithdrawRequest withdrawRequest) {
		TransactionResponse response= trasactionServiceImpl.withdrawAmount(withdrawRequest);
		return response;

	}
	
	
	
	
}
