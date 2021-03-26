package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Comment;


public interface CommentServiceI {
	List<Comment> retrieveAllComments();
	Comment addComment(Comment c);
	void deleteComment (String id);
	Comment updateComment(Comment c);
	Comment retrieveComment(String id);
}





