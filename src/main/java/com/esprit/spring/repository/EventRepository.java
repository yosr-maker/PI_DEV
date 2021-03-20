package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.spring.entites.Event;

public interface EventRepository extends CrudRepository <Event,Long>{

}
