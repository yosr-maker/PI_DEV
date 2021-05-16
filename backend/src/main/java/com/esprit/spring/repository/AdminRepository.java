package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Admin;


@Repository

public interface AdminRepository extends CrudRepository<Admin, Long> {



	
	@Query("select a from Admin a where a.username=:username")
	Admin findByUsername(@Param ("username") String username);
	
	Admin findByUsernameAndEmail(String username,String email);
}
//