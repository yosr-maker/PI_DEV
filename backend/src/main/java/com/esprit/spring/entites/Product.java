package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table( name = "T_Product")
public class Product implements Serializable {


	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	@Column(name="Name")
	private String Name ; 
	
	@Column(name="Description")
	private String Description ;
	
	@Column(name="Category")
	private String Category; 
	
	@Column(name="Weight")
	private float weight;
	
	@Column(name="Quantity")
	private float Quantity;
	

		
	@Column(name="price")
	private float Price;
	

	
	@ManyToMany
	List<Basket> baskets;
	
	@ManyToOne
	@JoinColumn(name = "idRay")
	Ray ray;
	
   @ManyToOne
   private Command_line commandLine;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	@JsonIgnore
	private List<Claim> claims;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="product")
	List<Publication> publications;
	
	@ManyToOne
	@JoinColumn(name = "idStock")
	Stock stock;
	
	@OneToMany
	private List<Ad> ads;


	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public String getCategory() {
		return Category;
	}

	public void setCategory(String category) {
		Category = category;
	}

	public float getWeight() {
		return weight;
	}

	public void setWeight(float weight) {
		this.weight = weight;
	}

	public float getQuantity() {
		return Quantity;
	}

	public void setQuantity(float quantity) {
		Quantity = quantity;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public List<Basket> getBaskets() {
		return baskets;
	}

	public void setBaskets(List<Basket> baskets) {
		this.baskets = baskets;
	}

	public Ray getRay() {
		return ray;
	}

	public void setRay(Ray ray) {
		this.ray = ray;
	}

	public List<Claim> getClaims() {
		return claims;
	}

	public void setClaims(List<Claim> claims) {
		this.claims = claims;
	}

	public List<Publication> getPublications() {
		return publications;
	}

	public void setPublications(List<Publication> publications) {
		this.publications = publications;
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Command_line getCommandLine() {
		return commandLine;
	}

	public void setCommandLine(Command_line commandLine) {
		this.commandLine = commandLine;
	}

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}



	public Product(long id, String name, String description, String category, float weight, float quantity, float price,
			List<Basket> baskets, Ray ray, Command_line commandLine, List<Claim> claims, List<Publication> publications,
			Stock stock, List<Ad> ads) {
		super();
		this.id = id;
		Name = name;
		Description = description;
		Category = category;
		this.weight = weight;
		Quantity = quantity;
		Price = price;
		this.baskets = baskets;
		this.ray = ray;
		this.commandLine = commandLine;
		this.claims = claims;
		this.publications = publications;
		this.stock = stock;
		this.ads = ads;
	}


	
	
}

