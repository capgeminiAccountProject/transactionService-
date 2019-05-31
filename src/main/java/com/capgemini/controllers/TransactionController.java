package com.capgemini.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.beans.DepositRequest;
import com.capgemini.beans.TransactionResponse;
import com.capgemini.beans.TransferAmtRequest;
import com.capgemini.beans.WithdrawRequest;
import com.capgemini.services.Impl.TrasactionServiceImpl;
import com.capgemini.util.AppConstants;

@RestController
@RequestMapping(value = "/account", produces = MediaType.APPLICATION_JSON_VALUE)
public class TransactionController {

	private static final Logger logger = LoggerFactory.getLogger(TransactionController.class);

	@Autowired
	private TrasactionServiceImpl trasactionServiceImpl;

	@PutMapping(value = "/deposit")
	public TransactionResponse depositAmount(@RequestBody DepositRequest depositRequest,
			@RequestHeader String authorization) {
		
		logger.info("depositAmount request : " + depositRequest.toString());

		TransactionResponse response = new TransactionResponse();

		String tokenStatus = trasactionServiceImpl.validateToken(authorization);
		if (tokenStatus.equalsIgnoreCase(AppConstants.SUCCESS)) {
			response = trasactionServiceImpl.depositAmount(depositRequest);
		} else {
			response.setMessage("Invalid Token");
			response.setStatus("404");
		}
		return response;

	}

	@PutMapping(value = "/withdraw")
	public TransactionResponse withdrawAmount(@RequestBody WithdrawRequest withdrawRequest,
			@RequestHeader String authorization) {
		
		logger.info("withdrawRequest request : " + withdrawRequest.toString());

		TransactionResponse response = new TransactionResponse();

		String tokenStatus = trasactionServiceImpl.validateToken(authorization);
		if (tokenStatus.equalsIgnoreCase(AppConstants.SUCCESS)) {
			response = trasactionServiceImpl.withdrawAmount(withdrawRequest);
		} else {
			response.setMessage("Invalid Token");
			response.setStatus("404");
		}
		return response;

	}

	@PutMapping(value = "/transfer")
	public TransactionResponse transferAmount(@RequestBody TransferAmtRequest transferAmtRequest,
			@RequestHeader String authorization) {
		logger.info("transferAmtRequest request : " + transferAmtRequest.toString());

		TransactionResponse response = new TransactionResponse();

		String tokenStatus = trasactionServiceImpl.validateToken(authorization);
		if (tokenStatus.equalsIgnoreCase(AppConstants.SUCCESS)) {
			response = trasactionServiceImpl.transferAmount(transferAmtRequest);
		} else {
			response.setMessage("Invalid Token");
			response.setStatus("404");
		}

		return response;

	}

}
