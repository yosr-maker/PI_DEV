package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Client;



public interface ClientServiceI {
	List<Client> retrieveAllClients();
	Client addClient(Client c);
	void deleteClient (String id);
	Client updateClient(Client c);
	Client retrieveClient(String id);
	


}
