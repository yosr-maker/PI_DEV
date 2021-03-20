package com.esprit.spring.services;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.spring.entites.Event;
import com.esprit.spring.repository.EventRepository;


@Service
public class EventService implements EventServiceI{
		@Autowired
		EventRepository EventRepository;
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
public Event addEvent(Event e) {
	EventRepository.save(e);
	 return null ; 
}


@Override
public void deleteEvent(String id) {
	EventRepository.deleteById(Long.parseLong(id));
	
}

@Override
public Event updateEvent(Event e) {
	EventRepository.save(e);
	 return null ; 
}

@Override
public Event retrieveEvent(String id) {
	Event e= EventRepository.findById(Long.parseLong(id)).orElse(null);
	return e;
}
}
