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
		
	String max = rechercheService.extract(UserController.USERCONNECTED.getId()); // user controller je dois la changer a clientcontroller i think

	List<Publication> list = publicationService.findbyType(max);


	if (list.size()==0) {
		return Response.status(Status.NOT_FOUND).entity( "Do a little search ;) ").build();

	                   
	}
	else{
		return Response.status(Status.OK).entity(list).build();

		}
	}

	
	//enregistrer ma recherche et retourner les publication cherchées
	@GetMapping("/search/{type}")
	@ResponseBody
	public Response addSearch(@PathVariable("type") String type) {
		
		
		Recherche r = new Recherche(type);
		 
		 List<Publication> list = publicationService.findbyType(type);
		 
		 
		 
	    if (list.size()==0) {
	    	return Response.status(Status.NOT_FOUND).entity( "There is no publication with the type provided !").build();
	                       
	    }
	    else {
	    	
	rechercheService.addSearch(r, UserController.USERCONNECTED.getId());
	return Response.status(Status.OK).entity(list).build();
	    }
		 
		 
	}
	//////CRUD Publication//////
	///////list of all Publications///////////
	@GetMapping("/retrievepublications")
	@ResponseBody
	public List<Publication> myy() {
	List<Publication> l = publicationService.myy();
	return l ;
	}

	@PutMapping("/modify-publication")
	@ResponseBody
	public Publication updateUser(@RequestBody Publication p ) {
	return publicationService.updatePublication(p);
	}





	//pour ADMIN test publication  redondantes
	@PostMapping("/Publication")
	@ResponseBody
	public Response addSubject(@RequestBody Publication pu) {
	    Publication subexists = publicationService.test(pu.getType(), pu.getDescription());
	   
	    if (subexists != null) {
	    	return Response.status(Status.NOT_FOUND).entity( "There is already a Publication exists with these informations").build();
	                       
	    }
	    else {
	    	publicationService.addPublication(pu);
	    	 return Response.status(Status.OK).entity("add successful").build();
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
	public Response addComment(@RequestBody Comment u,@PathVariable("publicationId") Long publicationId) {
		
		commentService.addComment(u,UserController.USERCONNECTED.getId(),publicationId);
	return Response.status(Status.OK).entity("add successful").build();

	    }

	//all comments  ajouter une exception 
	@GetMapping("/ListComment/{publicationId}")
	@ResponseBody
	public Response list(@PathVariable("publicationId") Long publicationId) {
	List<Comment> l = commentService.list(publicationId);

	if (l.size()==0) {
		return Response.status(Status.NOT_FOUND).entity("There's no comment related to this publication !").build();

		}
	else {
		return Response.status(Status.OK).entity(l).build();

	}
	}
	//all userconnected comments ajouter une exception 
	
	@GetMapping("/myComments/{publicationId}")
	@ResponseBody
	public List<Comment> mylist(@PathVariable("publicationId") Long publicationId) {
	List<Comment> l = commentService.mylist(publicationId, UserController.USERCONNECTED.getId());
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


	///////////////////////subject evaluation//////////////////////
	/*
	@GetMapping("/rate/{subjectId}")
	@ResponseBody
	public Response Rate(@PathVariable("subjectId") Long subjectId) {
		subjectService.addrate(rate1, subjectId);
		
	return Response.status(Status.OK).entity("add successful").build();

	    }  

	*/

	//comment evaluation
	@PostMapping("/evaluate/{commentId}")
	@ResponseBody
	public Response addevaluation(@RequestBody EvaluationComment u,@PathVariable("commentId") Long commentId) {
		
		commentService.addEv(u, commentId);
	return Response.status(Status.OK).entity("add successful").build();

	    }

		
		
	// commentaires les plus pertinents
		




	@GetMapping("/pertinentComments")
	@ResponseBody
	public List<Comment> mylist() {

		
		return commentService.Bestcomments();

	}







}
