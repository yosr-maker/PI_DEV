package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Automobile;
import com.esprit.spring.services.AutomobileService;
 
@RestController
@RequestMapping("/api")
public class AutomobileController {

	@Autowired
	AutomobileService automobileService;
	
	//localhost:8092/api/add-automobile
	@PostMapping(value = "/add-automobile")
	@ResponseBody
	public Automobile addAutomobile(@RequestBody Automobile auto) {
		Automobile automobile = automobileService.addAutomobile(auto);
		System.out.println("automobile add works properly");
	return automobile;	
	}
	
	
	//localhost:8092/api/remove-automobile/2
	@DeleteMapping("/remove-automobile/{automobile-id}")
	@ResponseBody
	public void removeAutomobile(@PathVariable("automobile-id")Long automobileId) {
		automobileService.deleteAutomobile(automobileId);
	}
	
	//localhost:8092/api/modify-automobile
	@PutMapping("/modify-automobile")
	@ResponseBody
	public Automobile modifyAutomobile(@RequestBody Automobile auto) {
	return automobileService.updateAutomobile(auto);
	}
	
	//localhost:8092/api/retrieve-automobile/3
	@GetMapping("/retrieve-automobile/{automobile-id}")
	@ResponseBody
	public Automobile retrieveAutomobile(@PathVariable("automobile-id") Long automobileId) {
	return automobileService.retrieveAutomobile(automobileId);
	}
	
	//localhost:8092/api/retrieve-all-automobile
	@GetMapping("/retrieve-all-automobile")
	@ResponseBody
	public List<Automobile> getAutomobile() {
	List<Automobile> list = automobileService.retrieveAllAutomobiles();
	return list;
	}
	
	
}
