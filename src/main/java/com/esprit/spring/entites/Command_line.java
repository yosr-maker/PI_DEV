package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Column(name="quantity")
	private int quantityPurchased;
	
	@OneToMany
	@JoinColumn(name = "basketId")
	private List <Basket> baskets;
	
	@JsonIgnore
	@OneToMany(mappedBy="commandLine")
	private List<Product> products;
	
	
	
	


	public Command_line(int id, int quantityPurchased, List<Basket> baskets, List<Product> products) {
		super();
		this.id = id;
		this.quantityPurchased = quantityPurchased;
		this.baskets = baskets;
		this.products = products;
	}


	public Command_line() {
		super();
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public int getQuantityPurchased() {
		return quantityPurchased;
	}


	public void setQuantityPurchased(int quantityPurchased) {
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


	
	
	
}


	


	