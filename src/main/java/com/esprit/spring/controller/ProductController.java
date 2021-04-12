package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Claim;
import com.esprit.spring.entites.Product;
import com.esprit.spring.repository.ProductRepository;
import com.esprit.spring.services.IProductService;

@RestController(value="/")
public class ProductController {
	
	
	
	@Autowired
	IProductService iProductService ;

	@Autowired
	ProductRepository productRepository;
	
	
	
	
	
	@PostMapping(value="/add-product",produces=MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Product addProduits(@RequestBody Product prod)
	{
		
		
		return iProductService.addProduct(prod);
	}
	
	
	
	
	@GetMapping("/getAll-product")
	@ResponseBody
	public Iterable<Product> GetProduits()
	{
		Iterable<Product> I = iProductService.getAllProduct();
		
		return  I;
			
	}
	
	
	
	
	@GetMapping("/getProductByStockId/{id}")
	@ResponseBody
	public Iterable<Product> getProductByStockId(@PathVariable int id)
	{
		//Iterable<Product> I = productRepository.findProductByStockId(id);
		
		return  null;
			
	}
	
	
	@DeleteMapping("/delete-product/{idProd}")
	@ResponseBody
	public void deleteProduct(@PathVariable int idProd){
		
		
		iProductService.deleteProductBYId(idProd);
		
	}
	
	@GetMapping("/getProductById/{id}")
	@ResponseBody
	public Product  getProductById(@PathVariable int id){
	
		Product c = iProductService.getProductById(id);
		
		return c;
			
	}
	
	
	@PostMapping(value="/update-product")
	@ResponseBody
	public void updateProduits(@RequestBody Product prod)
	{
		
		
		iProductService.updateProduct(prod);
	}

	@GetMapping(value="/topProductCommand")
	@ResponseBody
	 public List<Product> topProductCommand(){
		 
		List<Product> topCommandProduct =  iProductService.ProductMoreCommandLine();
		
		return topCommandProduct;
	 }
}
