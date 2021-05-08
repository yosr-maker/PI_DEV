package com.esprit.spring.services;

import com.esprit.spring.entites.Client;

public interface ClientServiceI  {




	Client addClient(Client c);
	Client findbyid(long id);
}
