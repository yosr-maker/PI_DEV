package com.esprit.spring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.RayMaster;

@Repository

public interface RayMasterRepository extends CrudRepository<RayMaster, Long> {

}
