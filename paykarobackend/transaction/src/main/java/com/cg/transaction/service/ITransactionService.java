package com.cg.transaction.service;

import java.util.List;
import java.util.Optional;

import com.cg.transaction.dao.TransactionDao;
import com.cg.transaction.entity.Transaction;

public interface ITransactionService {

	String TransferMoney(Transaction transactionDao);
	
	List<Transaction> getAllTransaction(int userId,int pageSize,int pageNumber);
	List<Transaction> getAllTransactionById(int userId);

	
}
