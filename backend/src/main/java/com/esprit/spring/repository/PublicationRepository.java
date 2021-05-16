package com.esprit.spring.repository;

import java.util.List;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Publication;



@Repository
public interface PublicationRepository extends CrudRepository <Publication, Long>{

	     Publication findByTypeAndDescription(String type,String description);
		 @Query("select description from Publication p where CURRENT_DATE - p.date <=:nbPub")
		 public List<String> pub(@Param("nbPub") double nbPub);
		 Publication findByTitle(String title);
		 
		 List<Publication> findByType(String type);
		
		 
		 @Query("select p.id from Publication p where CURRENT_DATE - p.date >=:nbPub ")
		 public List<Long> pubs(@Param("nbPub") double nbPub);
		 
		
		 @Query("select p.id from Publication p join p.comments c where c.publication=p")
		 public List<Long> list1();
		 
		 
		 
	
}