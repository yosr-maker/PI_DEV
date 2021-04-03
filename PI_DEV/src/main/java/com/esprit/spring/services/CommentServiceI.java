package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Comment;
import com.esprit.spring.entites.EvaluationComment;





public interface CommentServiceI {

	Comment addComment(Comment com,Long client_id,Long pub_id);
	
	 List<Comment> list(Long pub_id);
	 
	 List<Comment> mylist(Long pub_id, Long client_id);
	 
	
	 void deleteComment(long id) ;
	  Comment updateComment(Long id,String mot);
	  
	  List<Comment> Bestcomments();

	EvaluationComment addEv(EvaluationComment e, Long id);
	

	
}





