package com.capgemini.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.beans.Account;

@Repository
public interface TransactionCrudRepository extends CrudRepository<Account, Integer> {

}
