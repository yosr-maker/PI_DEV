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

@Entity
@Table(name="T_BASKET")
public class Basket implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "basketId")
	private int basketId;

	@OneToOne
	@JoinColumn(name="visitor")
	private Visitor visitor;
	
	
	 @ManyToOne
	 private Command_line commandLine;
	 
	
	@ManyToOne
	private Command Command; 
	
	@OneToOne
	@JoinColumn(name="client")
	private Client client;

	public Basket() {
		super();
		// TODO Auto-generated constructor stub
	}


	public int getBasketId() {
		return basketId;
	}

	public void setBasketId(int basketId) {
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
