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
@Table(name="T_STOCK")
public class Stock implements Serializable {

	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idStock")
	private int idStock;
	
	
	@Column(name = "quantiteMin")
	private int quantiteMin;
	
	@Column(name = "quantiteMax")
	private int quantiteMax;
	
	@Column(name = "quantiteInstan")
	private int quantiteInstan;



	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}

	@OneToOne(mappedBy="stock")
	@JoinColumn(name="id")
	private Product product;
	


	

	public int getQuantiteMin() {
		return quantiteMin;
	}

	public void setQuantiteMin(int quantiteMin) {
		this.quantiteMin = quantiteMin;
	}

	public int getQuantiteMax() {
		return quantiteMax;
	}

	public void setQuantiteMax(int quantiteMax) {
		this.quantiteMax = quantiteMax;
	}

	public int getQuantiteInstan() {
		return quantiteInstan;
	}

	public void setQuantiteInstan(int quantiteInstan) {
		this.quantiteInstan = quantiteInstan;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}


