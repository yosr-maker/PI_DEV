package com.esprit.spring.services;

import java.util.List;



public interface ParticipationServiceI {





	List<String> participationsList(int idEvent);




	String addParticipation(Long eid, Long clientId);

}
