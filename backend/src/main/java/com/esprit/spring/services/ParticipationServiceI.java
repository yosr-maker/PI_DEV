package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Participation;



public interface ParticipationServiceI {





	public List<Participation> participationsList(int idEvent);
	
	public List<Participation> clientParticipationsList(int clientId); 
	
	public List<Contribution> clientContributionList(int clientId); 




	String addParticipation(Long eid, Long clientId);

}
