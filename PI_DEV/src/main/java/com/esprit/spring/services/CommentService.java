package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Comment;
import com.esprit.spring.entites.EvaluationComment;
import com.esprit.spring.repository.CommentRepository;

@Service
public class CommentService implements CommentServiceI{

	@Autowired
	CommentRepository commentRepository;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(CommentService.class);
	
	
	@Override
	public List<Comment> retrieveAllComments() {
		List<Comment> comments= (List<Comment>) commentRepository.findAll();
		for (Comment comment: comments){
			l.info("la liste des commentaires donnés   +++ :" + comment);
		}
		
		return comments ;
	}
		

	@Override
	public Comment addComment(Comment c) {
		 commentRepository.save(c);
		return null ;
	}

	@Override
	public void deleteComment(String id) {
		commentRepository.deleteById(Long.parseLong(id));
		
	}

	@Override
	public Comment updateComment(Comment c) {
		 commentRepository.save(c);
		return null;
	}

	@Override
	public Comment retrieveComment(String id) {
	  Comment comment = commentRepository.findById(Long.parseLong(id)).orElse(null);
		return comment ;
	}


	@Override
	public void deleteComment(long commentId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addEv(EvaluationComment u, Long commentId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Comment> Bestcomments() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void addComment(Comment u, int id, Long publicationId) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public List<Comment> list(Long publicationId) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<Comment> mylist(Long publicationId, int id) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public Comment updateComment(Long id, String mot) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
