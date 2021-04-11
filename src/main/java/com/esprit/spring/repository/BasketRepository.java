package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Basket;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Command_line;

import java.util.List;


@Repository
public interface BasketRepository  extends JpaRepository<Basket, Long> {
	@Query("select b from Basket b where b.isValid=false and b.client=:id ")

	public Basket retrieveBasketJPQL(@Param("id") Long id);
	

	@Query("select b.commandLine from Basket b where b.basketId=:id ")
	public List<Command_line> findCommandLineForBasket(@Param("id")Long id);
	
	@Query("select b.commandLine from Basket b where b.isValid=true ")
	public List<Command_line> getAllCommandLineOfValidBasket();
	
	@Query("select b.commandLine from Basket b where b.isValid=false and b.client=:client ")
	public List<Command_line> findMyBasketCommandLines(@Param("client") Client client);

	@Query("select b from Basket b where b.isValid=true and b.client=:id ")
	public List<Basket> findMyValidBasketJPQL(@Param("id")Long id);
	
	@Query("select b from Basket b where b.isValid=true ")
	public List<Basket> findAllValidBaskets();
	
	@Query("select b from Basket b where b.isValid=false and b.client=:id ")
	public Basket findMyBasketNotValidatedYet(@Param("id")Long id);
	
}
