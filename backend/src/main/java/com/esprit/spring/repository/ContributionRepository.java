package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;
@Repository
public interface ContributionRepository extends CrudRepository<Contribution,Long>,JpaRepository<Contribution,Long> {


	@Query("SELECT c FROM Contribution c WHERE c.event=:event ")
	List<Contribution> contributionOfEvent(@Param("event") Event event);
	
	@Query("SELECT c FROM Contribution c WHERE c.client=:client")
	List<Contribution> contributionOfClient(@Param("client") Client client);

}
