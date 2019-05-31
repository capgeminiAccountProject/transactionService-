package com.capgemini.repository;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.capgemini.beans.Account;

@Transactional
@Repository
public interface AccountCrudRepository extends CrudRepository<Account, Integer> {

}
