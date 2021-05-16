package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="COMMAND_LINE")

public class Command_line implements Serializable{
	
private static final long serialVersionUID = 1L;
	
	@Id
	private Long id;

	@Column(name="quantity")
	private Long quantityPurchased;
	
	@OneToMany
	@JoinColumn(name = "basketId")
	private List<Basket> baskets;
	
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Product> products;
	
	@Column(name="prixToPay")
	private float prixToPay;

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public float getQuantityPurchased() {
		return quantityPurchased;
	}


	public void setQuantityPurchased(Long quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}


	public List<Basket> getBaskets() {
		return baskets;
	}


	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}


	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}


	public Command_line() {
		super();
		// TODO Auto-generated constructor stub
	}


	public float getPrixToPay() {
		return prixToPay;
	}


	public void setPrixToPay(float prixToPay) {
		this.prixToPay = prixToPay;
	}


	public Command_line(Long id, Long quantityPurchased, List<Basket> baskets, List<Product> products,
			float prixToPay) {
		super();
		this.id = id;
		this.quantityPurchased = quantityPurchased;
		this.baskets = baskets;
		this.products = products;
		this.prixToPay = prixToPay;
	}
	
	
}


	


	