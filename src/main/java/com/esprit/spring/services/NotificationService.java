package com.esprit.spring.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.controller.ClientController;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Notification;
import com.esprit.spring.entites.User;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.NotificationRepository;


@Service
public class NotificationService implements NotificationServiceI {

	@Autowired
	NotificationRepository NotificationRepository;
	@Autowired
	ClientRepository ClientRepository;
	
	public void notifyAllClient(String eventName, String eventGoal) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		
		List<Client> allClients = (List<Client>) ClientRepository.findAll();
		
		for(User u : allClients) {
			Notification n = new Notification();
			n.setClient(u);
			n.setBody("Dear "+u.getLastName()+" "+u.getFirstName()+", we invite you to contribute by an amount of money to the event "+
					  eventName+" for "+eventGoal+".Thank you.");
			n.setDate(dateFormat.format(date));
			n.setStatus("Not Seen Yet");
			NotificationRepository.save(n);
		}		
	}


	public List<Notification> myNotifications() {
		List<Notification> list = NotificationRepository.myNotifications(ClientController.USERCONNECTED);
		return list;
	}

	}

