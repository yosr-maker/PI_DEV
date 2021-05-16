package com.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Basket;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Facture;



@Repository
public interface FactureRepository extends JpaRepository<Facture, Long>{

	@Query("select f from Facture f where f.basketDetail=:basketId")
	public Facture findMyFactureJPQL(@Param("basketId")Basket basketId);
	
	@Query("Select "
			+ "DISTINCT f from Facture f "
			+ "join f.basketDetail bas "
			+ "join bas.client cli "
			+ "where cli=:id")
    public List<Facture> getAllMyBills(@Param("id") Client id);
	
	
	
}
