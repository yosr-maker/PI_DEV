package com.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import com.esprit.spring.entites.Claim;
import com.esprit.spring.entites.ClaimDecision;

public interface ClaimServiceI {
	
	
	
	List<Claim> retrieveAllClaims();
	void deleteClaim (String id);
	Claim updateClaim(Claim c);
	Claim retrieveClaim(String id);
	void updateDecision(long idClaim, ClaimDecision decision);
	Optional<Claim> getByIdClaim(Long id);
	Claim save(Claim cl, long clientId, long productId);
	List<String> displayBadProductsByClaims();


}





