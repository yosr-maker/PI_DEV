package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Claim;
import com.esprit.spring.entites.ClaimDecision;
public interface ClaimServiceI {
	
	
	
	List<Claim> retrieveAllClaims();
	void deleteClaim (String id);
	Claim updateClaim(Claim c);
	Claim retrieveClaim(String id);
	void updateDecision(long idClaim, ClaimDecision decision);
	Claim save(Claim rec, long u);
/*	void rembourserReclamation(long id);
	void ReparerReclamation(long id);
	void EchangeReclamation(long id);*/


}





