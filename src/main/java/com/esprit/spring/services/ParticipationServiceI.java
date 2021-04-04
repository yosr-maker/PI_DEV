package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Participation;

public interface ParticipationServiceI {

	String addParticipation(Long eid);

	List<Participation> myParticipations();

	List<Participation> participationsList();

}
