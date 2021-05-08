package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;

public interface ContributionServiceI {

	
	public List<Contribution> contributionOfEvent(Event event);

	String Contribute(Long eid, Long clientId, float amount);

	List<Contribution> myContributionHistory(Client client);
	

}
	
