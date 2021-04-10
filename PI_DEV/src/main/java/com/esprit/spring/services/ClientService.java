package com.esprit.spring.services;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import com.esprit.spring.entites.Client;

import com.esprit.spring.repository.ClientRepository;


@Service

public class ClientService  implements ClientServiceI{
	@Autowired
	private ClientRepository clientRepository;
	
	@Autowired
	private PasswordEncoder bcryptEncoder;
	

        @Override
	    public Client addClient(Client client) {
	    Client newclient = new Client();
		newclient.setUsername(client.getUsername());
		newclient.setPassword(bcryptEncoder.encode(client.getPassword()));
		newclient.setFirstName(client.getFirstName());
		newclient.setLastName(client.getLastName());
		newclient.setEmail(client.getEmail());
		newclient.setCin(client.getCin());
		newclient.setPhoneNumber(client.getPhoneNumber());
		newclient.setRole(client.getRole());
		return clientRepository.save(newclient);
	}
        @Override
	public Client findClientByUsername(String username) {
		return clientRepository.findByUsername(username);
	}
	
	
	@Override
	public UserDetails loadClientByUsername(String username) throws UsernameNotFoundException {
		Client client = clientRepository.findByUsername(username);
		if (client == null) {
			throw new UsernameNotFoundException("Client not found with username: " + username);
		}
		return new org.springframework.security.core.userdetails.User(client.getUsername(), client.getPassword(),
				new ArrayList<>());
	}

	@Override
	public Client retrieveClient(long id) {

		return clientRepository.findById(id).get();
	}

	@Override
	public List<Client> retrieveAllClients() {

		return (List<Client>) clientRepository.findAll();
	}
	@Override
	public void deleteClient(long id) {

		clientRepository.deleteById(id);

	}
	@Override
	public Client authenticate(String username, String email) {
		Client c  = clientRepository.findByUsernameAndEmail(username, email);
		return c;
	}


	@Override
	public Client updateClient(Client c) {
		clientRepository.save(c);
		return c;
	}
	
}





