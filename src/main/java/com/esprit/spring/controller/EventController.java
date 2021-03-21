package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import 	com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.ParticipationRepository;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.Participation;
import com.esprit.spring.entites.EventCategory;
import com.esprit.spring.services.ContributionService;
import com.esprit.spring.services.EventServiceI;
import com.esprit.spring.services.NotifactionService;
import com.esprit.spring.services.ParticipationService;

@RestController
public class EventController {
	@Autowired
	EventServiceI EventService;
	@Autowired
	EventRepository EventRepository;
	@Autowired
	NotifactionService NotifactionService;
	@Autowired
	ParticipationService ParticipationService;
	@Autowired
	ContributionService ContributionService;
	@Autowired
	ParticipationRepository ParticipationRepository;


@GetMapping("/retrieve-all-Events")
@ResponseBody
public List<Event> getEvents() {
List<Event> list = EventService.retrieveAllEvents();
return list;
}

//@GetMapping("/myId")
//public Long getMyId() {
	//return UserController.USERCONNECTED.getId();
	//}

@GetMapping("/retrieve-event/{event-id}")
@ResponseBody
public Event retrieveEvent(@PathVariable("event-id") String idEvent) {
return EventService.retrieveEvent(idEvent);
}

@GetMapping("/retrieve-Event-ByName/{name}")
public Event getEventByName(@PathVariable String name) {
	final Event e = EventService.findEventByName(name);
	return e;
	}


@GetMapping("/retrieve-Events-ByCategory/{category}")
public List<Event> findEventByCategory(@PathVariable EventCategory category) {
	List<Event> list = EventService.filterEvent(category);
	return list;
	}

@PostMapping("/add-event")
@ResponseBody
public Event addEvent(@RequestBody Event e) {
	Event event = EventService.addEvent(e);
	NotifactionService.notifyAllUser(e.getName(),e.getDescription());	
return event;
}

@DeleteMapping("/remove-event/{event-id}")
@ResponseBody
public void removeEvent(@PathVariable("event-id") String idEvent) {
	EventService.refundUsers(idEvent);	//refund contributions & participations prices to its users
	EventService.deleteEvent(idEvent);
}

@GetMapping("/retrieve-all-Participations")
public List<Participation> getParticipations(){
	return ParticipationService.participationsList();
}


@PutMapping("/modify-event")
@ResponseBody
public Event modifyEvent(@RequestBody Event e) {
return EventService.updateEvent(e);
}
}

