package com.esprit.spring.entites;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="T_CLIENT")

public class Client extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int donation;
	@Column(name="mCompte")
	 private float mCompte;
	
	@OneToOne
	private Basket basket;

	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private List<Participation> participation;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private List<Notification> notification;
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	private List<Contribution> contribution;
	
	@OneToMany(cascade=CascadeType.ALL, mappedBy="client")
	@JsonIgnore
	private List<Claim> claims;

	public Client(int donation, Basket basket, List<Participation> participation, List<Notification> notification,
			List<Contribution> contribution, List<Claim> claims) {
		super();
		this.donation = donation;
		this.basket = basket;
		this.participation = participation;
		this.notification = notification;
		this.contribution = contribution;
		this.claims = claims;
	}


	public List<Claim> getClaims() {
		return claims;
	}


	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}


	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Client(int donation, Basket basket, List<Participation> participation, List<Notification> notification,
			List<Contribution> contribution) {
		super();
		this.donation = donation;
		this.basket = basket;
		this.participation = participation;
		this.notification = notification;
		this.contribution = contribution;
	}

	public int getDonation() {
		return donation;
	}


	public void setDonation(int donation) {
		this.donation = donation;
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



	public float getMcompte() {
		return mCompte;
	}

	public void setMcompte(float mcompte) {
		mCompte = mcompte;
	}

	

	



}

