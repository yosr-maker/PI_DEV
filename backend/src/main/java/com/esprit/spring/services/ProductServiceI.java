package com.esprit.spring.services;

import com.esprit.spring.entites.Product;

public interface ProductServiceI {

	Product findbyid(long id);

	Product addProduct(Product p);

}
