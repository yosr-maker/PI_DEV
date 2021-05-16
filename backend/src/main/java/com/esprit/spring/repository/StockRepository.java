package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Stock;


@Repository
public interface StockRepository extends CrudRepository<Stock, Integer>{

}
