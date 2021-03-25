package com.esprit.spring.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;
import com.esprit.spring.entites.Jackpot;
import com.esprit.spring.entites.Notification;
import com.esprit.spring.entites.Participation;
import com.esprit.spring.repository.ContributionRepository;
import com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.JackpotRepository;
import com.esprit.spring.repository.NotificationRepository;
import com.esprit.spring.repository.ParticipationRepository;
import com.esprit.spring.repository.UserRepository;


@Service
public class EventService implements EventServiceI {
	@Autowired
	EventRepository ER;
	@Autowired
	JackpotRepository JR;
	@Autowired
	ParticipationRepository PR;
	@Autowired
	UserRepository UR;
	@Autowired
	ContributionRepository CR;
	@Autowired
	NotificationRepository NR;
	

	/**********************************Admin**********************************/
 @Override
	public void addEvent(Event event) {
		Event NewEvent = new Event();
		NewEvent.setCategory(event.getCategory());
		NewEvent.setName(event.getName());
		NewEvent.setDescription(event.getDescription());
		NewEvent.setPlacesNbr(event.getPlacesNbr());
		NewEvent.setParticipantsNbr(0);
		NewEvent.setMontant(0);
		NewEvent.setDate(event.getDate());
		NewEvent.setHour(event.getHour());
		NewEvent.setLocation(event.getLocation());
		
//		File file = new File(event.getPoster());
//		String img = ServletUriComponentsBuilder.fromCurrentContextPath()
//				.path("/files/download/")
//				.path(event.getPoster())
//				.toUriString();
		
		NewEvent.setPoster(event.getPoster());
		NewEvent.setTicketPrice(event.getTicketPrice());
		NewEvent.setStatus(false);
		Jackpot j = new Jackpot();
		j.setSum(0);
		JR.save(j);
		NewEvent.setJackpot(j);
		ER.save(NewEvent);
	}

	@Override
	public List<Event> eventsLists() {
		return (List<Event>) ER.findAll();
	}

	@Override
	public void updateEvent(Long eid) {
		Event ev = ER.findById(eid).get();
		ev.setCategory(ev.getCategory());
		ev.setName(ev.getName());
		ev.setDescription(ev.getDescription());
		ev.setPlacesNbr(ev.getPlacesNbr());
		ev.setDate(ev.getDate());
		ev.setHour(ev.getHour());
		ev.setLocation(ev.getLocation());
		ev.setPoster(ev.getPoster());
		ev.setTicketPrice(ev.getTicketPrice());
		ER.save(ev);
	}

	@Override
	public void deleteEvent(Long id) {
		ER.deleteById(id);
	}

	@Override
	public Event findbyId(Long id) {
		return ER.findById(id).get();
	}

	@Override
	public Event findEventByName(String name) {
		return ER.findByName(name); 
	}

	@Override
	public List<Event> filterEvent(EventCategory category) {
		return ER.filterByCategory(category);
	}

	@Override
	public List<Event> upcomingEvents() {
		List<Event> list= ER.upcomingEvents();
		return list;
	}

	@Override
	public List<Event> passedEvents() {
		List<Event> list= ER.passedEvents();
		return list;
	}

	@Override
	public void refundUsers(Long eid) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		
		Event ev = findbyId(eid);
		
		List<Participation> participationsOfEvent = PR.Participations(ev);
		
		for(Participation p : participationsOfEvent) {
			Client u = p.getClient();
			float montantRembourse = p.getPrice();
			ev.setMontant(ev.getMontant()-montantRembourse);
			u.setMcompte(u.getMcompte()+montantRembourse);
			UR.save(u);
			PR.deleteById(p.getId());
			ER.save(ev);
			Notification n = new Notification();
			n.setClient(u);
			n.setBody("Dear "+u.getLastName()+" "+u.getFirstName()+""
					+ ",we regret to announce that the event "+ev.getName()+" you want to attend has been canceled for a some reasons."
					+ " That's why, we have refunded your ticket price. If there is a problem, do not hesitate to contact us."
					+ " Thank you.");
			n.setDate(dateFormat.format(date));
			n.setStatus("Not Seen Yet");
			NR.save(n);
				
		}	
		
