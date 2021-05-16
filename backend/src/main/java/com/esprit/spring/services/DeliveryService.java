package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Delivery;

public interface DeliveryService {
	List<Delivery> retrieveAllDeliveries();
	Delivery addDelivery( Delivery deli);
	void deleteDelivery (Long deliveryId);		
	Delivery updateDelivery(Delivery deli);
	Delivery retrieveDelivery(Long deliveryId);
	int livraisonfrais(Long deliveryId);
	
}
