package com.esprit.spring.services;

import com.esprit.spring.entites.Client;

public interface ClientServiceI  {
	 Client findbyid(int id);
	  Client findOne(long id);
	Client findbyid(Long s);
	Client findbyid(Client u);
	Client findbyid(Object object);
	Client addClient(Client c);
}
