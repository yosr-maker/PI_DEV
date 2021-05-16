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
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.apache.logging.log4j.util.PerformanceSensitive;
import org.hibernate.annotations.Cascade;

import com.fasterxml.jackson.annotation.JsonIgnore;

import net.bytebuddy.dynamic.loading.ClassReloadingStrategy.Strategy;

@Entity
@Table(name = "T_Product")
public class Product implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	// @Column(name="Name")
	private String name;

	// @Column(name="Description")
	private String description;

	// @Column(name="Category")
	private String category;

	// @Column(name="price")
	private float Price;

	// @Column(name="Quantity")
	private float Quantity;

	private String image;

	@OneToOne(cascade = CascadeType.ALL, mappedBy = "product")
	@JsonIgnore
	private StockDetail stockdetail;

	@ManyToMany
	List<Basket> baskets;

	@ManyToOne
	@JoinColumn(name = "idRay")
	Ray ray;

	@ManyToOne
	private Command_line commandLine;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "product")
	@JsonIgnore
	private List<Claim> claims;

	@OneToMany
	private List<Ad> ads;

	public Product(int id, String name, String description, String category, float price, float Quantity, String image,
			StockDetail stockdetail, List<Basket> baskets, Ray ray, Command_line commandLine, List<Claim> claims,
			List<Ad> ads) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.category = category;
		this.Price = price;
		this.Quantity = Quantity;
		this.image = image;
		this.stockdetail = stockdetail;
		this.baskets = baskets;
		this.ray = ray;
		this.commandLine = commandLine;
		this.claims = claims;
		this.ads = ads;
	}

	public Product() {
		super();
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
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public float getPrice() {
		return Price;
	}

	public void setPrice(float price) {
		this.Price = price;
	}

	public float getQuantity() {
		return Quantity;
	}

	public void setQuantity(float quantity) {
		this.Quantity = quantity;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public StockDetail getStockdetail() {
		return stockdetail;
	}

	public void setStockdetail(StockDetail stockdetail) {
		this.stockdetail = stockdetail;
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

	public List<Ad> getAds() {
		return ads;
	}

	public void setAds(List<Ad> ads) {
		this.ads = ads;
	}

}
