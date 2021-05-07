package com.esprit.spring.services;

import java.util.ArrayList;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Donation;

import com.esprit.spring.repository.*;




@Service
public class DonationService implements DonationServiceI{
		@Autowired
		DonationRepository DonationRepository;
		@Autowired
		ClientRepository ClientRepository;
		@Autowired
		EventRepository eventReposiotry;
		
		
		private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(DonationService.class);



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

@Override
public Donation findbyId(Long idDo) {
	return DonationRepository.findById(idDo).get();
}


@Override
public Map<Long, Integer> bestClientsByDonation() {
	
	Map<Long,Integer> h = new HashMap<>();
	List<Long> listId = new ArrayList<>();
	List<Integer> listdonations= new ArrayList<>();
	List<Client> listClient = (List<Client>) ClientRepository.findAll();
	
	for (Client c: listClient) {
		listId.add((long) c.getId());
		listdonations.add(c.getDonation());
	}
	
	List<Integer> sortedList = new ArrayList<>(listdonations);
	Collections.sort(sortedList);
	
	for (int i=0; i<3; i++) {
		int max = sortedList.get(sortedList.size()-1);// retourne le max qui a la dernière position de la liste
		Long ind = listId.get(listdonations.indexOf(max));// prend nbre de dons et retourne id de client corresspondant
		h.put(ind, max);
		System.out.println(ind +" "+ max);
		sortedList.remove(sortedList.size()-1);
		listdonations.set(listdonations.indexOf(max), -1);
	}
	
	return h;
}

}

