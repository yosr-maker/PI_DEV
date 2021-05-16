package com.esprit.spring.services;


import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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
	
	public static String[] forbiddenWords = new String[] {"con","mdr","***","raciste","stupid","shut","violance","frapper"} ; 
	
	
	
	
	
	

	
	@Override
	public List<Comment> retireveComment(Long pub_id){
				
	Publication p = publicationRepository.findById(pub_id).get() ;
	List<Comment> l = commentRepository.list(p);
	return l ;
		
		
	}
	
	@Override	
	public void deleteComment(long id){
		
		commentRepository.deleteById(id); 
		
		}


	
	@Override	
	public Comment updateComment(Long id,String mot){
		
		Comment comment1 =commentRepository.findById(id).get(); 
		comment1.setMot(mot);
		
		commentRepository.save(comment1);
			return comment1;
		
		}
	
	
	
	
	@Override
	public EvaluationComment addEvaluation(EvaluationComment e, Long id) {
		
		Comment c = commentRepository.findById(id).get();
		
		List<Comment> commentsEvaluated = evaluationCommentRepository.evsave();
		if(commentsEvaluated.contains(c)) {
			EvaluationComment v = evaluationCommentRepository.findevaluation(c);
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
	
		@Override
		public List<Comment> Pertinentcomments(){
			
			
			
			List<Comment> list = evaluationCommentRepository.myfind(evaluationCommentRepository.mostliked()) ;
			
		    
			return list;
			
			
			
			
		}
		

		@Override
		public Comment addComment(Comment comment,Long client_id,Long pub_id) {
			
			Client clt = clientRespository.findById(client_id).get();
			
			Publication p = publicationRepository.findById(pub_id).get();
			
			comment.setClient(clt);
			comment.setPublication(p);  
			
			commentRepository.save(comment);
			return comment ;
			
			
		
		}	

			
		    @Override
		    public boolean isForbidden(Comment cmt) {
		    	
		        String[] mots = cmt.getMot().split(" ");
		        for(String s: forbiddenWords) {
		            if(check(s, mots))
		                return true;
		        }
		        return false;
		    }

		    public boolean check(String word, String[] mots) {
		    	for(String s: mots) {
		            if(s.equals(word))
		                return true;
		        }
		        return false;
		       
		    
			
		    }

		 
         
  
	  
	  @Override
	  public Client activeClient(Long idpub) {
		  
		    Publication publication = publicationRepository.findById(idpub).get();
	        List<Comment> comments = publication.getComments();
	        Map <Client, Integer> map = new HashMap<>();
	 
	        for (Comment cmt: comments) {
	            Client c = cmt.getClient();
	            if(map.containsKey(c)) {
	                Integer i = map.get(c);
	                map.replace(c, i + 1);
	            } else {
	                map.put(c, 1);
	            }
	        }
	 
	        Set<Entry<Client, Integer>> set = map.entrySet();
	 
	        Integer min = Integer.MIN_VALUE;
	        Client c = null;
	 
	        for(Entry<Client, Integer> entry: set) {
	            if(entry.getValue() >= min) {
	                min = entry.getValue();
	                c = entry.getKey();
	            }
	        }
	 
	 
	        return c;
	    }


}


