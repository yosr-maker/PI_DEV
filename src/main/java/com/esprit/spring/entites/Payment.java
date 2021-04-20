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
	private int paymentId;
	
	
	@Column(name="typeOfPayment")
	private String typeOfPayment ;
	
	
	@OneToOne(mappedBy="payment")
	@JoinColumn(name = "commandId")
	private Command Command;
	
	@OneToOne( mappedBy="payment")
	private Donation donations;
	
	@ManyToOne
	@JoinColumn(name="deliveryId")
	private Delivery deliverie;
	
	
	
	
	public Payment() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

