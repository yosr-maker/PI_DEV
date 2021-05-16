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
	
	@Override
	public int livraisonfrais(Long deliveryId) {
		// TODO Auto-generated method stub
		float dl ,da ; 
		
		 int frais=8;
		 Delivery deli = deliveryRepository.findById(deliveryId).get() ; 
		 dl=deli.getLongitude()-36;//tunis = 36
		 da=deli.getLaltitude()-10;//tunis = 10
		
		 if (deli.getWeight()>50) {
			 frais = frais+4 ;
		 }
		 
		 if((deli.getWidth()>1500)||(deli.getLenght()>1500)) 
			 frais=frais+4;
		
		 if((dl>1)&&(da>1)) //si distance > tunis et bizerte 
				frais=frais+4; 
			 
		 return frais;
}
}
