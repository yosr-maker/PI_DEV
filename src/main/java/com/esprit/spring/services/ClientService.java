package com.esprit.spring.services;

import com.esprit.spring.entites.Client;
import com.esprit.spring.repository.ClientRepository;

public class ClientService implements ClientServiceI {

	
	public Client findbyid(long id) {

		return ClientRepository.findById(id).get();
	}
}
