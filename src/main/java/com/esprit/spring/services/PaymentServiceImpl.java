package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Payment;
import com.esprit.spring.repository.PaymentRepository;

@Service
public class PaymentServiceImpl implements PaymentService {

	
	@Autowired 
	PaymentRepository paymentRepository ;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(PaymentService.class);

	
	@Override
	public List<Payment> retrieveAllPayments() {
		List<Payment> payments =(List<Payment>) paymentRepository.findAll();
		for(Payment payment:payments) {
			l.info("payment" + payment);
		}
		return payments;
	}

	@Override
	public Payment addPayment(Payment pay) {
		return paymentRepository.save(pay) ;
	}

	@Override
	public void deletePayment(Long paymentId) {
		paymentRepository .deleteById(paymentId);
		
	}

	@Override
	public Payment updatePayment(Payment pay) {
		return paymentRepository.save(pay);
	}

	@Override
	public Payment retrievePayment(Long paymentId) {
		return paymentRepository.findById(paymentId).get();
	}

}
