package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Useraccount;



@Repository
public interface UseraccountRepository  extends CrudRepository<Useraccount, Long>{
	
	
	
}
