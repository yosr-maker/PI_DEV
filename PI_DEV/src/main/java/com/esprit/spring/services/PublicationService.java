package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.spring.entites.EvaluationPublication;

import com.esprit.spring.entites.Publication;
import com.esprit.spring.repository.EvaluationPublicationRepository;
import com.esprit.spring.repository.ProductRepository;
import com.esprit.spring.repository.PublicationRepository;
import com.esprit.spring.services.PublicationServiceI;





@Service
public class PublicationService implements PublicationServiceI {


@Autowired
PublicationRepository publicationRepository;

@Autowired
ProductRepository productRepository;





@Autowired
private EvaluationPublicationRepository evaluationPublicationRepository;

private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(PublicationService.class);



//@Override
//public Publication addPublication(Publication publication,Long prod_id) {
//	
//	
//	
//	Product p = productRepository.findById(prod_id).get();
//	
//	
//	publication.setProduct(p);
//	
//	publicationRepository.save(publication);
//	return publication ;
//}


@Override
public Publication addPublication(Publication publication) {
	
	publicationRepository.save(publication);
	return publication ;
}

@Override
public Publication retrievePublicationByid(Long id){
	
		return publicationRepository.findById(id).get() ;
	}



@Override
public List<Publication> retrieveAllPublications() {
	List<Publication> publications = (List<Publication>) publicationRepository.findAll();
	for (Publication publication: publications ) {
		l.info("la liste des publications données +++: " + publication);
	}
	
	return publications;
}

@Override	
public void deletePublication(Long id){
	
	publicationRepository.deleteById(id); 
	
	}
@Override	
public Publication updatePublication(Publication publication2){
	
    Publication publication1 =publicationRepository.findById(publication2.getId()).get(); 
    publication1.setType(publication2.getType());
    publication1.setDescription(publication2.getDescription());
    publication1.setDate(publication2.getDate());
 
		
    publicationRepository.save(publication1);
		return publication1;
	
	}
@Override	
public Publication test(String type , String description){
	Publication u = publicationRepository.findByTypeAndDescription(type, description);
		return u;
}

@Override	
public List<String> pub(){
	Double mydate = (double) 3;
	return publicationRepository.pub(mydate);
	
	
}

@Override
public Publication retrievePublicationByTitle(String title){
	
	return publicationRepository.findByTitle(title);
	
}
@Override
public List<Publication> retrievePublicationByType(String type){
	
		return publicationRepository.findByType(type);
	}



@Override
public List<Long> publicationNonCommentes() {
	 List<Long> mylist = publicationRepository.list1() ; 
	 Double a = (double) 10;
	 List<Long> pubscom = publicationRepository.pubs(a);  
	for(Long i : mylist) {
		
		if(pubscom.contains(i)) {
			pubscom.remove(i);
			
		}
	}
	
 return pubscom ;
 
	  
}


	






@Override
public EvaluationPublication addEvaluation(EvaluationPublication eva,Long id) {
	
	Publication publication = publicationRepository.findById(id).get();
	EvaluationPublication evaluationpub = new EvaluationPublication();
	int nbr = eva.getNbr();
	evaluationpub.setNbr(nbr);
	evaluationpub.setPublication(publication);
	evaluationPublicationRepository.save(evaluationpub);
	return evaluationpub ;


}
}


		
		
		
		
	
	
	


