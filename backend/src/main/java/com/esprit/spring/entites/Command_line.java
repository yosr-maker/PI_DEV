package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;

import javax.persistence.Id;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="COMMAND_LINE")

public class Command_line implements Serializable{



	private static final long serialVersionUID = 1L;
	

	@Id
	private int id;

	@Column(name="quantity")
	private float quantityPurchased;
	
	@OneToMany
	@JoinColumn(name = "basketId")
	private List <Basket> baskets;
	
	
	@OneToMany
	@JoinColumn(name = "id")
	private List<Product> products;


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public float getQuantityPurchased() {
		return quantityPurchased;
	}


	public void setQuantityPurchased(float quantityPurchased) {
		this.quantityPurchased = quantityPurchased;
	}


	public List<Basket> getBaskets() {
		return baskets;
	}


	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}


	/*public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}*/


	public Command_line() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}


	


	