package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_Driver")
public class Driver implements Serializable {

	
	 
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idDriver")
	private Long idDriver;
	
	@Embedded
	private Shop shop1;
	
	@Column(name="lastName")
	private String lastName; 

	@Column(name="firstName")
	private String firsttName; 
	
	
	@Column(name="Phone")
	private String Phone;
	
	@Column(name="Salaire")
	private Long salaire;
	
	@Column(name="emailDriver")
	private String emailDriver;
	
	@Column(name="Location")
	private String Location;
	
	@Column(name="nbrDeliveryAffected")
	private Long nbrDeliveryAffected;

	@OneToMany(mappedBy="driver")
	private List<Delivery> deliveries;
	
	
	@ManyToMany
	private List<Automobile> automobiles ;
	
	public Shop getShop1() {
		return shop1;
	}

	public Driver(Long idDriver, Shop shop1, String lastName, String firsttName, String phone, Long salaire,
			String emailDriver, String location, Long nbrDeliveryAffected, List<Delivery> deliveries,
			List<Automobile> automobiles) {
		super();
		this.idDriver = idDriver;
		this.shop1 = shop1;
		this.lastName = lastName;
		this.firsttName = firsttName;
		Phone = phone;
		this.salaire = salaire;
		this.emailDriver = emailDriver;
		Location = location;
		this.nbrDeliveryAffected = nbrDeliveryAffected;
		this.deliveries = deliveries;
		this.automobiles = automobiles;
	}

	public void setShop1(Shop shop1) {
		this.shop1 = shop1;
	}

	
	
	public List<Automobile> getAutomobiles() {
		return automobiles;
	}

	public void setAutomobiles(List<Automobile> automobiles) {
		this.automobiles = automobiles;
	}

	public Long getIdDriver() {
		return idDriver;
	}

	public Driver(Shop shop1) {
		super();
		this.shop1 = shop1;
	}

	public void setIdDriver(Long idDriver) {
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


	
	public Long getSalaire() {
		return salaire;
	}

	public void setSalaire(Long salaire) {
		this.salaire = salaire;
	}

	public Long getNbrDeliveryAffected() {
		return nbrDeliveryAffected;
	}

	public void setNbrDeliveryAffected(Long nbrDeliveryAffected) {
		this.nbrDeliveryAffected = nbrDeliveryAffected;
	}

	public List<Delivery> getDeliveries() {
		return deliveries;
	}

	public void setDeliveries(List<Delivery> deliveries) {
		this.deliveries = deliveries;
	}

	public Driver() {
		super();
		// TODO Auto-generated constructor stub
	}

	/*public static Driver getMax(int nbrDA) {
		// TODO Auto-generated method stub
		return Driver.getMax(nbrDA);
	}*/

	

	
}
