package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;
@Repository
public interface EventRepository extends CrudRepository<Event,Long>, JpaRepository<Event,Long>{

	@Query("SELECT ev FROM Event ev WHERE ev.name=:name")
	Event findByName(@Param ("name") String name);
	
	@Query("SELECT ev FROM Event ev WHERE ev.category=:category")
	List<Event> filterByCategory(@Param ("category") EventCategory category);
	
	@Query(value = "SELECT ev FROM Event ev where ev.date > current_timestamp()", nativeQuery = true)
	List<Event> upcomingEvents();
	
	@Query(value = "SELECT ev FROM Event ev where ev.date < current_timestamp()",nativeQuery = true)
	List<Event> passedEvents();
}


