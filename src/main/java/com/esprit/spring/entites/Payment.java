package com.esprit.spring.entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_Payment")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class Payment implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "paymentId")
	private Long paymentId;
	
	
	
	@Column(name="typeOfPayment")
	private String typeOfPayment ;
	
	
	@Column(name="facture")
	private Long facture ;
	
	@OneToOne(mappedBy="payment")
	@JoinColumn(name = "commandId",nullable=true)
	private Command Command;
	
	@OneToOne( mappedBy="payment")
	private Donation donations;
	
	@ManyToOne
	@JoinColumn(name="deliveryId",nullable=true)
	private Delivery deliverie;
	
	
	
	
	public String getTypeOfPayment() {
		return typeOfPayment;
	}




	public void setTypeOfPayment(String typeOfPayment) {
		this.typeOfPayment = typeOfPayment;
	}




	public Long getFacture() {
		return facture;
	}




	public void setFacture(Long facture) {
		this.facture = facture;
	}




	public Command getCommand() {
		return Command;
	}




	public void setCommand(Command command) {
		Command = command;
	}




	public Donation getDonations() {
		return donations;
	}




	public void setDonations(Donation donations) {
		this.donations = donations;
	}




	public Delivery getDeliverie() {
		return deliverie;
	}




	public void setDeliverie(Delivery deliverie) {
		this.deliverie = deliverie;
	}




	public Payment(Long paymentId, String typeOfPayment, Long facture, com.esprit.spring.entites.Command command,
			Donation donations, Delivery deliverie) {
		super();
		this.paymentId = paymentId;
		this.typeOfPayment = typeOfPayment;
		this.facture = facture;
		Command = command;
		this.donations = donations;
		this.deliverie = deliverie;
	}




	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

