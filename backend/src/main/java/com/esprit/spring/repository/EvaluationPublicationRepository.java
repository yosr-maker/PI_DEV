package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.EvaluationPublication;



@Repository
public interface EvaluationPublicationRepository extends CrudRepository<EvaluationPublication,Long> {
	
	
}