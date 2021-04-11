package com.esprit.spring.services;

import com.esprit.spring.entites.Recherche;

public interface RechercheServiceI {

	String extract(Long idClient);
	Recherche addSearch(Recherche recherche,Long idClient);
}
