package com.esprit.spring.services;

import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;
import com.esprit.spring.entites.Jackpot;
import com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.JackpotRepository;


@Service
public class EventService implements EventServiceI{
		@Autowired
		EventRepository EventRepository;
		@Autowired
		JackpotRepository JackpotRepository;
		
		
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
public void deleteEvent(String id) {
	EventRepository.deleteById(Long.parseLong(id));
	
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
public void refundUsers(String idEvent) {
	// TODO Auto-generated method stub
	
}
@Override
public List<String> displayBestEventsByViews() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Map<Long, Integer> bestEventsByViews() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<String> displayBestEventsByParticipations() {
	// TODO Auto-generated method stub
	return null;
}


}
