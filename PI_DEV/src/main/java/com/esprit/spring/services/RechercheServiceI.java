package com.esprit.spring.services;

import com.esprit.spring.entites.Recherche;

public interface RechercheServiceI {

	Recherche addSearch(Recherche rech,int i);
	//Integer extract();
	//Long id_client
	String extract(int i) ;
	String extract(Long id_client);
	Recherche addSearch(Recherche rech, Long id_client);


}
