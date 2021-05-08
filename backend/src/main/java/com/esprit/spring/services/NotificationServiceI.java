package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Notification;



public interface NotificationServiceI {
	
	public void notifyAllClient(String eventName, String eventGoal);

	List<Notification> myNotifications(Client client);

	Client notifsms(Client client);
}