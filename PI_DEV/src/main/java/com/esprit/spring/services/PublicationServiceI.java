package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.EvaluationPublication;
import com.esprit.spring.entites.Publication;





public interface PublicationServiceI {
	 List<Publication> retrieveALLpublication();
	 Publication addPublication(Publication publication);
	 Publication findbyid(Long id);
	 void deletePublication(Long id) ;
	 Publication updatePublication(Publication publication2);
	 Publication test(String type , String description);
	 List<String> pub();

	  Publication listbytitle(String title);
	  List<Publication> findbyType(String type);
	  List<Long> notcommented() ;
	  void autodeletePublication() ;
	   EvaluationPublication addrate(int value,Long id);
	//List<Publication> retrieveAllPublications();
	List<Publication> retrieveAllPublications();
	   
	   
	
	
	
	  

	  
}

