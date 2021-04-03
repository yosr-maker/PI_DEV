package com.esprit.spring.services;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Claim;
import com.esprit.spring.entites.ClaimDecision;
import com.esprit.spring.entites.Client;
import com.esprit.spring.repository.ClaimRepository;
import com.esprit.spring.repository.ClientRepository;


@Service
public class ClaimService implements ClaimServiceI{
		@Autowired
		ClaimRepository claimRepository;
		@Autowired
		ClientService ClientService;
		@Autowired 
		ClientRepository clientRepository;
		@Autowired
		ClaimService claimService;

		private int A;
		private int B;
		private int res;
		
		private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ClaimService.class);

	
@Override
public Claim save(Claim rec, long u) {
	Client us = ClientService.findOne(u);
	rec.setReponse(null);
	rec.setTraiter(false); 
	rec.setEtat("En_attente");
	rec.setClient(us);
	return claimRepository.save(rec);

}

@Override
public void deleteClaim(String id) {
	claimRepository.deleteById(Long.parseLong(id));
	
}


@Override
public Claim updateClaim(Claim c) {
	claimRepository.save(c);
	return null;
}

@Override
public Claim retrieveClaim(String id) {
	 Claim c  =claimRepository.findById(Long.parseLong(id)).orElse(null);
		return c;
}
@Override
public List<Claim> retrieveAllClaims() {
	List<Claim>claims= (List<Claim>) claimRepository.findAll();
	for (Claim claim: claims){
		l.info("les réclamations  +++ :" + claim);
	}
		
return claims;	
}
@Override
public void updateDecision(long id, ClaimDecision decision) {
    Optional<Claim> oClaim = claimRepository.findById(id);
    if (oClaim.isPresent()) {
       Claim claim = oClaim.get();
        claim.setDecision(decision);
        claimRepository.save(claim);
    }
}
/*
	
/*Rembourser reclamation
@Override
public void rembourserReclamation(long id){
	
	Claim cl;
	Optional<Claim> c = claimRepository.findById(id);
	 A = cl.getProduct().getDate();
	 B = LocalDate.now().getDayOfYear();
	res = B-A;
	if (res < 10)  {
		claimRepository.ChangetEtat("Remboursement", id);
	}
	else{
		claimRepository.ChangetEtat("En_attente", id);
		
	}

}

@Override
public void ReparerReclamation(long id){
	
	Claim cl;
	//Optional<Claim> c = claimRepository.findById(id);
	 A = cl.getProduct().getDate();
	 B = LocalDate.now().getDayOfYear();
	res = B-A;
	if (res < 10)  {
		claimRepository.ChangetEtat("Reparer", id);
	}
	else{
		claimRepository.ChangetEtat("En_attente", id);
		
	}

}
@Override
public void EchangeReclamation(long id){
	
	Claim cl = null;
	//Optional<Claim> c = claimRepository.findById(id);
	 A = cl.getProduct().getDate();
	 B = LocalDate.now().getDayOfYear();
	res = B-A;
	if (res < 10)  {
		claimRepository.ChangetEtat("Echange", id);
	}
	else{
		claimRepository.ChangetEtat("En_attente", id);
		
	}

}
*/


}


