package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;



import com.fasterxml.jackson.annotation.JsonFormat;



@Entity
public class StockDetail implements Serializable {
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idStockDetail;
	private int quantiteMin;
	private int quantiteMax;
	private int quantiteInstan;
	
	
	@JsonFormat(pattern="yyyy-MM-dd")
	Date fabrication;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	Date dexpiration;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produit_id", referencedColumnName = "id")
	private Product product;
	
	
	@ManyToOne
	@JoinColumn(name = "stock_id")
	private Stock stock;


	public StockDetail() {
		super();
	}


	public StockDetail( int idStockDetail, int quantiteMin, int quantiteMax, int quantiteInstan,
			Date fabrication, Date dexpiration, Product product, Stock stock) {
		super();
	
		this.idStockDetail = idStockDetail;
		this.quantiteMin = quantiteMin;
		this.quantiteMax = quantiteMax;
		this.quantiteInstan = quantiteInstan;
		this.fabrication = fabrication;
		this.dexpiration = dexpiration;
		this.product = product;
		this.stock = stock;
	}





	public int getIdStockDetail() {
		return idStockDetail;
	}


	public void setIdStockDetail(int idStockDetail) {
		this.idStockDetail = idStockDetail;
	}


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


	public Date getFabrication() {
		return fabrication;
	}


	public void setFabrication(Date fabrication) {
		this.fabrication = fabrication;
	}


	public Date getDexpiration() {
		return dexpiration;
	}


	public void setDexpiration(Date dexpiration) {
		this.dexpiration = dexpiration;
	}


	public Product getProduct() {
		return product;
	}


	public void setProduct(Product product) {
		this.product = product;
	}


	public Stock getStock() {
		return stock;
	}


	public void setStock(Stock stock) {
		this.stock = stock;
	}
	
	
	
	
	
	
	

}
