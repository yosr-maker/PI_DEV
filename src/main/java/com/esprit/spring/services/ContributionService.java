package com.esprit.spring.services;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.controller.ClientController;
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
	EventService ES;
	@Autowired
	ClientService US;
	@Autowired
	JackpotService JS;
	@Autowired
	ClientRepository UR;
	@Autowired
	JackpotRepository JR;
	@Autowired
	ContributionRepository CR;
	@Autowired
	EventRepository ER ;
	

	
	/**********************************User**********************************/
	
	//Add contribution to a jackpot an event
	@Override
	public String Contribute(Long eid, float amount) {
		Contribution c = new Contribution();
		Event ev = ES.findbyId(eid);
		Client u = US.findbyid(ClientController.USERCONNECTED.getId());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		if(u.getMcompte()>=amount) {
			u.setMcompte(u.getMcompte()-amount);
			Jackpot j = JS.findJackpot(ev);
			j.setSum(j.getSum()+amount);
			ev.setMontant(ev.getMontant()+amount);
			c.setAmount(amount);
			c.setContributionDate(dateFormat.format(date));
			c.setEvent(ev);
			c.setClient(u);
			UR.save(u);
			JR.save(j);
			ER.save(ev);
			CR.save(c);
			return "Contribution has been added with success";
		} else{
			return "Sorry, your account balance is insufficient !! ";
		}
	}

	@Override
	public List<Contribution> contributionOfEvent(Event event) {
		List<Contribution> list = CR.contributionOfEvent(event);
		return list;
	}
	
	@Override
	public List<Contribution> myContributionHistory() {
		List<Contribution> list = CR.contributionOfUser(ClientController.USERCONNECTED);
		return list;
	}



}
