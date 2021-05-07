package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.Participation;
@Repository
public interface ParticipationRepository extends CrudRepository<Participation,Long> , JpaRepository<Participation,Long>{

	

	@Query("SELECT p FROM Participation p WHERE p.event=:event")
	List<Participation> Participations(@Param ("event") Event event);
	



}
