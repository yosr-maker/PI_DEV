package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Event;

public interface EventServiceI {
	
	
	List<Event> retrieveAllEvents();
	Event addEvent(Event e);
	void deleteEvent (String id);
	Event updateEvent(Event e);
	Event retrieveEvent(String id);

}
