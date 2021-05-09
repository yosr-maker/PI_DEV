package com.esprit.spring.repository;


import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Client;



@Repository
public interface ClientRepository extends CrudRepository<Client,Long>{


}
