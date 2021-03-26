package com.esprit.spring.entites;



import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_CLIENT")

public class Client extends User {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	
	@OneToMany(mappedBy="client")
	private List<Jackpot> jackpots;
	@OneToOne
	private Basket basket;




	public Client() {
		super();
		// TODO Auto-generated constructor stub
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
		return "Client [jackpots=" + jackpots + ", basket=" + basket + "]";
	}




	public Client(List<Jackpot> jackpots, Basket basket) {
		super();
		this.jackpots = jackpots;
		this.basket = basket;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result + ((jackpots == null) ? 0 : jackpots.hashCode());
		return result;
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		if (jackpots == null) {
			if (other.jackpots != null)
				return false;
		} else if (!jackpots.equals(other.jackpots))
			return false;
		return true;
	}
		




}

