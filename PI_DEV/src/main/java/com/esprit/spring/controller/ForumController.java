package com.esprit.spring.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Comment;
import com.esprit.spring.entites.EvaluationComment;
import com.esprit.spring.entites.Publication;
import com.esprit.spring.entites.Recherche;
import com.esprit.spring.entites.EvaluationPublication;

import com.esprit.spring.services.ClientService;
import com.esprit.spring.services.CommentServiceI;

import com.esprit.spring.services.PublicationServiceI;
import com.esprit.spring.services.RechercheServiceI;







@RestController

public class ForumController {
	
		@Autowired
		ClientService clientService;
		
		@Autowired
		PublicationServiceI publicationService;
		
		@Autowired
		RechercheServiceI rechercheService;
		
		@Autowired
		CommentServiceI commentService;
		
	
		
	
     

	@GetMapping("/RecentPub")
	@ResponseBody
	public List<String> recentPub() {
		List<String> list = publicationService.pub();
	return list;
	}
	
	
	
	@GetMapping("/recherchePub/{title}")
	@ResponseBody
	public Publication Publication (@PathVariable("title") String title) {
		return publicationService.retrievePublicationByTitle(title);
	}
	

	@GetMapping("/pubadequate")
	@ResponseBody
	public Response publicationAdequate() {
		
	String max = rechercheService.extract(ClientController.CLIENTCONNECTED.getId()); 
	List<Publication> list = publicationService.retrievePublicationByType(max);


	if (list.size()==0) {
		return Response.status(Status.NOT_FOUND).entity( "faites une petite recherche!  ").build();

	                   
	}
	else{
		return Response.status(Status.OK).entity(list).build();

		}
	}

	
	
	@GetMapping("/rechercheType/{type}")
	@ResponseBody
	public Response addRechercheParType(@PathVariable("type") String type) {
		
		
		Recherche r = new Recherche(type);
		 
		 List<Publication> list = publicationService.retrievePublicationByType(type);
		 
		 
		 
	    if (list.size()==0) {
	    	return Response.status(Status.NOT_FOUND).entity( "Pas de publication de ce type!").build();
	                       
	    }
	    else {
	    	
	rechercheService.addSearch(r, ClientController.CLIENTCONNECTED.getId());
	return Response.status(Status.OK).entity(list).build();
	    }
	}
		 
	
	
	
	
	
	@GetMapping("/retrieve-publications")
	@ResponseBody
	public List<Publication> getPublications() {
	List<Publication> list = publicationService.retrieveAllPublications();
	return list;
	}

	@PutMapping("/modify-publication")
	@ResponseBody
	public Publication updatePublication(@RequestBody Publication p ) {
	return publicationService.updatePublication(p);
	}





	

	
	@PostMapping("/Publication")
	@ResponseBody
	public String addPublication(@RequestBody Publication pu ) {
	    Publication pubexists = publicationService.test(pu.getType(), pu.getDescription());
	   
	    if (pubexists != null) {
	    	return  "Nous sommes désolés mais il semble que vous êtes entrain de publier une publication avec un contenu qui existe déjà ... veuillez vérifier s'il vous plait" ;
	    			
	                       
	    }
	    else {
	    	publicationService.addPublication(pu);
	    	 return "votre publication a éte publiée avec succès" ; 
	    			 
	    }
	}
    
	@DeleteMapping("/delete-publication/publication-id}")
	@ResponseBody
	public void deletePublication(@PathVariable("publication-id") long publicationId) {
		publicationService.deletePublication(publicationId);
	}



	

	
	
	@PostMapping("/addComment/{publicationId}")
	@ResponseBody
	public String addComment(@RequestBody Comment u, Long id,@PathVariable("publicationId") Long publicationId) {
		
		
		
		
		 if (commentService.isForbidden(u))
			 return  "votre commentaire est  du contenu indésirable " ; 

		 else {

		
			 commentService.addComment(u,ClientController.CLIENTCONNECTED.getId(),publicationId);
			 return "Votre commentaire a été bien ajouté" ;
		 }
		
	
	    }
	
	
	@GetMapping("/MostActifClient/{publicationId}")
	@ResponseBody
	public Client activeClient(@PathVariable("publicationId") Long publicationId) {
		
		return commentService.activeClient(publicationId);
	}
	
	
	
	


	
	@GetMapping("/ListComment/{publicationId}")
	@ResponseBody
	public List<Comment> retireveComment(@PathVariable("publicationId") Long publicationId) {
	List<Comment> l = commentService.retireveComment(publicationId);
   

	if (l.size()==0) {
		return null ;

		}
	else {
		return l;

	}
	}
	

	@PutMapping("/modify-comment/{commentId}")
	@ResponseBody
	public String updateComment(@RequestBody String mot,@PathVariable("commentId") Long id) {
	 commentService.updateComment(id, mot);
	 
	 return "votre commentaire a été bien modifié " ; 
	}


	@DeleteMapping("/delete-comment/{commentId}")
	@ResponseBody
	public void deleteComment(@PathVariable("commentId") long commentId) {
		commentService.deleteComment(commentId);
	}


	
	
	@PostMapping("/evaluationPub/{publicationId}")
	@ResponseBody
	public String EvaluationPublication(@RequestBody EvaluationPublication eva , @PathVariable("publicationId") Long publicationId) {
		publicationService.addEvaluation(eva , publicationId);
		
	return " Le star a été ajouté avec succés " ;

	    }  

	

	
	@PostMapping("/evaluate/{commentId}")
	@ResponseBody
	public String addevaluation(@RequestBody EvaluationComment u,@PathVariable("commentId") Long commentId) {
		
		commentService.addEvaluation(u, commentId);
	return "votre evaluation a été bien enregistrée " ;
	    }

		
		
	


	@GetMapping("/pertinentComments")
	@ResponseBody
	public List<Comment> Pertinentcomments() {

		 
		return commentService.Pertinentcomments();

	}


	@GetMapping("/publicationNonComentes")
	@ResponseBody
	public List<Long> publicationNonCommentes() {

		 
		return publicationService.publicationNonCommentes();

	}




}
