package com.esprit.spring.services;



import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.esprit.spring.entites.Client;





public interface ClientServiceI {
	
	UserDetails loadClientByUsername(String username) throws UsernameNotFoundException;

	Client addClient(Client client);

	Client retrieveClient(long id);

	List<Client> retrieveAllClients();

	void deleteClient(long id);

	Client authenticate(String username, String email);

	Client findClientByUsername(String username);

	Client updateClient(Client c);
	


}
