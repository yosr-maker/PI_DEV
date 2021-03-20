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
import com.esprit.spring.entites.Event;

import com.esprit.spring.services.EventServiceI;

@RestController
public class EventController {


@Autowired
EventServiceI EventService;

@GetMapping("/retrieve-all-Events")
@ResponseBody
public List<Event> getEvents() {
List<Event> list = EventService.retrieveAllEvents();
return list;
}

@GetMapping("/retrieve-event/{event-id}")
@ResponseBody
public Event retrieveEvent(@PathVariable("event-id") String idEvent) {
return EventService.retrieveEvent(idEvent);
}

@PostMapping("/add-event")
@ResponseBody
public Event addEvent(@RequestBody Event e) {
	Event event = EventService.addEvent(e);
return event;
}

@DeleteMapping("/remove-event/{event-id}")
@ResponseBody
public void removeEvent(@PathVariable("event-id") String idEvent) {
	EventService.deleteEvent(idEvent);
}

@PutMapping("/modify-event")
@ResponseBody
public Event modifyEvent(@RequestBody Event e) {
return EventService.updateEvent(e);
}
}

