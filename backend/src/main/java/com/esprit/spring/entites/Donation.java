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
@Table(name="DONATION")
	

public class Donation implements Serializable {

			
			private static final long serialVersionUID = 1L;
			@Id
			@GeneratedValue(strategy=GenerationType.IDENTITY)
			@Column(name = "idDonation")
			private Long idDonation; 
			@Column(name="Quantity_donation")
			private float quantityDonation;

			
			@OneToOne
			@JoinColumn(name = "paymentId")
			Payment payment;

			public Long getIdUser() {
				return idDonation;
			}


			public void setIdUser(Long idDonation) {
				this.idDonation = idDonation;
			}



			public float getQuantityDonation() {
				return quantityDonation;
			}


			public void setQuantityDonation(float quantityDonation) {
				this.quantityDonation = quantityDonation;
			}
			public Long getIdDonation() {
				return idDonation;
			}


			public void setIdDonation(Long idDonation) {
				this.idDonation = idDonation;
			}
			public Payment getPayment() {
				return payment;
			}


			public void setPayment(Payment payment) {
				this.payment = payment;
			}

			@Override
			public String toString() {
				return "Donation [idDonation=" + idDonation + ", quantityDonation=" + quantityDonation + ", payment=" + payment
						+ "]";
			}


			public Donation(Long idDonation, float quantityDonation, Payment payment) {
				super();
				this.idDonation = idDonation;
				this.quantityDonation = quantityDonation;
				this.payment = payment;
			}

			public Donation() {
				super();
				// TODO Auto-generated constructor stub
			}
		
}

