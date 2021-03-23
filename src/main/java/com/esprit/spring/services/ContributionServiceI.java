package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;

public interface ContributionServiceI {

	public String Contribute(Long eid, float amount);
	public List<Contribution> contributionOfEvent(Event event);
	public List<Contribution> myContributionHistory();
}
