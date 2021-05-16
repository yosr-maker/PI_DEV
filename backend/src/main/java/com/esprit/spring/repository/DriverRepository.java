package com.esprit.spring.repository;





import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Driver;

@Repository


public interface DriverRepository  extends JpaRepository<Driver, Long>{
	
@Query("select Max(d.nbrDeliveryAffected)  from Driver d ")
public Long getDriverLMounth();

@Query("select d.nbrDeliveryAffected  from Driver d order by nbrDeliveryAffected  ")
public List<Driver> getDriverLMounthDesc();
}


	//@Query ("select MAX(column_name)FROM table_name WHERE condition)
