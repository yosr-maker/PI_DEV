package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Publication;
import com.esprit.spring.repository.PublicationRepository;

@Service
public class PublicationService implements PublicationServiceI {
	
	@Autowired
	PublicationRepository publicationRepository;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(CommentService.class);

	@Override
	public List<Publication> retrieveAllPublications() {
		List<Publication> publications = (List<Publication>) publicationRepository.findAll();
		for (Publication publication: publications ) {
			l.info("la liste des publications données +++: " + publication);
		}
		
		return publications;
	}
	
	
	


	@Override
	public Publication addPublication(Publication p) {
		publicationRepository.save(p);
		return null;
	}

	@Override
	public void deletePublication(String id) {
		publicationRepository.deleteById(Long.parseLong(id));
		
	}

	

	@Override
	public Publication retrievePublication(String id) {
		Publication publication = publicationRepository.findById(Long.parseLong(id)).orElse(null);
		return publication;
	}

	@Override
	public Publication updatePublication(Publication p) {
		 publicationRepository.save(p);
		return null;
	}

}
