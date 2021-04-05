package com.esprit.spring.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Notification;

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
		
		Iterable<Client> allClients =  ClientRepository.findAll();
		
		for(Client u : allClients) {
			Notification n = new Notification();
			n.setClient(u);
			n.setBody("Mr/Mdm "+u.getLastName()+" "+u.getFirstName()+", Nous vous invitons à contribuer une somme d'argent à l'évenement "+
					  eventName+" pour "+eventGoal+".merci.");
			n.setDate(dateFormat.format(date));
			n.setStatus("Pas encore vu");
			NotificationRepository.save(n);
		}		
	}

	@Override
	public List<Notification> myNotifications() {
		// TODO Auto-generated method stub
		return null;
	}


	/*public List<Notification> myNotifications() {
		List<Notification> list = NotificationRepository.myNotifications(ClientRepository.findById(Client.getId()));
		return list;
	}*/

	}

