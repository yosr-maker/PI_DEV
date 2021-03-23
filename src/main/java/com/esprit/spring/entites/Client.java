package com.esprit.spring.entites;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_CLIENT")

public class Client extends UserAccount {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int donation;
	
	public int getDonation() {
		return donation;
	}


	public void setDonation(int donation) {
		this.donation = donation;
	}


	@OneToOne
	private Basket basket;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private List<Participation> participation;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private List<Notification> notification;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private List<Contribution> contribution;


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Basket getBasket() {
		return basket;
	}




	public void setBasket(Basket basket) {
		this.basket = basket;
	}

	@Override
	public String toString() {
		return "Client [basket=" + basket + "]";
	}
















	public Client(int cin, String firstName, String lastName, Date dateNaissance, boolean status, String email,
			String phoneNumber, String login, String password, Basket basket, List<Participation> participation,
			List<Notification> notification, List<Contribution> contribution) {
		super(cin, firstName, lastName, dateNaissance, status, email, phoneNumber, login, password);
		this.basket = basket;
		this.participation = participation;
		this.notification = notification;
		this.contribution = contribution;
	}

















	public List<Participation> getParticipation() {
		return participation;
	}


	public void setParticipation(List<Participation> participation) {
		this.participation = participation;
	}


	public List<Notification> getNotification() {
		return notification;
	}


	public void setNotification(List<Notification> notification) {
		this.notification = notification;
	}


	public List<Contribution> getContribution() {
		return contribution;
	}


	public void setContribution(List<Contribution> contribution) {
		this.contribution = contribution;
	}


	



}

