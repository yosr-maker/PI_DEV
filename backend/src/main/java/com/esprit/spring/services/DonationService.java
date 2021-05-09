package com.esprit.spring.services;



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Donation;
import com.esprit.spring.repository.*;


@Service
public class DonationService implements DonationServiceI{
		@Autowired
		DonationRepository DonationRepository;
		private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ClaimService.class);





@Override
public List<Donation> retrieveAllDonations() {
	List<Donation>donations= (List<Donation>) DonationRepository.findAll();
	for (Donation donation: donations){
		l.info("la liste des produits donnés   +++ :" + donation);
	}
		
return donations;	
}

@Override
public Donation addDonation(Donation d) {
	 DonationRepository.save(d);
	 return null ; 
}

@Override
public void deleteDonation(String id) {
	DonationRepository.deleteById(Long.parseLong(id));
	
}

@Override
public Donation updateDonation(Donation d) {
	 DonationRepository.save(d);
	 return null ; 
}

@Override
public Donation retrieveDonation(String id) {
	Donation d  =DonationRepository.findById(Long.parseLong(id)).orElse(null);
	return d;
}

}