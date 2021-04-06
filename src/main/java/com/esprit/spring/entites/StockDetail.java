package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name="T_STOCK_DETAIL")
public class StockDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2122553264089090117L;
	
	@Id
	
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int idStockDetail;
	private int quantiteMin;
	private int quantiteMax;
	private int quantiteInstan;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date fabrication;
	
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date dexpiration;
	
	
	
	//@JsonBackReference
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "produit_id", referencedColumnName = "id")
	private Product product;

    //@JsonIgnore
	//@JsonBackReference
	@ManyToOne
	@JoinColumn(name = "stock_id", referencedColumnName = "idStock")
	private Stock stock;
	
	
	
	
	
	
	

	

	public StockDetail() {
		super();
	}

	public StockDetail(int idStockDetail, int quantiteMin, int quantiteMax, int quantiteInstan, Date fabrication,
			Date dexpiration, Product product, Stock stock) {
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
	
	
	

	@Override
	public String toString() {
		return "StockDetail [idStockDetail=" + idStockDetail + ", quantiteMin=" + quantiteMin + ", quantiteMax="
				+ quantiteMax + ", quantiteInstan=" + quantiteInstan + ", fabrication=" + fabrication + ", dexpiration="
				+ dexpiration + ", product=" + product + ", stock=" + stock + "]";
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
