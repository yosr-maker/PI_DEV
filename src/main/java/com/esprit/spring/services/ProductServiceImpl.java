package com.esprit.spring.services;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.Email.IEmailService;
import com.esprit.spring.entites.Claim;
import com.esprit.spring.entites.Product;
import com.esprit.spring.repository.ProductRepository;


@Service
public class ProductServiceImpl  implements   IProductService{
	
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired(required =true)
	IEmailService emailService;

	@Override
	public Product addProduct(Product product) {
		// TODO Auto-generated method stub
		
		String t = "yosr.hamrouni@esprit.tn";
		String sub = "bonjour";
		String b = "ca marche !!!!!!!!!!!!!!!!!!!!!!!!!!!";
		
		emailService.sendMail(t, sub, b);
		
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
	
	
	
	
	
	
	

}
