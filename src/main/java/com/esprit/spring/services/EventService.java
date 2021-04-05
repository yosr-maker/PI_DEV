package com.esprit.spring.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Claim;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.EventCategory;
import com.esprit.spring.entites.Jackpot;
import com.esprit.spring.entites.Notification;
import com.esprit.spring.entites.Participation;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.ContributionRepository;
import com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.JackpotRepository;
import com.esprit.spring.repository.NotificationRepository;
import com.esprit.spring.repository.ParticipationRepository;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.IncomingPhoneNumber;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.availablephonenumbercountry.Local;
import com.twilio.type.PhoneNumber;


@Service
public class EventService implements EventServiceI {
	@Autowired
	EventRepository EventRepository;
	@Autowired
	JackpotRepository JackpotRepository;
	@Autowired
	ParticipationRepository ParticipationRepository;
	@Autowired
	ClientRepository ClientRepository;
	@Autowired
	ContributionRepository ContributionRepository;
	@Autowired
	NotificationRepository NotificationRepository;
	
	 public static final String ACCOUNT_SID = "AC861e84eeadedd8f2915b9bda24eb1430";
	 public static final String AUTH_TOKEN = "e81dbb367c3bd962127796ed81e6db55";
	 public static final PhoneNumber PHONE_NUMBER = new PhoneNumber("+12179033359");
	
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
		NewEvent.setPoster(event.getPoster());
		NewEvent.setTicketPrice(event.getTicketPrice());
		NewEvent.setGoal(event.getGoal());
		NewEvent.setStatus(false);
		Jackpot j = new Jackpot();
		j.setSum(0);
		JackpotRepository.save(j);
		NewEvent.setJackpot(j);
		EventRepository.save(NewEvent);
	}

	@Override
	public List<Event> eventsLists() {
		return (List<Event>) EventRepository.findAll();
	}

	@Override
	public void updateEvent(Long eid) {
		Event ev = EventRepository.findById(eid).get();
		ev.setCategory(ev.getCategory());
		ev.setName(ev.getName());
		ev.setDescription(ev.getDescription());
		ev.setPlacesNbr(ev.getPlacesNbr());
		ev.setDate(ev.getDate());
		ev.setHour(ev.getHour());
		ev.setLocation(ev.getLocation());
		ev.setPoster(ev.getPoster());
		ev.setTicketPrice(ev.getTicketPrice());
		ev.setGoal(ev.getGoal());
		EventRepository.save(ev);
	}

	@Override
	public void deleteEvent(Long id) {
		EventRepository.deleteById(id);
	}

	@Override
	public Event findbyId(Long id) {
		return EventRepository.findById(id).get();
	}

	@Override
	public Event findEventByName(String name) {
		return EventRepository.findByName(name); 
	}

	@Override
	public List<Event> filterEvent(EventCategory category) {
		return EventRepository.filterByCategory(category);
	}

	@Override
	public List<Event> upcomingEvents() {
		List<Event> list= EventRepository.upcomingEvents();
		return list;
	}

	@Override
	public List<Event> passedEvents() {
		List<Event> list= EventRepository.passedEvents();
		return list;
	}

	@Override
	public void refundUsers(Long eid) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		
		Event ev = findbyId(eid);
		
		List<Participation> participationsOfEvent = ParticipationRepository.Participations(ev);
		
		for(Participation p : participationsOfEvent) {
			Client u = p.getClient();
			float montantRembourse = p.getPrice();
			ev.setMontant(ev.getMontant()-montantRembourse);
			u.setMcompte(u.getMcompte()+montantRembourse);
			ClientRepository.save(u);
			ParticipationRepository.deleteById(p.getId());
			EventRepository.save(ev);
			Notification n = new Notification();
			n.setClient(u);
			//n.setBody("Mr/Mdm "+u.getLastName()+" "+u.getFirstName()+""
			//		+ "Nous avons le regret de vous annoncer que l'événement "+ev.getName()+" vous souhaitez participer a été annulé pour certaines raisons."
			//		+ " C'est pourquoi, nous avons remboursé le prix de votre billet. En cas de problème, n'hésitez pas à nous contacter."
			//		+ " Merci.");
			n.setDate(dateFormat.format(date));
			n.setStatus("Pas encore vu");
			NotificationRepository.save(n);
			
				
		}	
		
		List<Contribution> contributionsOfEvent = ContributionRepository.contributionOfEvent(ev);
		
		for(Contribution c : contributionsOfEvent) {
			Client u = c.getClient();
			float montantRembourse = c.getAmount();
			ev.getJackpot().setSum(ev.getJackpot().getSum()-montantRembourse);
			ev.setMontant(ev.getMontant()-montantRembourse);
			u.setMcompte(u.getMcompte()+montantRembourse);
			Notification n = new Notification();
			n.setClient(u);
			n.setBody("Mr/Mdm "+u.getLastName()+" "+u.getFirstName()+""
				+ "Nous avons le regret de vous annoncer que l'événement "+ev.getName()+" vous souhaitez participer a été annulé pour certaines raisons."
					+ " C'est pourquoi, nous avons remboursé le prix de votre billet. En cas de problème, n'hésitez pas à nous contacter."
				+ " Merci.");
			n.setDate(dateFormat.format(date));
			n.setStatus("Pas encore vu");
			NotificationRepository.save(n);
			ClientRepository.save(u);
			ContributionRepository.deleteById(c.getId());
			EventRepository.save(ev);
		
			
			IncomingPhoneNumber number = buyNumber();
	        System.out.println(number.getPhoneNumber());

	        // Send a text message
	        Message message = Message.creator( ACCOUNT_SID,PHONE_NUMBER,number.getPhoneNumber(), "Mr/Mdm "+u.getLastName()+" "+u.getFirstName()+""
	     					+ "Nous avons le regret de vous annoncer que l'événement "+ev.getName()+" vous souhaitez participer a été annulé pour certaines raisons."
	     					+ " C'est pourquoi, nous avons remboursé le prix de votre billet. En cas de problème, n'hésitez pas à nous contacter."
	     					+ " Merci.").create();

	        System.out.println(message.getSid());
	        System.out.println(message.getBody());
	}
	}
		   private static IncomingPhoneNumber buyNumber() {
		        // Look up some phone numbers
		        Iterable<Local> numbers = Local.reader(ACCOUNT_SID, "US").read();

		        // Buy the first phone number
		        Iterator<Local> iter = numbers.iterator();
		        if (iter.hasNext()) {
		            Local local = iter.next();
		            return IncomingPhoneNumber.creator( ACCOUNT_SID,  local.getPhoneNumber()  ).create();
		        }

		        return null;
		    }
		

	@Override
	public Map<Long, Integer> bestEventsByViews() {
		
		Map<Long,Integer> h = new HashMap<>();
		List<Long> listId = new ArrayList<>();
		List<Integer> listViews= new ArrayList<>();
		List<Event> listEvent = EventRepository.findAll();
		
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
	public List<String> displayBestEventsByParticipations() {
		List<String> list = new ArrayList<>();
		String s = "";
		List<Long> listId = new ArrayList<>();
		List<Integer> listViews= new ArrayList<>();
		List<Event> listEvent = EventRepository.findAll();
		
		for (Event ev : listEvent) {
			listId.add(ev.getId());
			listViews.add(ev.getParticipantsNbr());
		}
		
		List<Integer> sortedList = new ArrayList<>(listViews);
		Collections.sort(sortedList);
		
		for (int i=0; i<3; i++) {
			int max = sortedList.get(sortedList.size()-1);// retourne le max qui a la dernière position de la liste
			Long ind = listId.get(listViews.indexOf(max));// prend nbre de participations et retourne id d'event corresspondant
			s = (i+1)+"- Event: "+EventRepository.findById(ind).get().getName()+" with "+max+" participations ";
			list.add(s);
			sortedList.remove(sortedList.size()-1);
			listViews.set(listViews.indexOf(max), -1);
		}
		
		return list;
	}

	





}

