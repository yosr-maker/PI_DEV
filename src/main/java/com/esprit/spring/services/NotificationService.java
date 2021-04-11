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
import com.twilio.Twilio;

import com.twilio.rest.api.v2010.account.Message;

import com.twilio.type.PhoneNumber;



@Service
public class NotificationService implements NotificationServiceI {

	@Autowired
	NotificationRepository NotificationRepository;
	@Autowired
	ClientRepository ClientRepository;
	
	public static final String ACCOUNT_SID = "AC861e84eeadedd8f2915b9bda24eb1430";
	 public static final String AUTH_TOKEN = "c3766f62781d8a1ee94b02332948fdc5";
	
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
	public Client notifsms(Client client) {
		
		 Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
            Message message = Message.creator(new PhoneNumber(client.getPhoneNumber()),
                    new PhoneNumber("+12179033359"),
                    "Salut cher client, nous avons le regret de vous annoncer que l'événement que vous souhaitez participer a été annulé pour certaines raisons."
				    + " C'est pourquoi, nous avons remboursé le prix de votre billet. En cas de problème, n'hésitez pas à nous contacter."
				    + " Merci.").create();

            System.out.println(message.getSid());
            return client;
       }

	public List<Notification> myNotifications(Client client) {
		List<Notification> list = NotificationRepository.myNotifications(client);
		return list;
	}

	}

