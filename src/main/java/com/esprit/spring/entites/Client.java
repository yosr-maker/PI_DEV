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

public class Client extends User_account {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	 private float accBalance;


	@OneToMany(mappedBy="client")
	private List<Jackpot> jackpots;
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


	public Client(int cin, String firstName, String lastName, Date dateNaissance, boolean status, String email,
			String phoneNumber, String login, String password, float accBalance, List<Jackpot> jackpots,
			Basket basket) {
		super(cin, firstName, lastName, dateNaissance, status, email, phoneNumber, login, password);
		this.accBalance = accBalance;
		this.jackpots = jackpots;
		this.basket = basket;
	}








	public List<Jackpot> getJackpots() {
		return jackpots;
	}








	public void setJackpots(List<Jackpot> jackpots) {
		this.jackpots = jackpots;
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

	public float getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(float accBalance) {
		this.accBalance = accBalance;
	}
	
	
	

	

	


}

