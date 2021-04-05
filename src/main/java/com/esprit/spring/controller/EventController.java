package com.esprit.spring.controller;

import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;
import com.esprit.spring.entites.Notification;
import com.esprit.spring.entites.Participation;
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
		EventService.refundUsers(eventID);//refund contributions & participations prices to its users
		EventService.deleteEvent(eventID);
	}
	

	
	/*@GetMapping("/retrieve-all-Participations")
	public List<Participation> getParticipations(){
		return ParticipationService.participationsList();
	}
	*/
	/*user :*/
	@PostMapping("/add-Contribution/{event-id}/{amount}")
	@ResponseBody
	public void Contribute(@PathVariable("event-id") Long eventID,@PathVariable("amount") float amount) {
		ContributionService.Contribute(eventID, amount);
	}
	
	@RequestMapping("/add-Participation/{eid}")
	@ResponseBody
	public String addParticipation(@PathVariable("eid") Long eid) {
		return ParticipationService.addParticipation(eid);
	}

	
	
	@GetMapping("/retrieve-my-Contributions")
	public List<Contribution> myContributionsHistory(){
		return ContributionService.myContributionHistory();
	}
	

	
	@GetMapping("/retrieve-my-Participations")
	public List<Participation> getMyParticipations(){
		return ParticipationService.myParticipations();
	}
	
	@GetMapping("/retrieve-my-Notifications")
	public List<Notification> getMyNotifications(){
		return NotificationService.myNotifications();
	}
	
	@GetMapping("/retrieve-upcoming-Events")
	public List<Event> upcomingEvents() {
		return EventService.upcomingEvents();
	}
	
	@GetMapping("/retrieve-passed-Events")
	public List<Event> passedEvents() {
		return EventService.passedEvents();
	}
	
	@GetMapping("/bestEventsByViews")
	public Map<Long, Integer> bestEventsByViews(){
		return EventService.bestEventsByViews();
		}
	
	
	
	@GetMapping("/retrieveBestEventsByParticipations")
	public List<String> displayBestEventsByParticipations(){
		return EventService.displayBestEventsByParticipations();
		}
	
}






