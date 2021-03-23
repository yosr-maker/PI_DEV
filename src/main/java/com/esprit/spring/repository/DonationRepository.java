package com.esprit.spring.repository;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Donation;



@Repository
public interface DonationRepository extends CrudRepository<Donation,Long>,JpaRepository<Donation,Long>{


	@Query("SELECT d FROM Donations d WHERE d.product=:product")
	List<Donation> Donations(@Param ("donation")Donation d);

}
