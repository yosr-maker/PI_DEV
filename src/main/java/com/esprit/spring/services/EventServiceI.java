package com.esprit.spring.services;

import java.util.List;
import java.util.Map;

import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;

public interface EventServiceI {
	
	
	List<Event> retrieveAllEvents();
	Event addEvent(Event e);
	void deleteEvent (String id);
	Event retrieveEvent(String id);
	Event findEventByName(String name);
	List<Event> filterEvent(EventCategory category);
	void refundUsers(String idEvent);
	List<Event> upcomingEvents();
	List<Event> passedEvents();
	List<String> displayBestEventsByViews();
	Map<Long, Integer> bestEventsByViews();
	List<String> displayBestEventsByParticipations();
	List<Event> eventsLists();
	Event findbyId(Long id);
	void updateEvent(Long s);

}
