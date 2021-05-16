package com.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.spring.entites.Product;
import com.esprit.spring.entites.StockDetail;
import com.esprit.spring.services.ProductService;
import com.esprit.spring.services.StockDetailInter;

@RestController
public class ProductController {
	@Autowired
	ProductService productService;

	@Autowired
	StockDetailInter stockdetail;

	@PostMapping("add-product")
	@ResponseBody
	public Product addProduct(@RequestBody Product p) {
		Product product = productService.addProduct(p);
		p.getStockdetail().setProduct(p);
		stockdetail.addStockDetail(p.getStockdetail());
		return product;
	}

	@GetMapping("/getallprod")
	@ResponseBody
	public Iterable<Product> getallproduct() {

		return productService.getAllProduct();
	}

	@PutMapping("updateproduct")
	@ResponseBody
	public Product updateProduct(@RequestBody Product p) {
		return productService.updateProduct(p);
	}

	@DeleteMapping("deleteproduct/{id}")
	@ResponseBody
	public void deleteproduct(@PathVariable("id") int id) {
		productService.deleteProduct(id);

	}

	@DeleteMapping("deleteproducts")
	@ResponseBody
	public void deleteproductall() {
		productService.deleteAllproduct();
	}

	@GetMapping("findproductById/{id}")
	@ResponseBody
	public Product findproductById(@PathVariable("id") int id) {
		return productService.findbyid(id);
	}

	@GetMapping("findproductByName/{name}")
	@ResponseBody
	public Product findproductByName(@PathVariable("name") String name) {
		return productService.findByName(name);
	}

}
