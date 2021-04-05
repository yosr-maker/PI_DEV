package com.esprit.spring.services;



import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;





public interface ClientServiceI {
//	List<Client> retrieveAllClients();
//	Client addClient(Client c);
//	void deleteClient (String id);
//	Client updateClient(Client c);
//	Client retrieveClient(String id);
	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	


}
