package com.esprit.spring.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;
import com.esprit.spring.entites.Jackpot;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.ContributionRepository;
import com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.JackpotRepository;

@Service
public class ContributionService implements ContributionServiceI {
	@Autowired
	EventService EventService;
	@Autowired
	ClientService ClientService;
	@Autowired
	JackpotService JackpotService;
	@Autowired
	ClientRepository ClientRepository;
	@Autowired
	JackpotRepository JackpotRepository;
	@Autowired
	ContributionRepository ContributionRepository;
	@Autowired
	EventRepository EventRepository ;
	

	
	
	//Add contribution to a jackpot for an event
	@Override
	public String Contribute(Long eid,Long clientId ,float amount) {
		String s="";
		Contribution c = new Contribution();
		Event ev = EventService.findbyId(eid);
		Client u = ClientService.findbyid(clientId);	
		System.out.println(u.getMcompte());
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		
		java.util.Date date = new java.util.Date();
		System.out.println(date);
		if(u.getMcompte()>=amount) {
			u.setMcompte(u.getMcompte()-amount);
			Jackpot j = JackpotService.findJackpot(ev);
			j.setSum(j.getSum()+amount);
			ev.setMontant(ev.getMontant()+amount);
			c.setAmount(amount);
			c.setContributionDate(dateFormat.format(date));
			c.setEvent(ev);
			c.setClient(u);
			ClientRepository.save(u);
			JackpotRepository.save(j);
			EventRepository.save(ev);
			ContributionRepository.save(c);
			s= "La contribution a été ajoutée avec succès";
			
		} else {
			
			s="Désolé, le solde de votre compte est insuffisant !! ";
			System.out.println(s);
		}
		return s;
	}

	@Override
	public List<Contribution> contributionOfEvent(Event event) {
		List<Contribution> list = ContributionRepository.contributionOfEvent(event);
		return list;
	}
	
	@Override
	public List<Contribution> myContributionHistory(Client client) {
		List<Contribution> list = ContributionRepository.contributionOfClient(client);
		return list;
	}



}
