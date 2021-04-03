package com.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Comment;
import com.esprit.spring.entites.EvaluationComment;
import com.esprit.spring.entites.Publication;

import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.CommentRepository;
import com.esprit.spring.repository.EvaluationCommentRepository;





@Service
public class CommentService implements CommentServiceI{
	
	@Autowired
	private CommentRepository commentRepository;
	
	@Autowired
	private ClientRepository clientRespository;
	
	@Autowired
	private PublicationService publicationService;
	
	@Autowired
	private EvaluationCommentRepository evaluationCommentRepository;
	
	public Comment addComment(Comment comment,Long client_id,Long pub_id) {
		
		Client clt = clientRespository.findById(client_id).get();
		
		Publication p = publicationService.findbyid(pub_id);
		
		comment.setClient(clt);
		comment.setPublication(p);
		
		commentRepository.save(comment);
		return comment ;
		
		
	}
	@Override
	public List<Comment> list(Long pub_id){
				
	Publication p = publicationService.findbyid(pub_id) ;
	List<Comment> l = commentRepository.list(p);
	return l ;
		
		
	}
	
	@Override	
	public void deleteComment(long id){
		
		commentRepository.deleteById(id); 
		
		}

	@Override
	public List<Comment> mylist(Long pub_id, Long client_id){
				
	Publication p = publicationService.findbyid(pub_id);
	Client clt = clientRespository.findById(client_id).get();

	List<Comment> l =commentRepository.mylist(p, clt);
	return l ;
		
		
	}
	///modify comment ////
	
	@Override	
	public Comment updateComment(Long id,String mot){
		
		Comment comment1 =commentRepository.findById(id).get(); 
		comment1.setMot(mot);
		
		commentRepository.save(comment1);
			return comment1;
		
		}
	
	
	
	///////evaluation/////////
	////initialiser e dans le controlleur >> view 
	@Override
	public EvaluationComment addEv(EvaluationComment e, Long id) {
		
		Comment c = commentRepository.findById(id).get();
		
		List<Comment> my = evaluationCommentRepository.evsave();
		if(my.contains(c)) {
			EvaluationComment v = evaluationCommentRepository.findev(c);
			v.setL(v.getL()+e.getL());
			v.setD(v.getD()+e.getD());
			
			
			evaluationCommentRepository.save(v);
			return v ;
			
			
	}
		else {
			e.setComment(c);
			evaluationCommentRepository.save(e);
			return e;
			
			
		}
	}
	///////////////////comments + pertinents//////////////////////
		@Override
		public List<Comment> Bestcomments(){
			
			
			
			List<Comment> list1 = evaluationCommentRepository.myfind(evaluationCommentRepository.best()) ;
			
		    
			return list1;
			
			
			
			
		}
		
		
		


}
