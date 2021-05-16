package com.esprit.spring.entites;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;


@Entity
public class Facture implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idFacture;
	
	
	@OneToOne
	private Basket basketDetail;
	
	private float fraisDeliv;

	public float getFraisDeliv() {
		return fraisDeliv;
	}

	public void setFraisDeliv(float fraisDeliv) {
		this.fraisDeliv = fraisDeliv;
	}

	
	public Long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(Long idFacture) {
		this.idFacture = idFacture;
	}

	public Basket getBasketDetail() {
		return basketDetail;
	}

	public void setBasketDetail(Basket basketDetail) {
		this.basketDetail = basketDetail;
	}

	public Facture() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Facture(Long idFacture, Basket basketDetail, float fraisDeliv) {
		super();
		this.idFacture = idFacture;
		this.basketDetail = basketDetail;
		this.fraisDeliv = fraisDeliv;
	}
	
	
	
	
}
