package com.esprit.spring.services;

import com.esprit.spring.entites.Recherche;

public interface RechercheServiceI {

	String extract(Long id_client);

	Recherche addSearch(Recherche rech, Long client_id);


}
