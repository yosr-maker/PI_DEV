package com.esprit.spring.services;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.spring.controller.ClientController;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.Participation;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.ParticipationRepository;


@Service
public class ParticipationService implements ParticipationServiceI {
	
	@Autowired
	ClientService ClientService;
	@Autowired
	EventService EventService;
	@Autowired
	ParticipationRepository ParticipationRepository;
	@Autowired
	EventRepository EventRepository;
	@Autowired
	ClientRepository ClientRepository;
	
	
		// admin //
	public List<Participation> participationsList() {
		List<Participation> list= ParticipationRepository.findAll();
		return list;
	}

	
	//User//
	@Override
	public String addParticipation(Long eid) {
		Participation p = new Participation();
		Event e = EventService.findbyId(eid);
		Client c = ClientService.findbyid(eid);
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();	
		List<Participation> pl = ParticipationRepository.Participations(EventService.findbyId(eid));
		for(Participation participation : pl) {
			if((participation.getClient()).equals(c)) {
			return "you have already participated";
			}
		}	
			if((e.getPlacesNbr()>0) && (c.getMcompte()>e.getTicketPrice()) )
			{
				p.setEvent(e);
				p.setClient(c);
				p.setParticipationDate(dateFormat.format(date));
				p.setPrice(e.getTicketPrice());
				e.setPlacesNbr(e.getPlacesNbr()-1);
				e.setParticipantsNbr(e.getParticipantsNbr()+1);
				e.setMontant(e.getMontant()+e.getTicketPrice());
				c.setMcompte(c.getMcompte()-e.getTicketPrice());	
				ParticipationRepository.save(p);
				EventRepository.saveAndFlush(e);
				ClientRepository.save(c);	
				
			
			return "la participation a été ajoutée avec succes. Bienvenue.";	
			 	
		}else {
		return "désolé il n'aura pas de place";
		}

	}
	//Retrieve my participations
	@Override
	public List<Participation> myParticipations() {
	List<Participation> list = ParticipationRepository.myParticipations((Client) ClientController.getId());
		return list;
	}
	
	

}
