package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.Jackpot;
import com.esprit.spring.entites.Participation;

public interface JackpotRepository extends CrudRepository <Jackpot,Long>, JpaRepository<Jackpot,Long>{

	List<Participation> Participations(Event e);

}
