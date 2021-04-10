package com.esprit.spring.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import com.esprit.spring.entites.RayMaster;

@Repository

public interface RayMasterRepository extends CrudRepository<RayMaster, Long> {
	
	
	
	@Query("select ry from RayMaster ry where ry.username=:username")
	RayMaster findByUsername(@Param ("username") String username);
	
	RayMaster findByUsernameAndEmail(String username,String email);

}
