package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Command;

@Repository

public interface CommandRepository extends JpaRepository<Command, Long> {

}
