package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.StockDetail;

@Repository
public interface StockDetailRepository extends CrudRepository<StockDetail, Integer>{
	
	
	
	
	

}
