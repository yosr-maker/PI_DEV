package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.spring.entites.Stock;

public interface StockRepository extends JpaRepository<Stock, Long> {

}
