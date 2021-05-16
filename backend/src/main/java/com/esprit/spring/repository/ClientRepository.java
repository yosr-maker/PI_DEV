package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Client;




@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{



	
	@Query("select c from Client c where c.username=:username")
	Client findByUsername(@Param ("username") String username);
	
	Client findByUsernameAndEmail(String username,String email);
}//