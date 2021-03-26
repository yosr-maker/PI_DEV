package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Comment;



@Repository
public interface CommentRepository extends CrudRepository<Comment,Long>  {

}
