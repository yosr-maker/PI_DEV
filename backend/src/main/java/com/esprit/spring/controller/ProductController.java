package com.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.spring.entites.Product;
import com.esprit.spring.services.ProductService;
@RestController
public class ProductController {
@Autowired
ProductService productService;
	
	@PostMapping("/add-product")
	@ResponseBody
	public Product addProduct(@RequestBody Product p) {
		Product product= productService.addProduct(p);
	return product;
	}

}
