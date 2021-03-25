/*package com.esprit.spring.services;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Participation;
import com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.ParticipationRepository;

@Service
public class ParticipationService implements ParticipationServiceI {
	
	//@Autowired
	//UserServiceImpl US;
	@Autowired
	EventService EventService;
	@Autowired
	ParticipationRepository ParticipationRepository;
	@Autowired
	EventRepository EventRepository;
	@Autowired
	ClientService ClientService;
	
	//@Autowired
	//UserRepository UR;
		// admin //
	public List<Participation> participationsList() {
		List<Participation> list= ParticipationRepository.findAll();
		return list;
	}

	
	//User//
	//@Override
	/*public String addParticipation(Long s) {
		Participation p = new Participation();
		Event e = EventService.findbyId(s);
		Client c = ClientService.findbyid(Client.getId());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		
		List<Participation> pl = ParticipationRepository.Participations(EventService.findbyId(s));
		for(Participation participation : pl) {
			if((participation.getClient()).equals(c)) {
				return "you have already participated";
			}
		}
		
		if(e.getPlacesNbr()>0 && c.getAccBalance()>e.getTicketPrice()) {
//			if((ev.getDate().equals(date))&&(date.getHours()-Integer.valueOf(ev.getHour().substring(0, 2))<=2)) {
				p.setEvent(e);
				p.setClient(c);
				p.setParticipationDate(dateFormat.format(date));
				p.setPrice(e.getTicketPrice());
				e.setPlacesNbr(e.getPlacesNbr()-1);
				e.setParticipantsNbr(e.getParticipantsNbr()+1);
				e.setCollAmount(e.getCollAmount()+e.getTicketPrice());
				c.setAccBalance(c.getAccBalance()-e.getTicketPrice());	
				ParticipationRepository.save(p);
				EventRepository.saveAndFlush(e);
				//ClientRepository.save(c);
				return "Participation successfully added. You're welcome.";
		}else {
			return "Sorry, there are no places available.";
		}
				
//			if(participationsList().size()<=1) { //Early bird ticket // 1 sera modifié par nombre de tickets des EarlyBirdTicket
//				float newPrice = (float) (ev.getTicketPrice()*0.8);// pourcentage de réduction en early bird ticket
//				p.setEvent(ev);
//				p.setUser(u);
//				p.setParticipationDate(dateFormat.format(date));
//				p.setPrice(newPrice);
//				ev.setPlacesNbr(ev.getPlacesNbr()-1);
//				ev.setParticipantsNbr(ev.getParticipantsNbr()+1);
//				ev.setCollAmount(ev.getCollAmount()+ev.getTicketPrice());
//				u.setAccBalance(u.getAccBalance()-newPrice);	
//				PR.save(p);
//				ER.saveAndFlush(ev);
//				UR.save(u);
//				return "you are among the first 20 participants, discount by 20%";
//			}
	
	}
*/
/*
	@Override
	public List<Participation> myParticipations() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public String addParticipation(Long s) {
		// TODO Auto-generated method stub
		return null;
	}

	//Retrieve my participations
	//@Override
//	public List<Participation> myParticipations() {
	//	List<Participation> list = ParticipationRepository.myParticipations(UserController.USERCONNECTED);
	//	return list;
//	}

}
*/