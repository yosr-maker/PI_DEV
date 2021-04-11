package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;
import com.esprit.spring.entites.Notification;
import com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.ParticipationRepository;
import com.esprit.spring.services.ContributionService;
import com.esprit.spring.services.EventServiceI;
import com.esprit.spring.services.NotificationService;
import com.esprit.spring.services.ParticipationService;

@RestController
public class EventController {
	@Autowired
	EventServiceI EventService;
	@Autowired
	EventRepository EventRepository;
	@Autowired
	NotificationService NotificationService;
	@Autowired
	ParticipationService ParticipationService;
	@Autowired
	ContributionService ContributionService;
	@Autowired
	ParticipationRepository PR;
	
	@PostMapping("/add-Event")
	@ResponseBody
	public void addEvent(@RequestBody Event ev) {
		EventService.addEvent(ev);
		NotificationService.notifyAllClient(ev.getName(),ev.getDescription());
	}
	
	@GetMapping("/retrieve-all-Events")
	public List<Event> getEvents(){
		List<Event> list = EventService.eventsLists();
		return list;
	}
	

	@GetMapping("/retrieve-Event-ById/{id}")
	public Event getEventById(@PathVariable Long id) {
		return EventService.findbyId(id);
		}
	
	@GetMapping("/retrieve-Event-ByName/{name}")
	public Event getEventByName(@PathVariable String name) {
		final Event ev = EventService.findEventByName(name);
		return ev;
		}
	
	@GetMapping("/retrieve-Events-ByCategory/{category}")
	public List<Event> findEventByCategory(@PathVariable EventCategory category) {
		List<Event> list = EventService.filterEvent(category);
		return list;
		}

	
	@DeleteMapping("/delete-Event/{event-id}")
	@ResponseBody
	public void deleteEvent(@PathVariable("event-id") Long eventID) {
		EventService.refundClients(eventID);
		EventService.deleteEvent(eventID);
	}


	
	/*user :*/
	@PostMapping("/add-Contribution/{event-id}/{clientId}/{amount}")
	@ResponseBody
	public String Contribute(@PathVariable("event-id") Long eventID,@PathVariable("clientId") Long clientId,@PathVariable("amount") float amount) {
		return ContributionService.Contribute(eventID, clientId ,amount);
	}
	
	@RequestMapping("/add-Participation/{eid}/{clientId}")
	@ResponseBody
	public String addParticipation(@PathVariable("eid") Long eid,@PathVariable("clientId") Long clientId) {
		return ParticipationService.addParticipation(eid,clientId);
	}

	
	
	@GetMapping("/retrieve-my-Contributions/{client}")
	public List<Contribution> myContributionsHistory(@PathVariable("client") Client client){
		return ContributionService.myContributionHistory(client);
	}

	
	@GetMapping("/retrieve-my-Notifications/{client}")
	public List<Notification> getMyNotifications(@PathVariable("client") Client client){
		return NotificationService.myNotifications(client);
	}
	
	@GetMapping("/retrieve-upcoming-Events")
	public List<Event> upcomingEvents() {
		return EventService.upcomingEvents();
	}
	
	@GetMapping("/retrieve-passed-Events")
	public List<Event> passedEvents() {
		return EventService.passedEvents();
	}
	
	

	@GetMapping("/displayBestEventsByParticipations")
	@ResponseBody
	public List<String> displayBestEventsByParticipations()
	{return EventService.displayBestEventsByParticipations();}
	
	

	@GetMapping("/participationsList/{idEvent}")
	@ResponseBody
	public List<String> participationsList(@PathVariable("idEvent") int idEvent) 
	{return ParticipationService.participationsList(idEvent);}
	
	

	@GetMapping("/displayBestEventsByCollects")
	@ResponseBody
	public List<String> displayBestEventsByCollects()
	{return EventService.displayBestEventsByCollects();}

}






