package com.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Product;
import com.esprit.spring.repository.ProductRepository;

@Service
public class ProductService implements ProductServiceI {
@Autowired
ProductRepository productRepository;
	
	@Override
	public Product findbyid(long id) {

		return  productRepository.findById( id).get();
	}
	
	
	
	@Override
	public Product addProduct(Product p) {
		return productRepository.save(p);
		
	}
	
}
