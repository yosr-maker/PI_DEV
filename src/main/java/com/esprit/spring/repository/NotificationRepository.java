package com.esprit.spring.repository;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.repository.CrudRepository;

import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Notification;
@Repository
public interface NotificationRepository extends CrudRepository<Notification,Long>, JpaRepository<Notification,Long>{

	
	//@Query("SELECT n FROM Notification n WHERE n.client=:clientid")
	//List<Notification> myNotifications(@Param("id") Client id);
}
