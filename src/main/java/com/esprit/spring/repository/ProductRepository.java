package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.spring.entites.Product;

public interface ProductRepository  extends JpaRepository<Product, Long>{

}
