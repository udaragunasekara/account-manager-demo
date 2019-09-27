package com.ug.accountmanagerdemo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.ug.accountmanagerdemo.model.Account;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long>{

}
