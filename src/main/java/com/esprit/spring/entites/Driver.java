package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_Driver")
public class Driver implements Serializable {

	
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idDriver")
	private int idDriver;
	
	@Column(name="lastName")
	private String lastName; 

	@Column(name="firstName")
	private String firsttName; 
	
	@Column(name="Phone")
	private String Phone;
	

	@Column(name="emailDriver")
	private String emailDriver;
	
	@Column(name="Location")
	private String Location;

	@OneToOne(mappedBy="driver")
	private Delivery delivery;
	
	
	@ManyToMany
	private List <Automobile> automobiles ;
	
	
	public List<Automobile> getAutomobiles() {
		return automobiles;
	}

	public void setAutomobiles(List<Automobile> automobiles) {
		this.automobiles = automobiles;
	}

	public int getIdDriver() {
		return idDriver;
	}

	public void setIdDriver(int idDriver) {
		this.idDriver = idDriver;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getFirsttName() {
		return firsttName;
	}

	public void setFirsttName(String firsttName) {
		this.firsttName = firsttName;
	}

	public String getPhone() {
		return Phone;
	}

	public void setPhone(String phone) {
		Phone = phone;
	}

	public String getEmailDriver() {
		return emailDriver;
	}

	public void setEmailDriver(String emailDriver) {
		this.emailDriver = emailDriver;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}


	
	
	public Delivery getDelivery() {
		return delivery;
	}

	public void setDelivery(Delivery delivery) {
		this.delivery = delivery;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}


	
}
