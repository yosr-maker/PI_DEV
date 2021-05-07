package com.esprit.spring.repository;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Product;

@Repository
public interface ProductRepository extends CrudRepository<Product,Long> {



}
