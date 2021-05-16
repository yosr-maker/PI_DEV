package com.esprit.spring.entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="T_BASKET")
public class Basket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "basketId")
	private Long basketId;

	@OneToOne
	@JoinColumn(name="visitor" ,nullable= true)
	private Visitor visitor;
	
	@OneToOne
	private Facture facture;
	
	 public Facture getFacture() {
		return facture;
	}




	public void setFacture(Facture facture) {
		this.facture = facture;
	}

	@ManyToOne
	 private Command_line commandLine;
	 
	
	@ManyToOne
	private Command Command; 
	
	@OneToOne
	@JoinColumn(name="client",nullable= true)
	private Client client;
	
	@Column(name = "prixTotal")
	private float prixTotal;
	
	@Column(name = "isValid")
	private boolean isValid;
	
	//private PaymentType typePaiement;
	@Column(name = "quantiteTotale")
	private int quantiteTotale;
	

	public float getPrixTotal() {
		return prixTotal;
	}




	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}




	public boolean isValid() {
		return isValid;
	}




	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}




	public int getQuantiteTotale() {
		return quantiteTotale;
	}




	public void setQuantiteTotale(int quantiteTotale) {
		this.quantiteTotale = quantiteTotale;
	}




	public Basket() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	


	public Long getBasketId() {
		return basketId;
	}

	public void setBasketId(Long basketId) {
		this.basketId = basketId;
	}

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}


	public Command_line getCommandLine() {
		return commandLine;
	}


	public void setCommandLine(Command_line commandLine) {
		this.commandLine = commandLine;
	}


	public Command getCommand() {
		return Command;
	}

	public void setCommand(Command command) {
		Command = command;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	} 
	





	
	
	

	
	
	
	
	
	
}
