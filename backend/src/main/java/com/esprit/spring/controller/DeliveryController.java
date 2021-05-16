package com.esprit.spring.controller;

import java.util.List;

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

import com.esprit.spring.entites.Delivery;
import com.esprit.spring.services.DeliveryService;

@RestController
@RequestMapping("/api")
public class DeliveryController {
	@Autowired
	DeliveryService deliveryService ;

//localhost:8092/api/add-delivery
	/*"dateDelivery":"2020-15-13"*/
	@PostMapping(value = "/add-delivery")
	@ResponseBody
	public Delivery addDelivery(@RequestBody Delivery deli) {
		Delivery delivery = deliveryService.addDelivery(deli);
		System.out.println("delivery add works properly");
	return delivery ;	
	}
	
	
	//localhost:8092/api/remove-delivery/2
	@DeleteMapping("/remove-delivery/{delivery-id}")
	@ResponseBody
	public void removeDelivery(@PathVariable("delivery-id")Long deliveryId) {
		deliveryService.deleteDelivery(deliveryId);
	}
	
	//localhost:8092/api/modify-delivery
	@PutMapping("/modify-delivery")
	@ResponseBody
	public Delivery modifyDelivery(@RequestBody Delivery deli) {
	return deliveryService.updateDelivery(deli);
	}
	
	//localhost:8092/api/retrieve-delivery/3
	@GetMapping("/retrieve-delivery/{delivery-id}")
	@ResponseBody
	public Delivery retrieveDelivery(@PathVariable("delivery-id") Long deliveryId) {
	return deliveryService.retrieveDelivery(deliveryId);
	}
	
	//localhost:8092/api/retrieve-all-deliveries
	@GetMapping("/retrieve-all-deliveries")
	@ResponseBody
	public List<Delivery> getDelivery() {
	List<Delivery> list = deliveryService.retrieveAllDeliveries();
	return list;
	}
	
	@GetMapping ("/frais/{deliveryId}")
	public int getfrais (@PathVariable("deliveryId") Long deliveryId) {
	
	return deliveryService.livraisonfrais(deliveryId) ;
}
}
