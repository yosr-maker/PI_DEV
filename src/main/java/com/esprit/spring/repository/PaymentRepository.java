package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Payment;

@Repository

public interface PaymentRepository  extends JpaRepository<Payment, Long> {

}
