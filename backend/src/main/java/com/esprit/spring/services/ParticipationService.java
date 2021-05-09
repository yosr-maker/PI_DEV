package com.esprit.spring.services;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
	public String addParticipation(Long eid , Long clientId ) {
		Participation p = new Participation();
		Event e = EventService.findbyId(eid);
		Client c= ClientService.findbyid(clientId);
			System.err.println(c.getFirstName());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();	

			if( e.getPlacesNbr()>0 && c.getMcompte()>e.getTicketPrice())
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
		
		}
		return "désolé il n'y aura pas de place";
	
	}


	@Override
	public List<String> participationsList(int idEvent) {
		Event e =EventRepository.findById((long) idEvent).orElse(null);
		List<Participation> listparticipation=new ArrayList<Participation>();
		listparticipation=e.getParticipation();
		List<String> lnoms=new ArrayList<String>();
		for(Participation p:listparticipation)
		{
			lnoms.add("ID: "+p.getId()+"Price:" +p.getPrice()+" ");
		}
		
		return lnoms;
		}

	

}
