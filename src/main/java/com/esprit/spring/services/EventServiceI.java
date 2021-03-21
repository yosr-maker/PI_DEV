package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;

public interface EventServiceI {
	
	
	List<Event> retrieveAllEvents();
	Event addEvent(Event e);
	void deleteEvent (String id);
	Event updateEvent(Event e);
	Event retrieveEvent(String id);
	Event findEventByName(String name);
	List<Event> filterEvent(EventCategory category);
	void refundUsers(String idEvent);

}
