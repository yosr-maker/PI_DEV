package com.esprit.spring.services;

import java.util.List;
import java.util.Map;

import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;

public interface EventServiceI {
	
	
	List<Event> retrieveAllEvents();
	Event addEvent(Event e);
	Event retrieveEvent(String id);
	Event findEventByName(String name);
	List<Event> filterEvent(EventCategory category);
	List<Event> upcomingEvents();
	List<Event> passedEvents();
	List<String> displayBestEventsByViews();
	Map<Long, Integer> bestEventsByViews();
	List<String> displayBestEventsByParticipations();
	List<Event> eventsLists();
	Event findbyId(Long id);
	void updateEvent(Long s);
	void refundUsers(Long s);
	void deleteEvent(Long s);

}
