package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.esprit.spring.entites.Client;

import com.esprit.spring.repository.ClientRepository;

@Service

public class ClientService  implements ClientServiceI{
	@Autowired
	ClientRepository clientRepository;
	
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(AdminService.class);


@Override
public Client addClient(Client c) {
	 return clientRepository.save(c);
	
}

@Override
public void deleteClient(String id) {
	clientRepository.deleteById(Long.parseLong(id));
	
}


@Override
public Client updateClient(Client c ) {
	return clientRepository.save(c);
	
}

@Override
public Client retrieveClient(String id) {
	Client c  =clientRepository.findById(Long.parseLong(id)).orElse(null);
		return c ;
}
@Override
public List<Client> retrieveAllClients() {
	List<Client> clients = (List<Client>) clientRepository.findAll();
	for (Client client: clients){
		l.info("les clients  +++ :" + client);
	}
		
return clients;	
}

}





