package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.spring.entites.Visitor;

public interface VisitorRepository  extends JpaRepository<Visitor, Integer> {

}
