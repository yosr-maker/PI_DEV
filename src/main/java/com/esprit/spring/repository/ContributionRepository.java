package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;

public interface ContributionRepository extends CrudRepository<Contribution,Long> {

	List<Contribution> contributionOfEvent(Event e);

}
