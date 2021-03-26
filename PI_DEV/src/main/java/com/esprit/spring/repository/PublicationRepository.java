package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Publication;


@Repository
public interface PublicationRepository extends CrudRepository <Publication, Long>{
	
}