package com.esprit.spring.services;

import java.util.List;
import java.util.Map;

import com.esprit.spring.entites.Donation;

public interface DonationServiceI {

	List<Donation> retrieveAllDonations();
	Donation addDonation(Donation d);
	void deleteDonation (String id);
	Donation updateDonation(Donation d);
	Donation retrieveDonation(String id);
	Donation findbyId(Long idDo);
	Map<Long, Integer> bestClientsByDonation();

}


