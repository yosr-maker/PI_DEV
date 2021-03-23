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
	EventServiceI ES;
	@Autowired
	EventRepository ER;
	@Autowired
	NotificationService NS;
	@Autowired
	ParticipationService PS;
	@Autowired
	ContributionService CS;
	@Autowired
	ParticipationRepository PR;
	
	/**********************************Admin**********************************/
	@PostMapping("/add-Event")
	@ResponseBody
	public void addEvent(@RequestBody Event ev) {
		ES.addEvent(ev);
		NS.notifyAllUser(ev.getName(),ev.getDescription());
	}
	
	@GetMapping("/retrieve-all-Events")
	public List<Event> getEvents(){
		List<Event> list = ES.eventsLists();
		return list;
	}
	
	//@GetMapping("/myId")
	//public Long getMyId() {
	//	return UserAccountController.USERCONNECTED.getId();
	//	}
	
	@GetMapping("/retrieve-Event-ById/{id}")
	public Event getEventById(@PathVariable Long id) {
		return ES.findbyId(id);
		}
	
	@GetMapping("/retrieve-Event-ByName/{name}")
	public Event getEventByName(@PathVariable String name) {
		final Event ev = ES.findEventByName(name);
		return ev;
		}
	
	@GetMapping("/retrieve-Events-ByCategory/{category}")
	public List<Event> findEventByCategory(@PathVariable EventCategory category) {
		List<Event> list = ES.filterEvent(category);
		return list;
		}
	
//	@GetMapping("/update-Event/{eid}")
//	@ResponseBody
//	public void updateEvent(@PathVariable Long eid) {
//	}
	
	@DeleteMapping("/delete-Event/{event-id}")
	@ResponseBody
	public void deleteEvent(@PathVariable("event-id") Long eventID) {
		ES.refundUsers(eventID);//refund contributions & participations prices to its users
		ES.deleteEvent(eventID);
	}
	
	@GetMapping("/retrieve-all-Participations")
	public List<Participation> getParticipations(){
		return PS.participationsList();
	}
	
	/**********************************User**********************************/
	@PostMapping("/add-Contribution/{eid}/{amount}")
	@ResponseBody
	public void Contribute(@PathVariable("eid") Long eid,@PathVariable("amount") float amount) {
		CS.Contribute(eid, amount);
	}
	
	@GetMapping("/retrieve-my-Contributions")
	public List<Contribution> myContributionsHistory(){
		return CS.myContributionHistory();
	}
	
	@RequestMapping("/add-Participation/{eid}")
	@ResponseBody
	public String addParticipation(@PathVariable("eid") Long eid) {
		return PS.addParticipation(eid);
	}
	
	@GetMapping("/retrieve-my-Participations")
	public List<Participation> getMyParticipations(){
		return PS.myParticipations();
	}
	
	@GetMapping("/retrieve-my-Notifications")
	public List<Notification> getMyNotifications(){
		return NS.myNotifications();
	}
	
	@GetMapping("/retrieve-upcoming-Events")
	public List<Event> upcomingEvents() {
		return ES.upcomingEvents();
	}
	
	@GetMapping("/retrieve-passed-Events")
	public List<Event> passedEvents() {
		return ES.passedEvents();
	}
	
	@GetMapping("/bestEventsByViews")
	public Map<Long, Integer> bestEventsByViews(){
		return ES.bestEventsByViews();
		}
	
	@GetMapping("/retrieveBestEventsByViews")
	public List<String> displayBestEventsByViews(){
		return ES.displayBestEventsByViews();
		}
	
	@GetMapping("/retrieveBestEventsByParticipations")
	public List<String> displayBestEventsByParticipations(){
		return ES.displayBestEventsByParticipations();
		}
	
}

	






