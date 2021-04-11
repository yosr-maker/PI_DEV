package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Delivery;
import com.esprit.spring.repository.DeliveryRepository;
@Service
public class DeliveryServiceImpl implements  DeliveryService{
	@Autowired
	DeliveryRepository deliveryRepository ;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(DeliveryService.class);



	@Override
	public List<Delivery> retrieveAllDeliveries() {
		List<Delivery> Deliveries= (List<Delivery>) deliveryRepository.findAll();
		for(Delivery delivery:Deliveries) {
			l.info("auto :" + delivery);
		}
		return Deliveries;
	}

	@Override
	public Delivery addDelivery(Delivery deli) {
		return deliveryRepository.save(deli);

	}

	@Override
	public void deleteDelivery(Long deliveryId) {
		deliveryRepository.deleteById(deliveryId);		
	}

	@Override
	public Delivery updateDelivery(Delivery deli) {
		return deliveryRepository.save(deli);
	}

	@Override
	public Delivery retrieveDelivery(Long deliveryId) {
		Delivery deli= deliveryRepository.findById(deliveryId).get();
		return deli;
	}

}
