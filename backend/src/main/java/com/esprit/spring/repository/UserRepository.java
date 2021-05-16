package com.esprit.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.esprit.spring.entites.User;

@Repository
public interface UserRepository  extends JpaRepository<User, Long>{
	
	@Query("select u from User u where u.username=:username")
	User findByUsername(@Param ("username") String username);
	
	User findByUsernameAndEmail(String username,String email);
	
	
	@Query("SELECT u FROM User u WHERE u.email=:email and u.password=:password")
	public User getemailByEmailAndPassword(@Param("email")String login, @Param("password")String password);
	
}
