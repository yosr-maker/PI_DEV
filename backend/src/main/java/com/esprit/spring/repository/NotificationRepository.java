package com.esprit.spring.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Notification;


@Repository
public interface NotificationRepository extends CrudRepository<Notification,Long>, JpaRepository<Notification,Long>{
	
	@Query("SELECT n FROM Notification n WHERE n.client=:id")
	List<Notification> myNotifications(@Param("id") Client client);

}
