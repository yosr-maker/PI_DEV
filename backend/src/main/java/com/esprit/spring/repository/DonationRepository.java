package com.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.esprit.spring.entites.Donation;



@Repository
public interface DonationRepository extends CrudRepository<Donation,Long>,JpaRepository<Donation,Long>{



}
