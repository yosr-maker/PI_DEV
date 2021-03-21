package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.spring.entites.Publication;



public interface PublicationRepository extends CrudRepository <Publication, Long>{
	
}