package com.esprit.spring.entites;


import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@OneToMany(mappedBy="client")
	private List<Jackpot> jackpots;
	
	@OneToOne
	private Basket basket;




	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}




	public Client(int id, int cin, String firstName, String lastName, Date dateNaissance, boolean status, String email,
			String phoneNumber, String login, String password) {
		super(id, cin, firstName, lastName, dateNaissance, status, email, phoneNumber, login, password);
		// TODO Auto-generated constructor stub
	}




	public Client(int cin, String firstName, String lastName, Date dateNaissance, boolean status, String email,
			String phoneNumber, String login, String password) {
		super(cin, firstName, lastName, dateNaissance, status, email, phoneNumber, login, password);
		// TODO Auto-generated constructor stub
	}




	public Client(int cin, String firstName, String lastName, Date dateNaissance, boolean status, String email,
			String phoneNumber, String login, String password, Basket basket) {
		super(cin, firstName, lastName, dateNaissance, status, email, phoneNumber, login, password);
		this.basket = basket;
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
	
	
	

	

	


}

