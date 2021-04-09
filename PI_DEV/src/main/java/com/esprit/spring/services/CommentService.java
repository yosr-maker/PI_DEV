package com.esprit.spring.services;


import java.util.ArrayList;
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
import com.esprit.spring.repository.PublicationRepository;




@Service
public class CommentService implements CommentServiceI{
	
	@Autowired
	CommentRepository commentRepository;
	
	@Autowired
	ClientRepository clientRespository;
	
	@Autowired
	PublicationRepository publicationRepository;
	
	@Autowired
	PublicationService publicationService;
	
	@Autowired
	EvaluationCommentRepository evaluationCommentRepository;
	
	
	
	
	

	
	@Override
	public List<Comment> list(Long pub_id){
				
	Publication p = publicationRepository.findById(pub_id).get() ;
	List<Comment> l = commentRepository.list(p);
	return l ;
		
		
	}
	
	@Override	
	public void deleteComment(long id){
		
		commentRepository.deleteById(id); 
		
		}

//	@Override
//	public List<Comment> pertinentComments(Long pub_id, Long client_id){
//				
//	Publication p = publicationRepository.findById(pub_id).get();
//	Client clt = clientRespository.findById(client_id).get();
//
//	List<Comment> l =commentRepository.myComments(p, clt);    // commentservice.mycomments 
//	return l ;
//		
//		
//	}
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
	public EvaluationComment addEvaluation(EvaluationComment e, Long id) {
		
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
	//comments les plus pertinents
		@Override
		public List<Comment> Bestcomments(){
			
			
			
			List<Comment> list = evaluationCommentRepository.myfind(evaluationCommentRepository.best()) ;
			
		    
			return list;
			
			
			
			
		}
		@Override
		public List<Comment> pertinentComments(Long pub_id, Long client_id) {
			// TODO Auto-generated method stub
			return null;
		}
//
//		@Override
//		public Comment addComment(Comment comment,Long client_id,Long pub_id) {
//			
//			Client clt = clientRespository.findById(client_id).get();
//			
//			Publication p = publicationRepository.findById(pub_id).get();
//			
//			comment.setClient(clt);
//			comment.setPublication(p);
//			
//			commentRepository.save(comment);
//			return comment ;
//			
//			
//		
//		}	
		@Override
		public Comment addComment(Comment comment,Long client_id,Long pub_id) {
			
			List<String> forbiddenwords = new ArrayList<>();
			forbiddenwords.add("con");
			forbiddenwords.add("***");
			forbiddenwords.add("mdr");
			forbiddenwords.add("raciste");
			forbiddenwords.add("stupid");
			forbiddenwords.add("shut");
			forbiddenwords.add("violance");
			forbiddenwords.add("frapper");
			
			
			 if (isForbidden(comment))
				 return null ; 
			 else {
				 
				    Client clt = clientRespository.findById(client_id).get();
					
					Publication p = publicationRepository.findById(pub_id).get();
					
					comment.setClient(clt);
					comment.setPublication(p);
					
					commentRepository.save(comment);
					return comment ;
			 }
		}
			
		    @Override
			public boolean isForbidden (Comment cmt) {
				
				List<String> forbiddenwords = new ArrayList<>();
				
				String mot = cmt.getMot();
			
			  for (String s:forbiddenwords) {
				if (check(s,mot)) {
					
				  return true ;
				  }
				
					
			  } 
			return false ;
			
		
			}
			
			
	
		
			
         public boolean check(String word, String mot)  {
        	 if(word.length() > mot.length())
        		 return false ; 
        	 
        	 int i=0 ;
        	 while (i<word.length()) {
        		 if(word.charAt(i) != mot.charAt(i))
        			 return false ; 
        		 i++;
        	 }
        	 return true ; 
        	 
         }
}
