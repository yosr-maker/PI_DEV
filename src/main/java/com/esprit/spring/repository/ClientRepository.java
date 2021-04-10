package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.esprit.spring.entites.Client;

public interface ClientRepository  extends JpaRepository<Client, Long>{

}
