package com.esprit.spring.entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_AUTOMOBILE")

public class Automobile implements Serializable {

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idAuto")
	private int idAuto;
	@Column(name="typeAuto")
	private String typeAuto; 
	
	@Column(name="Power")
	private String Power;
	
	@OneToOne
	@JoinColumn(name="idDriver")
	Driver driver ; 

	
	
	

	public Automobile() {
		super();
		// TODO Auto-generated constructor stub
	}





	public int getIdAuto() {
		return idAuto;
	}





	public void setIdAuto(int idAuto) {
		this.idAuto = idAuto;
	}





	public String getTypeAuto() {
		return typeAuto;
	}





	public void setTypeAuto(String typeAuto) {
		this.typeAuto = typeAuto;
	}





	public String getPower() {
		return Power;
	}





	public void setPower(String power) {
		Power = power;
	}





	public Driver getDriver() {
		return driver;
	}





	public void setDriver(Driver driver) {
		this.driver = driver;
	}

	
	
	

}
