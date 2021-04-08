package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Claim;

@Repository
public interface ClaimRepository extends CrudRepository<Claim,Long>,JpaRepository<Claim,Long>{
	/*
	   Change Etat Reclamation 
	@Modifying
	@Query(value = "UPDATE `claim` SET `etat`=?1,`traiter`=1 WHERE `id`=?2", nativeQuery = true)
	public void ChangetEtat(String Dispo, long id);
	
	/*Repondre au reclamation
	@Modifying
	@Query(value = "UPDATE `claim` SET `reponse`=?1 ,`traiter`=1 WHERE `id`=?2", nativeQuery = true)
	public void RepondreClaim(String reponse1, long id);
*/

}
