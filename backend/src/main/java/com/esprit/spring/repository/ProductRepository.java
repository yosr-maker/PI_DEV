package com.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Integer> {

 
	
	@Query("SELECT p FROM Product p WHERE p.name=:name")
	Product findByName(@Param ("name") String name);

	@Query("SELECT p FROM Product p WHERE p.category=:category")
	List<Product> filterByCategory(@Param ("category") String category);
}
