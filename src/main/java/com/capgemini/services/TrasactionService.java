package com.capgemini.services;

import com.capgemini.beans.DepositRequest;
import com.capgemini.beans.TransactionResponse;
import com.capgemini.beans.TransferAmtRequest;
import com.capgemini.beans.WithdrawRequest;

public interface TrasactionService {
	
	TransactionResponse depositAmount(DepositRequest depositRequest); 
	TransactionResponse withdrawAmount(WithdrawRequest withdrawRequest);
	TransactionResponse transferAmount(TransferAmtRequest transferAmtRequest);
}