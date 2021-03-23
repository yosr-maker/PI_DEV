package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.UserAccount;

@Repository
public interface UserAccountRepository  extends CrudRepository<UserAccount,Long>{



}
