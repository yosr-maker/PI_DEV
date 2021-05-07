package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Claim;

import com.esprit.spring.services.ClaimServiceI;

@RestController
public class ClaimController {

@Autowired
ClaimServiceI claimService;

@GetMapping("/retrieve-all-claims")
@ResponseBody
public List<Claim> getClaims() {
List<Claim> list = claimService.retrieveAllClaims();
return list;
}

@GetMapping("/retrieve-claim/{claim-id}")
@ResponseBody
public Claim retrieveClaim(@PathVariable("claim-id") String claimId) {
return claimService.retrieveClaim(claimId);
}

@PostMapping("/addClaim/{ProductId}/{clientId}")
@ResponseBody
public Claim addClaim(@RequestBody Claim cl,@PathVariable("ProductId") Long ProductId,@PathVariable("clientId") Long clientId) {
	 Claim c =claimService.save(cl,clientId,ProductId);
	 System.err.println(c.getIdClaim()+"**"+c.getDescriptionText()+"***"+c.getDateClaim()+"**"+c.getDecision()+"**"+c.getClient().getId()+"**"+c.getProduct().getId());
	return c;

    }
@DeleteMapping("/remove-claim/{claim-id}")
@ResponseBody
public void removeClaim(@PathVariable("claim-id") String claimId) {
claimService.deleteClaim(claimId);
}

@PutMapping("/modify-claim")
@ResponseBody
public Claim modifyClaim(@RequestBody Claim claim) {
return claimService.updateClaim(claim);
}


@GetMapping("/displayBadProductsByClaims")
@ResponseBody
public List<String> displayBestEventsByCollects()
{return claimService.displayBadProductsByClaims();}



}
