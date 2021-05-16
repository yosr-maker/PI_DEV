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
	private Long deliveryId;
	
	@Column
	float weight; 
	
	@Column
	float Lenght ; 
	
	@Column 
	float Width; 
	
	@Column 
	float longitude ;
	
	@Column
	float laltitude ;
	
	@Temporal(TemporalType.DATE)
	private Date dateDelivery;

	
	@OneToMany
	private List <Payment> payments;
	
	
	@ManyToOne
	@JoinColumn(name="idDriver",nullable = true)
	Driver driver;
	
	
	public float getWeight() {
		return weight;
	}
	public void setWeight(float weight) {
		this.weight = weight;
	}
	public float getLenght() {
		return Lenght;
	}
	public void setLenght(float lenght) {
		Lenght = lenght;
	}
	public float getWidth() {
		return Width;
	}
	public void setWidth(float width) {
		Width = width;
	}
	public float getLongitude() {
		return longitude;
	}
	public void setLongitude(float longitude) {
		this.longitude = longitude;
	}
	public float getLaltitude() {
		return laltitude;
	}
	public void setLaltitude(float laltitude) {
		this.laltitude = laltitude;
	}


	
	
	
	public Driver getDriver() {
		
		return driver;
	}
	public void setDriver(Driver driver) {
		this.driver = driver;
	}
	public List<Payment> getPayments() {
		return payments;
	}
	public void setPayments(List<Payment> payments) {
		this.payments = payments;
	}
	public Long getDeliveryId() {
		return deliveryId;
	}
	public void setDeliveryId(Long deliveryId) {
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
	public Delivery(Long deliveryId, float weight, float lenght, float width, float longitude, float laltitude,
			Date dateDelivery, List<Payment> payments, Driver driver) {
		super();
		this.deliveryId = deliveryId;
		this.weight = weight;
		Lenght = lenght;
		Width = width;
		this.longitude = longitude;
		this.laltitude = laltitude;
		this.dateDelivery = dateDelivery;
		this.payments = payments;
		this.driver = driver;
	}
	

}

