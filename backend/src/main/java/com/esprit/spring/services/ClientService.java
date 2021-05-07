package com.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.spring.entites.Client;
import com.esprit.spring.repository.ClientRepository;



@Service
public class ClientService implements ClientServiceI {
@Autowired
ClientRepository clientRepository;


	
	
	@Override
	public Client findbyid(long id) {

		return  clientRepository.findById( id).get();
	}
	
	
	
	@Override
	public Client addClient(Client c) {
		return clientRepository.save(c);
		
	}
	
	
	
}


