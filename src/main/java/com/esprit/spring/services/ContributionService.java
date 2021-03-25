/*package com.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.controller.UserAccountController;

import com.esprit.spring.entites.Contribution;
import com.esprit.spring.entites.Event;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.ContributionRepository;
import com.esprit.spring.repository.EventRepository;
import com.esprit.spring.repository.JackpotRepository;

@Service
public class ContributionService implements ContributionServiceI {
	@Autowired
	EventService ES;
	@Autowired
	UserAccountService US;
	@Autowired
	JackpotService JS;
	@Autowired
	ClientRepository UR;
	@Autowired
	JackpotRepository JR;
	@Autowired
	ContributionRepository CR;
	@Autowired
	EventRepository ER;
	
	/**********************************User**********************************/
	
	//Add contribution to a jackpot an event
	/*@Override
	public String Contribute(Long eid, float amount) {
		Contribution c = new Contribution();
		Event ev = ES.findbyId(eid);
	//	UserAccount u = US.findbyid(UserAccountController.USERCONNECTED.getId());
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		java.util.Date date = new java.util.Date();
		if(u.getAccBalance()>=amount) {
			u.setAccBalance(u.getAccBalance()-amount);
			Jackpot j = JS.findJackpot(ev);
			j.setSum(j.getSum()+amount);
			ev.setCollAmount(ev.getCollAmount()+amount);
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
	*/
/*
	@Override
	public List<Contribution> contributionOfEvent(Event event) {
		List<Contribution> list = CR.contributionOfEvent(event);
		return list;
	}
	
	@Override
	public List<Contribution> myContributionHistory() {
		List<Contribution> list = CR.contributionOfUser(UserAccountController.USERCONNECTED);
		return list;
	}

	@Override
	public String Contribute(Long eid, float amount) {
		// TODO Auto-generated method stub
		return null;
	}


}
*/