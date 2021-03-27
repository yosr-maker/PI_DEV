package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Comment;
import com.esprit.spring.entites.EvaluationComment;


public interface CommentServiceI {
	List<Comment> retrieveAllComments();
	Comment addComment(Comment c);
	void deleteComment (long commentId);
	Comment updateComment(Comment c);
	Comment retrieveComment(String id);
	void addEv(EvaluationComment u, Long commentId);
	List<Comment> Bestcomments();
	void addComment(Comment u, int id, Long publicationId);
	List<Comment> list(Long publicationId);
	List<Comment> mylist(Long publicationId, int id);
	Comment updateComment(Long id, String mot);
	void deleteComment(String id);
}





