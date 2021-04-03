package com.esprit.spring.services;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.esprit.spring.entites.Product;

public interface IProductService {
	
	
public Product addProduct(Product product);
public Iterable<Product> getAllProduct();
public void deleteProductBYId(int id);

public Product getProductById(int id);

public  void updateProduct(Product prod);

	
	
}
