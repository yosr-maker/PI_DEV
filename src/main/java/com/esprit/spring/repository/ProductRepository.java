package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {
	
	
	/*@Query(value = "SELECT new com.esprit.spring.entites.Product  MAX ( nbr_commanline ) FROM Product")
	public List<Product> getProductMaxCommandLine();

	// List<Product> findProductByStockId(int id);*/

}
