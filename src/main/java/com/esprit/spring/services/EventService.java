package com.esprit.spring.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;
import com.esprit.spring.entites.Jackpot;
import com.esprit.spring.entites.Notification;
import com.esprit.spring.entites.Participation;
import com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.JackpotRepository;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.NotificationRepository;
import com.esprit.spring.repository.ContributionRepository;
@Service
public class EventService implements EventServiceI{
		@Autowired
		EventRepository EventRepository;
		@Autowired
		JackpotRepository JackpotRepository;
		@Autowired
		JackpotRepository ParticipationRepository;
		@Autowired 
		ClientRepository ClientRepository;
		@Autowired 
		NotificationRepository NotificationRepository ;
		@Autowired
		ContributionRepository ContributionRepository;
		
		
		private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(EventService.class);



@Override
public List<Event> retrieveAllEvents() {
	List<Event>events= (List<Event>) EventRepository.findAll();
	for (Event Event:events){
		l.info("la liste des évenements    +++ :" + Event);
	}		
return events;	
}

@Override
public Event addEvent(Event event) {
	Event NewEvent = new Event();
	
	NewEvent.setCategory(event.getCategory());
	NewEvent.setName(event.getName());
	NewEvent.setDescription(event.getDescription());
	NewEvent.setPlacesNbr(event.getPlacesNbr());
	NewEvent.setParticipantsNbr(0);
	NewEvent.setCollAmount(0);
	NewEvent.setDateEvent(event.getDateEvent());
	NewEvent.setHour(event.getHour());
	NewEvent.setLocation(event.getLocation());
	NewEvent.setPoster(event.getPoster());
	NewEvent.setTicketPrice(event.getTicketPrice());
	NewEvent.setGoal(event.getGoal());
	NewEvent.setStatus(false);
	Jackpot j = new Jackpot();
	j.setSum(0);
	JackpotRepository.save(j);
	NewEvent.setJackpot(j);
	EventRepository.save(NewEvent);
	
	return null;
}

@Override
public List<Event> eventsLists() {
	return (List<Event>) EventRepository.findAll();
}




@Override
public void updateEvent(Long s) {
	Event e = EventRepository.findById(s).get();
	e.setCategory(e.getCategory());
	e.setName(e.getName());
	e.setDescription(e.getDescription());
	e.setPlacesNbr(e.getPlacesNbr());
	e.setDateEvent(e.getDateEvent());
	e.setHour(e.getHour());
	e.setLocation(e.getLocation());
	e.setPoster(e.getPoster());
	e.setTicketPrice(e.getTicketPrice());
	e.setGoal(e.getGoal());
	EventRepository.save(e);
}

@Override
public Event retrieveEvent(String id) {
	Event e= EventRepository.findById(Long.parseLong(id)).orElse(null);
	return e;
}

@Override
public Event findbyId(Long id) {
	return EventRepository.findById(id).get();
}

@Override
public Event findEventByName(String name) {
	return EventRepository.findByName(name); 
}


@Override
public List<Event> filterEvent(EventCategory category) {
	return EventRepository.filterByCategory(category);
}@Override
public List<Event> upcomingEvents() {
	List<Event> list= EventRepository.upcomingEvents();
	return list;
}

@Override
public List<Event> passedEvents() {
	List<Event> list= EventRepository.passedEvents();
	return list;
}



@Override
public void refundUsers(Long s) {
	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	java.util.Date date = new java.util.Date();
	
	Event e = findbyId(s);
	
	List<Participation> participationsOfEvent = ParticipationRepository.Participations(e);
	
	for(Participation p : participationsOfEvent) {
		Client c = p.getClient();
		float refundedAmount = p.getPrice();
		e.setCollAmount(e.getCollAmount()-refundedAmount);
		c.setAccBalance(c.getAccBalance()+refundedAmount);
		ClientRepository.save(c);
		ParticipationRepository.deleteById(p.getId());
		EventRepository.save(e);
		Notification n = new Notification();
		n.setClient(c);
		n.setBody("Dear "+c.getLastName()+" "+c.getFirstName()+""
				+ ",we regret to announce that the event "+e.getName()+" you want to attend has been canceled for a some reasons."
				+ " That's why, we have refunded your ticket price. If there is a problem, do not hesitate to contact us."
				+ " Thank you.");
		n.setDate(dateFormat.format(date));
		n.setStatus("Not Seen Yet");
		NotificationRepository.save(n);
	}
	
	List<Contribution> contributionsOfEvent = ContributionRepository.contributionOfEvent(e);
	
	for(Contribution c : contributionsOfEvent) {
		Client k = c.getClient();
		float refundedAmount = c.getAmount();
		e.getJackpot().setSum(e.getJackpot().getSum()-refundedAmount);
		e.setCollAmount(e.getCollAmount()-refundedAmount);
		k.setAccBalance(k.getAccBalance()+refundedAmount);
		Notification n = new Notification();
		n.setClient(k);
		n.setBody("Dear "+k.getLastName()+" "+k.getFirstName()+""
				+ ",we regret to announce that the event "+e.getName()+" to which you contributed was canceled for several reasons."
				+ " That's why, we have refunded your contribution. If there is a problem, do not hesitate to contact us."
				+ " Thank you.");
		n.setDate(dateFormat.format(date));
		n.setStatus("Not Seen Yet");
		NotificationRepository.save(n);
		ClientRepository.save(k);
		ClientRepository.deleteById(c.getId());
		EventRepository.save(e);
	}
	
	}

@Override
public List<String> displayBestEventsByViews() {
	List<String> list = new ArrayList<>();
	String s = "";
	List<Long> listId = new ArrayList<>();
	List<Integer> listViews= new ArrayList<>();
	List<Event> listEvent = EventRepository.findAll();
	
	for (Event e : listEvent) {
		listId.add(e.getIdEvent());
		listViews.add(e.getViews());
	}
	
	List<Integer> sortedList = new ArrayList<>(listViews);
	Collections.sort(sortedList);
	
	for (int i=0; i<3; i++) {
		int max = sortedList.get(sortedList.size()-1);// retourne le max qui a la dernière position de la liste
		Long ind = listId.get(listViews.indexOf(max));// prend nbre de vue et retourne id d'event corresspondant
		s = (i+1)+"- Event: "+EventRepository.findById(ind).get().getName()+" with "+max+" views ";
		list.add(s);
		sortedList.remove(sortedList.size()-1);
		listViews.set(listViews.indexOf(max), -1);
	}
	
	return list;
}

@Override
public Map<Long, Integer> bestEventsByViews() {
	
	Map<Long,Integer> h = new HashMap<>();
	List<Long> listId = new ArrayList<>();
	List<Integer> listViews= new ArrayList<>();
	List<Event> listEvent = EventRepository.findAll();
	
	for (Event e : listEvent) {
		listId.add(e.getIdEvent());
		listViews.add(e.getViews());
	}
	
	List<Integer> sortedList = new ArrayList<>(listViews);
	Collections.sort(sortedList);
	
	for (int i=0; i<3; i++) {
		int max = sortedList.get(sortedList.size()-1);// retourne le max qui a la dernière position de la liste
		Long ind = listId.get(listViews.indexOf(max));// prend nbre de vue et retourne id d'event corresspondant
		h.put(ind, max);
		System.out.println(ind +" "+ max);
		sortedList.remove(sortedList.size()-1);
		listViews.set(listViews.indexOf(max), -1);
	}
	
	return h;
}

@Override
public List<String> displayBestEventsByParticipations() {
	List<String> list = new ArrayList<>();
	String s = "";
	List<Long> listId = new ArrayList<>();
	List<Integer> listViews= new ArrayList<>();
	List<Event> listEvent = EventRepository.findAll();
	
	for (Event e: listEvent) {
		listId.add(e.getIdEvent());
		listViews.add(e.getParticipantsNbr());
	}
	
	List<Integer> sortedList = new ArrayList<>(listViews);
	Collections.sort(sortedList);
	
	for (int i=0; i<3; i++) {
		int max = sortedList.get(sortedList.size()-1);// retourne le max qui a la dernière position de la liste
		Long ind = listId.get(listViews.indexOf(max));// prend nbre de participations et retourne id d'event corresspondant
		s = (i+1)+"- Event: "+EventRepository.findById(ind).get().getName()+" with "+max+" participations ";
		list.add(s);
		sortedList.remove(sortedList.size()-1);
		listViews.set(listViews.indexOf(max), -1);
	}
	
	return list;
}


@Override
public void deleteEvent(Long s) {
	EventRepository.deleteById(s);
	
}






}
