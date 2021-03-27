package com.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Claim;
import com.esprit.spring.entites.ClaimDecision;
import com.esprit.spring.repository.ClaimRepository;


@Service
public class ClaimService implements ClaimServiceI{
		@Autowired
		ClaimRepository claimRepository;
		private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ClaimService.class);

	
@Override
public Claim addClaim(Claim c) {
	claimRepository.save(c);
	return null;
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


}