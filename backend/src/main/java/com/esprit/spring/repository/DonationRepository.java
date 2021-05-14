package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.esprit.spring.entites.Donation;

public interface DonationRepository extends CrudRepository<Donation,Long>{

}
