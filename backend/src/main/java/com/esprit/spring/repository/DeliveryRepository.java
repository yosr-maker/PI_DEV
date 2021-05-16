package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Delivery;
@Repository

public interface DeliveryRepository   extends JpaRepository<Delivery, Long>{

}
