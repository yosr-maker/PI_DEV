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
			 @Query("select title from Publication p where CURRENT_DATE - p.date <=:mydate")
			 public List<String> pub(@Param("mydate") Double mydate);
			 Publication findByTitle(String title);
			 
			 List<Publication> findByType(String type);
			
			 /////////supp auto Publication//////////
			 @Query("select p.id from Publication p where CURRENT_DATE - p.date >=:mydate ")
			 public List<Long> pubs(@Param("mydate") Double mydate);
			 
			//list of id_publication in class comment
			 @Query("select p.id from Publication p join p.comments c where c.publication=p")
			 public List<Long> list1();
}
