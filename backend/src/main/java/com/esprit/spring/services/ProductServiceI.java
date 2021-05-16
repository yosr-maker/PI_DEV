package com.esprit.spring.services;

import com.esprit.spring.entites.Product;

public interface ProductServiceI {

	public Product findbyid(int id);

	public Product addProduct(Product p);
 public Iterable <Product> getAllProduct();
 public void deleteProduct(int id);
 public Product updateProduct(Product p);
 public void deleteAllproduct();
public  Product findByName(String name);
}
