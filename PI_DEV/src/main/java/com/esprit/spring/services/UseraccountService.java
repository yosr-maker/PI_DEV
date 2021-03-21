package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import com.esprit.spring.entites.Useraccount;
import com.esprit.spring.repository.UseraccountRepository;


public class UseraccountService implements UseraccountServiceI {

	
	@Autowired
	UseraccountRepository useraccountRepository;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(UseraccountService.class);
	
	@Override
	public List<Useraccount> retrieveAllUseraccounts() {
		List<Useraccount> useraccounts = (List<Useraccount>) useraccountRepository.findAll();
		for (Useraccount useraccount: useraccounts ) {
			l.info("la liste des publications données +++: " + useraccount); }
		return null;
	}
	
	
	
	
	
	
	@Override
	public Useraccount addUseraccount(Useraccount u) {
		useraccountRepository.save(u);
		return null;
	}
	@Override
	public void deleteUseraccount(String id) {
		useraccountRepository.deleteById(Long.parseLong(id));
		
	}
	@Override
	public Useraccount updateUseraccount(Useraccount u) {
		useraccountRepository.save(u);
		return null;
	}
	@Override
	public Useraccount retrieveUseraccount(String id) {
		Useraccount useraccount = useraccountRepository.findById(Long.parseLong(id)).orElse(null);
		return useraccount;
	}

}
	
	
	
	