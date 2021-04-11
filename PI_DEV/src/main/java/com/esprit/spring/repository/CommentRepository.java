package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Comment;
import com.esprit.spring.entites.Publication;




@Repository



public interface CommentRepository extends CrudRepository<Comment,Long>{
	//list of comments
	 @Query("select p from Comment p where p.publication=:publication")
	 public List<Comment> list(@Param("publication") Publication publication);
	 
	 
	 //list of client's comments of the publication
	 @Query("select p from Comment p where p.publication=:publication and p.client=:client")
	 public List<Comment> myComments(@Param("publication") Publication publication,@Param("client") Client client);


	
}
	 
	