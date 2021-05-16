package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Automobile;

@Repository
public interface AutomobileRepository extends JpaRepository<Automobile, Long> {

}
