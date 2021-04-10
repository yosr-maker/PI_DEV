package com.esprit.spring.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Basket;
import com.esprit.spring.entites.Command_line;
import com.esprit.spring.entites.Product;
import com.esprit.spring.services.BasketService;

@RestController
@RequestMapping("/api")
public class BasketController {
	@Autowired
	BasketService basketService;
	
	//localhost:8092/api/add-basket
	/*"prixTotal":25.500, "isValid":true,"quantiteTotale":5*/
	@PostMapping(value = "/add-basket")
	@ResponseBody
	public Basket addBasket(@RequestBody Basket basket) {
		Basket bas = basketService.addBasket(basket);
		System.out.println("Basket add works properly");
	return bas;	
	}
	
	//localhost:8092/api/remove-basket/2
	@DeleteMapping("/remove-basket/{basket-id}")
	@ResponseBody
	public void removeBasket(@PathVariable("basket-id")Long basketId) {
		basketService.deleteBasket(basketId);
	}
	
	//localhost:8092/api/modify-basket
	/*"basketId": 3,"prixTotal":25.500, "isValid":false,"quantiteTotale":5*/
	@PutMapping("/modify-basket")
	@ResponseBody
	public Basket modifyBasket(@RequestBody Basket basket) {
	return basketService.updateBasket(basket);
	}
	
	//localhost:8092/api/retrieve-basket/4
	@GetMapping("/retrieve-basket/{basket-id}")
	@ResponseBody
	public Basket retrieveBasket(@PathVariable("basket-id") Long basketId) {
	return basketService.retrieveBasket(basketId);
	}
	
	//localhost:8092/api/retrieve-all-baskets
	@GetMapping("/retrieve-all-baskets")
	@ResponseBody
	public List<Basket> getBasket() {
	List<Basket> listb = basketService.retrieveAllBaskets();
	return listb;
	}
	
	@DeleteMapping("/vider-basket/{basketId}")
	@ResponseBody
	public void viderMaBasket(@PathVariable("basketId")Long basketId) {
		basketService.viderMaBasket(basketId);
		System.out.println("ma basket est vide ");
	}
	
	@GetMapping("/consilterList")
	@ResponseBody
	public Collection<Command_line> consulteListCl(){
		return  basketService.consulteListCl();
		
	}
	//NON
	@PostMapping("/addProductBasket/{idproduct}/{idcl}")
	
	public Command_line addProductBasket(@PathVariable("idproduct")Long idp ,@PathVariable("idcl")Long idcl) {
		return  basketService.addProductBasket(idp, idcl);
	}
	
	@PutMapping("/increProductBasket/product")
	@ResponseBody
	public String incrementProductBasket(@PathVariable("product") Product p , float quantity) {
		return  basketService.incrementProductBasket(p, quantity);
	
	}
	
	@PutMapping("/decreProductBasket/product")
	@ResponseBody
	public String decrementProductBasket(@PathVariable("product") Product p , float quantity) {
		return  basketService.decrementProductBasket(p, quantity);
	}
	
	@GetMapping("/sommeOfMyPurchases")
	@ResponseBody
	public float SumOfMyPurchases() {
		return basketService.SumOfMyPurchases();
	}
	//Non
	@GetMapping("/affecterBasketToClient/{idb}/{idc}")
	@ResponseBody
	public String affecterBasketToClient(@PathVariable("idb")Long idb, @PathVariable("idc")Long idc) {
		return "Affecter basket to client successfully";
		
	}

}
