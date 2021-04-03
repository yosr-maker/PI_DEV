package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_Command")
public class Command implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "commandId")
	private int commandId;
	
	@Column(name="TotalPrice")
	private String totalPrice ;
	
	@Column(name="Status")
	private String statusBasket ;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	@OneToOne
	Payment payment ;
	
	@OneToOne
	@JoinColumn(name = "basketId")
	Basket basket;
	
	
	public int getCommandId() {
		return commandId;
	}
	public void setCommandId(int commandId) {
		this.commandId = commandId;
	}
	public String getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getStatusBasket() {
		return statusBasket;
	}
	public void setStatusBasket(String statusBasket) {
		this.statusBasket = statusBasket;
	}
	public Date getDateCommande() {
		return dateCommande;
	}
	public void setDateCommande(Date dateCommande) {
		this.dateCommande = dateCommande;
	}
	
	
	public Command() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((basket == null) ? 0 : basket.hashCode());
		result = prime * result + commandId;
		result = prime * result + ((dateCommande == null) ? 0 : dateCommande.hashCode());
		result = prime * result + ((payment == null) ? 0 : payment.hashCode());
		result = prime * result + ((statusBasket == null) ? 0 : statusBasket.hashCode());
		result = prime * result + ((totalPrice == null) ? 0 : totalPrice.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Command other = (Command) obj;
		if (basket == null) {
			if (other.basket != null)
				return false;
		} else if (!basket.equals(other.basket))
			return false;
		if (commandId != other.commandId)
			return false;
		if (dateCommande == null) {
			if (other.dateCommande != null)
				return false;
		} else if (!dateCommande.equals(other.dateCommande))
			return false;
		if (payment == null) {
			if (other.payment != null)
				return false;
		} else if (!payment.equals(other.payment))
			return false;
		if (statusBasket == null) {
			if (other.statusBasket != null)
				return false;
		} else if (!statusBasket.equals(other.statusBasket))
			return false;
		if (totalPrice == null) {
			if (other.totalPrice != null)
				return false;
		} else if (!totalPrice.equals(other.totalPrice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Command [commandId=" + commandId + ", totalPrice=" + totalPrice + ", statusBasket=" + statusBasket
				+ ", dateCommande=" + dateCommande + ", payment=" + payment + ", basket=" + basket + "]";
	}
	public Command(int commandId, String totalPrice, String statusBasket, Date dateCommande, Payment payment,
			Basket basket) {
		super();
		this.commandId = commandId;
		this.totalPrice = totalPrice;
		this.statusBasket = statusBasket;
		this.dateCommande = dateCommande;
		this.payment = payment;
		this.basket = basket;
	}
		
	

	
}

