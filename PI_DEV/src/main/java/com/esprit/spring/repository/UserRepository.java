package com.esprit.spring.repository;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.esprit.spring.entites.User;

@Repository
public interface UserRepository  extends CrudRepository<User, Long>{
	
	@Query("select u from User u where u.username=:username")
	User findByUsername(@Param ("username") String username);
	
	User findByUsernameAndEmail(String username,String email);

	
}
