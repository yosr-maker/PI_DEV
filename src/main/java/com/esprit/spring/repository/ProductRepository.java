package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	
	public List<Product> findTopByOrderByNbrcommanlineDesc();

}
