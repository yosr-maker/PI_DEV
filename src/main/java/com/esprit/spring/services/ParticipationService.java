package com.esprit.spring.services;

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
	//@Autowired
	//UserRepository UR;
		// admin //
	public List<Participation> participationsList() {
		List<Participation> list= ParticipationRepository.findAll();
		return list;
	}

	
	//User//
	//@Override
	//public String addParticipation(Long s) {
	//	Participation p = new Participation();
	//	Event e = EventService.findbyId(s);
		//User u = US.findbyid(UserController.USERCONNECTED.getId());
		
	//	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	//	java.util.Date date = new java.util.Date();
	//	@Override
	//	public String addParticipation(Long eid) {
			// TODO Auto-generated method stub
	//		return null;
	//	}
		
		//List<Participation> pl = ParticipationRepository.Participations(EventService.findbyId(s));
		//for(Participation participation : pl) {
		//	if((participation.getUser()).equals(u)) {
			//	return "you have already participated";
		//}
		//}
		
		//if(e.getPlacesNbr()>0 && u.getAccBalance()>e.getTicketPrice()) {
//			if((ev.getDate().equals(date))&&(date.getHours()-Integer.valueOf(ev.getHour().substring(0, 2))<=2)) {
		//	p.setEvent(ev);
		//	p.setUser(u);
				//	p.setParticipationDate(dateFormat.format(date));
		//	p.setPrice(ev.getTicketPrice());
		//	ev.setPlacesNbr(ev.getPlacesNbr()-1);
				//	ev.setParticipantsNbr(ev.getParticipantsNbr()+1);
		//	ev.setCollAmount(ev.getCollAmount()+ev.getTicketPrice());
//	u.setAccBalance(u.getAccBalance()-ev.getTicketPrice());	
				//	PR.save(p);
				//	ER.saveAndFlush(ev);
				//	UR.save(u);
				
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
		//	return "Participation successfully added. You're welcome.";
	//	}else {
	//		return "Sorry, there are no places available.";
	//	}
	
	//}

	//Retrieve my participations
	//@Override
//	public List<Participation> myParticipations() {
	//	List<Participation> list = ParticipationRepository.myParticipations(UserController.USERCONNECTED);
	//	return list;
//	}
	public String addParticipation(Long eid) {
		// TODO Auto-generated method stub
		return null;
	}
}

