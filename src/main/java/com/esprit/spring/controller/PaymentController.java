package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Payment;
import com.esprit.spring.services.PaymentService;

@RestController
@RequestMapping("/api")
public class PaymentController {
 
	@Autowired
	PaymentService paymentService;
	
	//pas de id
	//localhost:8092/api/add-payment
	/* 	"typeOfPayment":"online",
	"facture":"25"*/
	@PostMapping(value = "/add-payment")
	@ResponseBody
	public Payment addPayment(@RequestBody Payment pay) {
		Payment payment = paymentService.addPayment(pay);
		System.out.println("payment add works properly");
	return payment;	
	}
	
	
	//localhost:8092/api/remove-payment/2
	@DeleteMapping("/remove-payment/{payment-id}")
	@ResponseBody
	public void removePayment(@PathVariable("payment-id")Long paymentId) {
		paymentService.deletePayment(paymentId);
	}
	
	
	//localhost:8092/api/modify-payment
	/* 	"paymentId":"2","typeOfPayment":"online",
	"facture":"25"*/
	@PutMapping("/modify-payment")
	@ResponseBody
	public Payment modifyPayment(@RequestBody Payment pay) {
	return paymentService.updatePayment(pay);
	}
	
	//localhost:8092/api/retrieve-payment/4
	@GetMapping("/retrieve-payment/{payment-id}")
	@ResponseBody
	public Payment retrievePayment(@PathVariable("payment-id") Long paymentId) {
	return paymentService.retrievePayment(paymentId);
	}
	
	
	//localhost:8092/api/retrieve-all-payments
	@GetMapping("/retrieve-all-payments")
	@ResponseBody
	public List<Payment> getPayment() {
	List<Payment> list = paymentService.retrieveAllPayments();
	return list;
	}
	
	
}
