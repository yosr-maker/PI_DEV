package com.esprit.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Client;
import com.esprit.spring.services.ClientService;

@RestController
public class ClientController {
@Autowired
ClientService ClientService;

	@PostMapping("/add-client")
	@ResponseBody
	public Client addClient(@RequestBody Client c) {
	Client client= ClientService.addClient(c);
	return client;
	}






}
