package com.esprit.spring.services;


import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Automobile;
import com.esprit.spring.entites.Driver;
import com.esprit.spring.repository.AutomobileRepository;
import com.esprit.spring.repository.DriverRepository;

@Service
public class AutomibileServiceImpl implements AutomobileService{
	@Autowired
	AutomobileRepository automobileRepository;
	@Autowired
	DriverRepository driverRepository;
	
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(AutomobileService.class);

	

	@Override
	public Automobile addAutomobile(Automobile auto) {
		return automobileRepository.save(auto);
		 
	}
	
	@Override
	public Automobile updateAutomobile(Automobile auto) {
		return automobileRepository.save(auto);
		 
	}



	@Override
	public Automobile retrieveAutomobile(Long idAuto) {
		Automobile auto= automobileRepository.findById(idAuto).get();
		return auto;
	}
	
	@Override
	public List<Automobile> retrieveAllAutomobiles() {
	List<Automobile> automobiles= (List<Automobile>) automobileRepository.findAll();
		for(Automobile automobile:automobiles) {
			l.info("auto :" + automobile);
		}
	return automobiles;
	}


	@Override
	public void deleteAutomobile(Long idAuto) {
		automobileRepository.deleteById(idAuto);
		
	}
	//affecter un driver a n automobilev 

	@Override
	public void affecterAutoToDriver(Long idAuto, Long idDriver) {
		Driver driver = driverRepository.findById(idDriver).get();
		Automobile auto = automobileRepository.findById(idAuto).get();
		
		auto.setDriver(driver);
		driverRepository.save(driver);
		}
	




}
