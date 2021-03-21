package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.Participation;

public interface ParticipationRepository extends CrudRepository<Participation,Long> , JpaRepository<Participation,Long>{

	//@Query("SELECT p FROM Participation p WHERE p.user=:user")
	//List<Participation> myParticipations(@Param ("user") User user);
	
	@Query("SELECT p FROM Participation p WHERE p.event=:event")
	List<Participation> Participations(@Param ("event") Event event);


	

}
