package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.beans.Account;
import com.capgemini.beans.Transaction;

@Transactional
@Repository
public interface TransactionCrudRepository extends CrudRepository<Transaction, Integer> {

}
