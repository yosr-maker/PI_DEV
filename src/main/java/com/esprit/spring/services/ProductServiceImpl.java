package com.esprit.spring.services;





import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.Email.IEmailService;
import com.esprit.spring.entites.Claim;
import com.esprit.spring.entites.Command_line;
import com.esprit.spring.entites.Product;
import com.esprit.spring.entites.StockDetail;
import com.esprit.spring.repository.ProductRepository;
import com.esprit.spring.repository.StockDetailRepository;


@Service
public class ProductServiceImpl  implements   IProductService{
	
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired(required =true)
	IEmailService emailService;
	
	@Autowired
	StockDetailRepository stockDetailRepository;
	
	
	
	
	

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		
	  
		return productRepository.save(product);
	}

	@Override
	public Iterable <Product> getAllProduct() {
		// TODO Auto-generated method stub
		Iterable <Product> p = productRepository.findAll();
		
		return p ;
	}

	@Override
	public void deleteProductBYId(int id) {
		// TODO Auto-generated method stub
		
		
		productRepository.deleteById(id);
	}

	@Override
	public Product getProductById(int id) {
		// TODO Auto-generated method stub
		 Product c  =productRepository.findById(id).orElse(null);
		 
			return c;
		
		
	}

	@Override
	public void updateProduct(Product prod) {
		// TODO Auto-generated method stub
		
		productRepository.save(prod);
	}
	
	
	
	@Override
	public void deleteAllProduct() {
		// TODO Auto-generated method stub
		
		productRepository.deleteAll();
		
	}
    
	
	@Transactional
	@Override
	public Product affectationStockDtailDansProduit(int idStockDetail, int idProduct) {
		// TODO Auto-generated method stub
		 Product prod = productRepository.findById(idProduct).get();
		 StockDetail stcd = stockDetailRepository.findById(idStockDetail).get();
		 
		 if(prod.getStockDetail() ==null){
			 
			 prod.setStockDetail(stcd);
			 return productRepository.save(prod) ;
		 }
		
		 else 
			 return stcd.getProduct();
	}

	@Override
	public List<Product> getProductMaxCommandLine() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> ProductMoreCommandLine() {
		// TODO Auto-generated method stub
		
		List<Product> listTopProductCommand = productRepository.findTopByOrderByNbrcommanlineDesc();
		return listTopProductCommand ;
	}


	
	
	
	
	
	
	
	

}
