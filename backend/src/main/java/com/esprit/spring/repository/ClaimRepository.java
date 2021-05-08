package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Claim;

@Repository
public interface ClaimRepository extends CrudRepository<Claim,Long>,JpaRepository<Claim,Long>{

}
