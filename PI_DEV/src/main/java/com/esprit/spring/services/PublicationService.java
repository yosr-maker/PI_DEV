package com.esprit.spring.services;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.EvaluationPublication;
import com.esprit.spring.entites.Publication;
import com.esprit.spring.repository.CommentRepository;
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
//	
//
//
//	@Override
//	public Publication addPublication(Publication p) {
//		publicationRepository.save(p);
//		return null;
//	}
//
//	@Override
//	public void deletePublication(String id) {
//		publicationRepository.deleteById(Long.parseLong(id));
//		
//	}
//
//	
//
//	@Override
//	public Publication retrievePublication(String id) {
//		Publication publication = publicationRepository.findById(Long.parseLong(id)).orElse(null);
//		return publication;
//	}
//
//	@Override
//	public Publication updatePublication(Publication p) {
//		 publicationRepository.save(p);
//		return null;
//	}
//
//}




@Service
public class PublicationService implements PublicationServiceI {


@Autowired
private PublicationRepository var;

@Autowired
private CommentRepository var1;

@Autowired
private EvaluationPublicationRepository var2;





@Override	
public Publication addPublication(Publication publication){
		var.save(publication) ;
		return publication;
		
	}

@Override
public Publication findbyid(long id){
	
		return var.findById(id).get() ;
	}

@Override
public List<Publication> myy(){
	
	
	
	return (List<Publication>)var.findAll();
	
	
		
	}

@Override	
public void deletePublication(long id){
	
		var.deleteById(id); 
	
	}
@Override	
public Publication updatePublication(Publication publication2){
	
    Publication publication1 =var.findById(publication2.getId()).get(); 
    publication1.setType(publication2.getType());
    publication1.setDescription(publication2.getDescription());
    publication1.setDate(publication2.getDate());
		
		var.save(publication1);
		return publication1;
	
	}
@Override	
public Publication test(String type , String description){
	Publication u = var.findByTypeAndDescription(type, description);
		return u;
}

@Override	
public List<String> pub(){
	Double mydate = (double) 3;
	return var.pub(mydate);
	
	
}

@Override
public Publication listbytitle(String title){
	
	return var.findByTitle(title);
	
}
@Override
public List<Publication> findbyType(String type){
	
		return var.findByType(type);
	}


/////////subject sans interaction//////////

@Override
public List<Long> notcommented() {
	 List<Long> mylist = var.list1() ; //1
	 Double a = (double) 10;
	 List<Long> mylist1 = var.pubs(a);  //1 2 3
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
		
		var.deleteById(i);
		
	}
	
	
}
/////////////////////subject rating /////////////////////
public EvaluationPublication addrate(int value,Long id) {
	
	Publication p = var.findById(id).get();
	EvaluationPublication e = new EvaluationPublication();
	e.setValue(value);
	e.setPublication(p);
	var2.save(e);
	return e ;
	
	
}
	
		
}
	

		
		
		
		
	
	
	


