package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Jackpot;

public interface JackpotServiceI {
	
	List<Jackpot> retrieveAllJackpots();
	Jackpot addJackpot(Jackpot j);
	void deleteJackpot (String id);
	Jackpot updateJackpot(Jackpot j);
	Jackpot retrieveJackpot(String id);

}
