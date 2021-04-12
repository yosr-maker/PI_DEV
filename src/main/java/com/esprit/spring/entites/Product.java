
package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "T_Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@Column(name = "description")
	private String Description;

	@Column(name = "category")
	private String Category;

	@Column(name = "weight")
	private float weight;

	@Column(name = "price")
	private float Price;
	//@Column(name = "NbcomanLine")
	private int nbrcommanline;

	@ManyToMany
	List<Basket> baskets;

	@ManyToOne
	@JoinColumn(name = "idRay")
	Ray ray;

	@ManyToOne
	@JoinColumn(name = "idCommandLine", referencedColumnName = "id")
	private Command_line commandLine;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	private List<Claim> claims;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	List<Publication> publications;

	@OneToMany
	private List<Ad> ads;

	// @JsonIgnore
	@OneToOne
	private StockDetail stockDetail;

	public Product(int id) {
		super();
		this.id = id;
	}

	public Product() {
		super();
	}
	
	
	

	public Product(int id, String name, String description, String category, float weight, float price,
			int nbrcommanline, List<Basket> baskets, Ray ray, Command_line commandLine, List<Claim> claims,
			List<Publication> publications, List<Ad> ads, StockDetail stockDetail) {
		super();
		this.id = id;
		this.name = name;
		Description = description;
		Category = category;
		this.weight = weight;
		Price = price;
		this.nbrcommanline = nbrcommanline;
		this.baskets = baskets;
		this.ray = ray;
		this.commandLine = commandLine;
		this.claims = claims;
		this.publications = publications;
		this.ads = ads;
		this.stockDetail = stockDetail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		Price = price;
	}

	public int getNbrcommanline() {
		return nbrcommanline;
	}

	public void setNbrcommanline(int nbrcommanline) {
		this.nbrcommanline = nbrcommanline;
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

	public Command_line getCommandLine() {
		return commandLine;
	}

	public void setCommandLine(Command_line commandLine) {
		this.commandLine = commandLine;
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

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

	public StockDetail getStockDetail() {
		return stockDetail;
	}

	public void setStockDetail(StockDetail stockDetail) {
		this.stockDetail = stockDetail;
	}




}
