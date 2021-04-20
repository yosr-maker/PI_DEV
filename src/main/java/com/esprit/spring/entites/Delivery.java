package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="T_Delivery")
public class Delivery implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "deliveryId")
	private int deliveryId;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateDelivery;

	
	@OneToMany
	private List <Payment> payments;
	
	
	@ManyToOne
	@JoinColumn(name="idDriver")
	Driver driver;
	
	
	
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	public int getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(int deliveryId) {
		this.deliveryId = deliveryId;
	}
	public Date getDateDelivery() {
		return dateDelivery;
	}
	public void setDateDelivery(Date dateDelivery) {
		this.dateDelivery = dateDelivery;
	}

	
	public Delivery() {
		super();
		// TODO Auto-generated constructor stub
	}

}

