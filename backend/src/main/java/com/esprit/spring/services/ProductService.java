package com.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Product;
import com.esprit.spring.entites.StockDetail;
import com.esprit.spring.repository.ProductRepository;
import com.esprit.spring.repository.StockDetailRepository;

@Service
public class ProductService implements ProductServiceI {
@Autowired
ProductRepository productRepository;
@Autowired
StockDetailRepository stockRepo; 

	
	@Override
	public Product findbyid(int id) {

		return  productRepository.findById(id).get();
	}
	
	
	
	@Override
	public Product addProduct(Product p) {
		StockDetail s = new StockDetail();
		 
	  p.setStockdetail(stockRepo.save(s));
	
		
		return productRepository.save(p);
		
	}


    @Override
	public Iterable<Product> getAllProduct(){
		// TODO Auto-generated method stub
		
		Iterable<Product> I = productRepository.findAll();
		return I;
	}



	  



	@Override
	public void deleteProduct(int id) {
		// TODO Auto-generated method stub
		productRepository.deleteById(id);
		
	}



	@Override
	public Product updateProduct(Product p) {
		// TODO Auto-generated method stub
		return productRepository.save(p);
	}



	@Override
	public void deleteAllproduct() {
		// TODO Auto-generated method stub
		
		productRepository.deleteAll();
		
	}



	@Override
	public Product findByName(String name) {
		// TODO Auto-generated method stub
		
		
		
		return productRepository.findByName(name);
	}
	
	
	

}