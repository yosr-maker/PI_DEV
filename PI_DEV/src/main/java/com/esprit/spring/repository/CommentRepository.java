package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.spring.entites.Comment;




public interface CommentRepository extends CrudRepository<Comment,Long>  {

}
