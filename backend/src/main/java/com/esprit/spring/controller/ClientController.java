package com.esprit.spring.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.config.JwtTokenUtil;
import com.esprit.spring.entites.Admin;
import com.esprit.spring.entites.Client;

import com.esprit.spring.model.JwtRequest;
import com.esprit.spring.model.JwtResponse;
import com.esprit.spring.services.ClientService;

@RestController
public class ClientController {


	
	@Autowired
	ClientService clientService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	public static Client CLIENTCONNECTED ;
	
	@GetMapping("/bonjour-client")
	@ResponseBody
	public String welcome() { return "Bonjour, Bienvenue à votre espace client "; }
	
//
	@PostMapping("/register-client")
	@ResponseBody
	public ResponseEntity<?> saveClient(@RequestBody Client client) throws Exception {
		System.out.println("Entring the register method ");
		return ResponseEntity.ok(clientService.addClient(client));
	}

	@PostMapping("/authenticate-client")
	@ResponseBody
	public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {
		try {
			//authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            System.err.println(authenticationRequest.getUsername()+"   " +authenticationRequest.getPassword());
			final UserDetails userDetails = clientService.loadClientByUsername(authenticationRequest.getUsername());
			//System.err.println("**********************"+userDetails.getUsername());
			final Client client = clientService.findClientByUsername(authenticationRequest.getUsername());
			//System.err.println("**********************"+userDetails.getUsername()+"******************************");
			CLIENTCONNECTED = client ;
			System.out.println(CLIENTCONNECTED.getRole());


			final String token = jwtTokenUtil.generateToken(userDetails);
			System.out.println(token);
			return ResponseEntity.ok(new JwtResponse(token));
		} catch (Exception e) {
			System.out.println(e.toString());
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}

	}
	
	
	
	
	
	
	
	@GetMapping("/retrieve_clients")
	@ResponseBody
	public List<Client> getClients() {
	List<Client> list = clientService.retrieveAllClients();
	return list;
	}
	
	@GetMapping("/retrieve-client/{clientId}")
	@ResponseBody
	public Client findbyid(@PathVariable("clientId") long clientId) {
	return clientService.retrieveClient(clientId);
	}
	
	
	@PutMapping("/modify-client")
	@ResponseBody
	public Client modifyClient(@RequestBody Client client) {
	return clientService.updateClient(client);
	}
    
    @DeleteMapping("/delete-client/{client-id}")
    @ResponseBody
    public void deleteClient(@PathVariable("client-id") long clientId) {
    	clientService.deleteClient(clientId);
    }
    
   
	
    

}
