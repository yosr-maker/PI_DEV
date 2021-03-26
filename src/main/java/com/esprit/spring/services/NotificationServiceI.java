package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Notification;



public interface NotificationServiceI {
	
	public void notifyAllClient(String eventName, String eventGoal);
	public List<Notification> myNotifications();
}