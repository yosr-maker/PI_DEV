package com.esprit.spring.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
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
public List<String> displayBadProductsByClaims() {
	List<String> list = new ArrayList<>();
	String s = "";
	List<Integer> listId = new ArrayList<>();
	List<Integer> lc= new ArrayList<>();//nbre de reclamations
	List<Product> listProduct = (List<Product>) productRepository.findAll();
	
	for (Product k : listProduct) {
		listId.add((int) k.getId());
		lc.add(k.getClaims().size());
	}
	
	List<Integer> sortedList = new ArrayList<>(lc);
	Collections.sort(sortedList);
	
	for (int i=0; i<3; i++) {
		int max = sortedList.get(sortedList.size()-1);// retourne le max qui a la dernière position de la liste
		int ind = listId.get(lc.indexOf(max));// prend nbre de réclamations et retourne id du produit corresspondant
		s =(i+1)+" - Product: "+productRepository.findById((long) ind).get().getName()+" with "+max+" claims ";
		list.add(s);
		sortedList.remove(sortedList.size()-1);
		lc.set(lc.indexOf(max), -1);
	}
	
	return list;
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


