package com.esprit.spring.controller;

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


import com.esprit.spring.entites.Comment;
import com.esprit.spring.entites.EvaluationComment;
import com.esprit.spring.entites.Publication;
import com.esprit.spring.entites.Recherche;
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
		
		@Autowired
		ClientController ClientController ; 
		


     //afficher publication à la une

	@GetMapping("/listpublication")
	@ResponseBody
	public List<String> getdate() {
		List<String> list = publicationService.pub();
	return list;
	}
	//find Publication by title
	@GetMapping("/showPublication/{title}")
	@ResponseBody
	public Publication Publication (@PathVariable("title") String title) {
		return publicationService.listbytitle(title);
	}
	//publication adéquates au profil

	@GetMapping("/findinterested")
	@ResponseBody
	public Response findinterested() {
		
	String max = rechercheService.extract(ClientController.CLIENTCONNECTED.getId()); 
	List<Publication> list = publicationService.findbyType(max);


	if (list.size()==0) {
		return Response.status(Status.NOT_FOUND).entity( "faites une petite recherche!  ").build();

	                   
	}
	else{
		return Response.status(Status.OK).entity(list).build();

		}
	}

	
	// enregistrer ma recherche et retourner les publications cherchées
	@GetMapping("/search/{type}")
	@ResponseBody
	public Response addSearch(@PathVariable("type") String type) {
		
		
		Recherche r = new Recherche(type);
		 
		 List<Publication> list = publicationService.findbyType(type);
		 
		 
		 
	    if (list.size()==0) {
	    	return Response.status(Status.NOT_FOUND).entity( "Pas de publication de ce type!").build();
	                       
	    }
	    else {
	    	
	rechercheService.addSearch(r, ClientController.CLIENTCONNECTED.getId());
	return Response.status(Status.OK).entity(list).build();
	    }
	}
		 
	
	//////CRUD Publication//////
	///////list of all Publications///////////
//	@GetMapping("/retrievepublications")
//	@ResponseBody
//	public List<Publication> retrieveALLpublication() {
//	List<Publication> l = publicationService.retrieveALLpublication();
//	return l ;
//	}
	
	
	
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





	//pour ADMIN test publication  redondantes
	@PostMapping("/Publication")
	@ResponseBody
	public String addPublication(@RequestBody Publication pu) {
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



	//CRUD COMMERNT  AVEC CONDITION (mots interdits)

	@PostMapping("/addComment/{publicationId}")
	@ResponseBody
	public String addComment(@RequestBody Comment c,@PathVariable("publicationId") Long publicationId) {
		
		commentService.addComment(c,ClientController.CLIENTCONNECTED.getId(),publicationId);
	return "Votre commentaire a été bien ajouté " ; 

	    }

	//all comments  ajouter une exception 
	@GetMapping("/ListComment/{publicationId}")
	@ResponseBody
	public List<Comment> list(@PathVariable("publicationId") Long publicationId) {
	List<Comment> l = commentService.list(publicationId);
    // List<Comment> l2 = l2.add("Aucun commentaire pour cette publication! ");
	

	if (l.size()==0) {
		return null ;

		}
	else {
		return l;

	}
	}
	//all clients comments ajouter une exception 
	
	@GetMapping("/myComments/{publicationId}")
	@ResponseBody
	public List<Comment> myComments(@PathVariable("publicationId") Long publicationId) {
	List<Comment> l = commentService.myComments(publicationId, ClientController.CLIENTCONNECTED.getId());
	return l ;

	}

	@PutMapping("/modify-comment/{commentId}")
	@ResponseBody
	public Comment updateComment(@RequestBody String mot,@PathVariable("commentId") Long id) {
	return commentService.updateComment(id, mot);
	}


	@DeleteMapping("/delete-comment/{commentId}")
	@ResponseBody
	public void deleteComment(@PathVariable("commentId") long commentId) {
		commentService.deleteComment(commentId);
	}


	//evaluation publication
	
//	@GetMapping("/rate/{subjectId}")
//	@ResponseBody
//	public String Rate(@PathVariable("publicationId") Long publicationId) {
//		publicationService.addrate(rate1, publicationId);
//		
//	return " Le star a été ajouté avec succés " ;
//
//	    }  

	

	//comment evaluation
	@PostMapping("/evaluate/{commentId}")
	@ResponseBody
	public String addevaluation(@RequestBody EvaluationComment u,@PathVariable("commentId") Long commentId) {
		
		commentService.addEv(u, commentId);
	return "votre evaluation a été bien enregistrée " ;
	    }

		
		
	// commentaires les plus pertinents
		




	@GetMapping("/pertinentComments")
	@ResponseBody
	public List<Comment> mylist() {

		 
		return commentService.Bestcomments();

	}







}
