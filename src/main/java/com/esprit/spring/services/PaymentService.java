package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Payment;

public interface PaymentService {
	List<Payment> retrieveAllPayments();
	Payment addPayment(Payment pay);
	void deletePayment(Long paymentId);		
	Payment updatePayment(Payment pay );
	Payment retrievePayment(Long paymentId);
	
	
}
