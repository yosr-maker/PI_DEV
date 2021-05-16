package com.esprit.spring.services;

import java.util.List;


import com.esprit.spring.entites.Automobile;

public interface AutomobileService {

	List<Automobile> retrieveAllAutomobiles();
	Automobile addAutomobile(Automobile auto);
	void deleteAutomobile (Long idAuto);		
	Automobile updateAutomobile(Automobile auto);
	Automobile retrieveAutomobile(Long idAuto);
	public void affecterAutoToDriver(Long idAuto,Long idDriver);
}
