package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Donation;

public interface DonationServiceI {

	
	

	List<Donation> retrieveAllDonations();
	Donation addDonation(Donation d);
	void deleteDonation (String id);
	Donation updateDonation(Donation d);
	Donation retrieveDonation(String id);
	

}