		List<Contribution> contributionsOfEvent = CR.contributionOfEvent(ev);
		
		for(Contribution c : contributionsOfEvent) {
			Client u = c.getClient();
			float montantRembourse = c.getAmount();
			ev.getJackpot().setSum(ev.getJackpot().getSum()-montantRembourse);
			ev.setMontant(ev.getMontant()-montantRembourse);
			u.setMcompte(u.getMcompte()+montantRembourse);
			Notification n = new Notification();
			n.setClient(u);
			n.setBody("Dear "+u.getLastName()+" "+u.getFirstName()+""
					+ ",we regret to announce that the event "+ev.getName()+" to which you contributed was canceled for several reasons."
					+ " That's why, we have refunded your contribution. If there is a problem, do not hesitate to contact us."
					+ " Thank you.");
			n.setDate(dateFormat.format(date));
			n.setStatus("Not Seen Yet");
			NR.save(n);
			UR.save(u);
			CR.deleteById(c.getId());
			ER.save(ev);
		}
	}

	@Override
	public Map<Long, Integer> bestEventsByViews() {
		
		Map<Long,Integer> h = new HashMap<>();
		List<Long> listId = new ArrayList<>();
		List<Integer> listViews= new ArrayList<>();
		List<Event> listEvent = ER.findAll();
		
		for (Event ev : listEvent) {
			listId.add(ev.getId());
			listViews.add(ev.getViews());
		}
		
		List<Integer> sortedList = new ArrayList<>(listViews);
		Collections.sort(sortedList);
		
		for (int i=0; i<3; i++) {
			int max = sortedList.get(sortedList.size()-1);// retourne le max qui a la dernière position de la liste
			Long ind = listId.get(listViews.indexOf(max));// prend nbre de vue et retourne id d'event corresspondant
			h.put(ind, max);
			System.out.println(ind +" "+ max);
			sortedList.remove(sortedList.size()-1);
			listViews.set(listViews.indexOf(max), -1);
		}
		
		return h;
	}

	@Override
	public List<String> displayBestEventsByViews() {
		List<String> list = new ArrayList<>();
		String s = "";
		List<Long> listId = new ArrayList<>();
		List<Integer> listViews= new ArrayList<>();
		List<Event> listEvent = ER.findAll();
		
		for (Event ev : listEvent) {
			listId.add(ev.getId());
			listViews.add(ev.getViews());
		}
		
		List<Integer> sortedList = new ArrayList<>(listViews);
		Collections.sort(sortedList);
		
		for (int i=0; i<3; i++) {
			int max = sortedList.get(sortedList.size()-1);// retourne le max qui a la dernière position de la liste
			Long ind = listId.get(listViews.indexOf(max));// prend nbre de vue et retourne id d'event corresspondant
			s = (i+1)+"- Event: "+ER.findById(ind).get().getName()+" with "+max+" views ";
			list.add(s);
			sortedList.remove(sortedList.size()-1);
			listViews.set(listViews.indexOf(max), -1);
		}
		
		return list;
	}

	@Override
	public List<String> displayBestEventsByParticipations() {
		List<String> list = new ArrayList<>();
		String s = "";
		List<Long> listId = new ArrayList<>();
		List<Integer> listViews= new ArrayList<>();
		List<Event> listEvent = ER.findAll();
		
		for (Event ev : listEvent) {
			listId.add(ev.getId());
			listViews.add(ev.getParticipantsNbr());
		}
		
		List<Integer> sortedList = new ArrayList<>(listViews);
		Collections.sort(sortedList);
		
		for (int i=0; i<3; i++) {
			int max = sortedList.get(sortedList.size()-1);// retourne le max qui a la dernière position de la liste
			Long ind = listId.get(listViews.indexOf(max));// prend nbre de participations et retourne id d'event corresspondant
			s = (i+1)+"- Event: "+ER.findById(ind).get().getName()+" with "+max+" participations ";
			list.add(s);
			sortedList.remove(sortedList.size()-1);
			listViews.set(listViews.indexOf(max), -1);
		}
		
		return list;
	}

	





}

