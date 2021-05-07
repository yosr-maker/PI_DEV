package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.Jackpot;

import com.esprit.spring.repository.JackpotRepository;

@Service
public class JackpotService implements JackpotServiceI {
	@Autowired
	JackpotRepository jackpotRepository;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(JackpotService.class);


	@Override
	public List<Jackpot> retrieveAllJackpots() {
		List<Jackpot>Jackpots= (List<Jackpot>) jackpotRepository.findAll();
		for (Jackpot Jackpot: Jackpots){
			l.info("les cagnottes disponibles  +++ :" + Jackpot);
		}
			
	return Jackpots;	
	}

	@Override
	public Jackpot addJackpot(Jackpot j) {
		jackpotRepository.save(j);
		return null;
	}

	@Override
	public void deleteJackpot(String id) {
		jackpotRepository.deleteById(Long.parseLong(id));
	}

	@Override
	public Jackpot updateJackpot(Jackpot j) {
		jackpotRepository.save(j);
		return null;
	}

	@Override
	public Jackpot retrieveJackpot(String id) {
		Jackpot j  =jackpotRepository.findById(Long.parseLong(id)).orElse(null);
			return j;
	}
	@Override
	public Jackpot findJackpot(Event event) {
		Jackpot jackpot = event.getJackpot();
		return jackpot;
	}
}
