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
import com.esprit.spring.entites.Donation;
import com.esprit.spring.services.DonationServiceI;

@RestController
public class DonationController {


@Autowired
DonationServiceI donationService;

@GetMapping("/retrieve-all-Donations")
@ResponseBody
public List<Donation> getDonations() {
List<Donation> list = donationService.retrieveAllDonations();
return list;
}

@GetMapping("/retrieve-donation/{donation-id}")
@ResponseBody
public Donation retrieveDonation(@PathVariable("donation-id") String donationId) {
return donationService.retrieveDonation(donationId);
}

@PostMapping("/add-donation")
@ResponseBody
public Donation addDonation(@RequestBody Donation d) {
Donation donation = donationService.addDonation(d);
return donation;
}

@DeleteMapping("/remove-donation/{donation-id}")
@ResponseBody
public void removeDonation(@PathVariable("donation-id") String donationId) {
	donationService.deleteDonation(donationId);
}

@PutMapping("/modify-donation")
@ResponseBody
public Donation modifyDonation(@RequestBody Donation donation) {
return donationService.updateDonation(donation);
}
}

