package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.esprit.spring.entites.Jackpot;

import com.esprit.spring.services.JackpotServiceI;

@RestController
public class JackpotController {
	

@Autowired
JackpotServiceI JackpotService;

@GetMapping("/retrieve-all-Jackpots")
@ResponseBody
public List<Jackpot> getJackpots() {
List<Jackpot> list =JackpotService.retrieveAllJackpots();
return list;
}

@GetMapping("/retrieve-jackpot/{jackpot-id}")
@ResponseBody
public Jackpot retrieveEvent(@PathVariable("Jackpot-id") String idJackpot) {
return JackpotService.retrieveJackpot(idJackpot);
}

@PostMapping("/add-jackpot")
@ResponseBody
public Jackpot addEvent(@RequestBody Jackpot j) {
	Jackpot jackpot = JackpotService.addJackpot(j);
return jackpot;
}

@DeleteMapping("/remove-jackpot/{jackpot-id}")
@ResponseBody
public void removeEvent(@PathVariable("jackpot-id") String idJackpot) {
	JackpotService.deleteJackpot(idJackpot);
}

@PutMapping("/modify-jackpot")
@ResponseBody
public Jackpot modifyJackpot(@RequestBody Jackpot j) {
return JackpotService.updateJackpot(j);
}
}


