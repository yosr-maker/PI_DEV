package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Comment;
import com.esprit.spring.entites.EvaluationComment;





public interface CommentServiceI {

	List<Comment> list(Long pub_id);

	void deleteComment(long id);

	List<Comment> pertinentComments(Long pub_id, Long client_id);

	Comment updateComment(Long id, String mot);

	EvaluationComment addEvaluation(EvaluationComment e, Long id);

	List<Comment> Bestcomments();

	Comment addComment(Comment comment, Long client_id, Long pub_id);

	
	 boolean isForbidden (Comment cmt);

	
}





