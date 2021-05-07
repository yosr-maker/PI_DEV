package com.esprit.spring.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;
@Service
public interface EventServiceI {
	
	public void addEvent(Event event);
	public List<Event> eventsLists();
	public void updateEvent(Long eid);
	public void deleteEvent(Long id) ;
	public Event findbyId(Long id);
	public Event findEventByName(String name);
	public List<Event> filterEvent(EventCategory category);
	public List<Event> upcomingEvents();
	public List<Event> passedEvents();
	public void refundClients(Long eid);
	
	public List<String> displayBestEventsByParticipations();
	List<String> displayBestEventsByCollects();



}
