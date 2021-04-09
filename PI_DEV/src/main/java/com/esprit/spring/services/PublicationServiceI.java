package com.esprit.spring.services;

import java.util.List;


import com.esprit.spring.entites.Publication;





public interface PublicationServiceI {

	Publication addPublication(Publication publication);

	List<Publication> retrieveAllPublications();

	void deletePublication(Long id);

	Publication updatePublication(Publication publication2);

	Publication test(String type, String description);

	List<String> pub();

	Publication retrievePublicationByid(Long id);

	Publication retrievePublicationByTitle(String title);

	List<Publication> retrievePublicationByType(String type);

	List<Long> publicationNonCommentes();
	   
	   
	
	
	
	  

	  
}

