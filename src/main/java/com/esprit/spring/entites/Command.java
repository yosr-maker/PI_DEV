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
	private Long commandId;
	
	@Column(name="TotalPrice")
	private String totalPrice ;
	
	@Column(name="Status")
	private String statusBasket ;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateCommande;
	
	@OneToOne
	Payment payment ;
	
	@OneToOne
	@JoinColumn(name = "basketId",nullable=true)
	Basket basket;
	
	
	public Long getCommandId() {
		return commandId;
	}
	public void setCommandId(Long commandId) {
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
		
	

	
}

