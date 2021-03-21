package com.esprit.spring.services;

import java.util.List;


import com.esprit.spring.entites.Publication;

public interface PublicationServiceI {
 
	List<Publication> retrieveAllPublications();
	Publication addPublication(Publication p);
	void deletePublication (String id);
	Publication updatePublication(Publication p);
	Publication retrievePublication(String id);
}




