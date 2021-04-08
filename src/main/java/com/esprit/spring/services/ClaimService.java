package com.esprit.spring.services;

import java.time.LocalDate;
import java.util.Calendar;
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
import com.esprit.spring.entites.Product;
import com.esprit.spring.repository.ClaimRepository;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.ProductRepository;


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
		@Autowired
		ProductRepository productRepository;

		//private int A;
		//private int B;
		//private int res;
		
		private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(ClaimService.class);

	
@Override
public Claim save(Claim cl, long clientId,long productId) {
	Client c=clientRepository.findById(clientId).get();
	Product p = productRepository.findById(productId).get();
	cl.setClient(c);
	cl.setProduct(p);
	claimRepository.save(cl);	
	return cl;

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
@Override
public Optional<Claim> getByIdClaim(Long id){
	return claimRepository.findById(id);
}





}

/*
@Override
public void rembourserReclamation(long id){

	Optional<Claim> cl = claimRepository.findById(id);
	if (cl.isPresent()) {
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
*/



/*
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



