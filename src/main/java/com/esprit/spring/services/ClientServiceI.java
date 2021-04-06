package com.esprit.spring.services;

import com.esprit.spring.entites.Client;

public interface ClientServiceI  {

	  Client findOne(long id);


	Client addClient(Client c);
	Client findbyid(long id);
}
