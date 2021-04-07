package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.EvaluationPublication;
import com.esprit.spring.entites.Publication;
import com.esprit.spring.repository.EvaluationPublicationRepository;
import com.esprit.spring.repository.PublicationRepository;
import com.esprit.spring.services.PublicationServiceI;




//	@Override
//	public List<Publication> retrieveAllPublications() {
//		List<Publication> publications = (List<Publication>) publicationRepository.findAll();
//		for (Publication publication: publications ) {
//			l.info("la liste des publications données +++: " + publication);
//		}
//		
//		return publications;
//	}
//	
//	
////	
////
////
////	@Override
////	public Publication addPublication(Publication p) {
////		publicationRepository.save(p);
////		return null;
////	}
////
////	@Override
////	public void deletePublication(String id) {
////		publicationRepository.deleteById(Long.parseLong(id));
////		
////	}
////
////	
////
////	@Override
////	public Publication retrievePublication(String id) {
////		Publication publication = publicationRepository.findById(Long.parseLong(id)).orElse(null);
////		return publication;
////	}
////
////	@Override
////	public Publication updatePublication(Publication p) {
////		 publicationRepository.save(p);
////		return null;
////	}
////
////}




@Service
public class PublicationService implements PublicationServiceI {


@Autowired
private PublicationRepository publicationRepository;



@Autowired
private EvaluationPublicationRepository evaluationPublicationRepository;

private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(PublicationService.class);



@Override	
public Publication addPublication(Publication publication){
	publicationRepository.save(publication) ;
		return publication;
		
	}

@Override
public Publication findbyid(Long id){
	
		return publicationRepository.findById(id).get() ;
	}

//@Override
//public List<Publication> retrieveALLpublication(){
//	
//	
//	
//	return (List<Publication>) publicationRepository.findAll();
//	
//	
//		
//	}

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
  //  publication1.setIdProduct(publication2.getIdProduct());
		
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
public Publication listbytitle(String title){
	
	return publicationRepository.findByTitle(title);
	
}
@Override
public List<Publication> findbyType(String type){
	
		return publicationRepository.findByType(type);
	}

// publication non commentées

@Override
public List<Long> notcommented() {
	 List<Long> mylist = publicationRepository.list1() ; //1
	 Double a = (double) 10;
	 List<Long> mylist1 = publicationRepository.pubs(a);  //1 2 3
	for(Long i : mylist) {
		
		if(mylist1.contains(i)) {
			mylist1.remove(i);
			
		}
	}
	
 return mylist1 ;
 
	  
}

/////////////supp auto sub sans interaction///////////
//@Scheduled(cron = "* * * * * ?")
@Override
 public void autodeletePublication() {
	
	for(Long i : notcommented()) {
		
		publicationRepository.deleteById(i);
		
	}
	
	
}
/////////////////////subject rating /////////////////////
public EvaluationPublication addrate(int value,Long id) {
	
	Publication p = publicationRepository.findById(id).get();
	EvaluationPublication e = new EvaluationPublication();
	e.setValue(value);
	e.setPublication(p);
	evaluationPublicationRepository.save(e);
	return e ;
	
	
}

@Override
public List<Publication> retrieveALLpublication() {
	// TODO Auto-generated method stub
	return null;
}



}
	

		
		
		
		
	
	
	


