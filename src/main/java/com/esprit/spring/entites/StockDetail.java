package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;


@Entity
@Table(name="T_STOCK_DETAIL")
public class StockDetail implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2122553264089090117L;
	
	@Id
	private int idStockDetail;
	private int quantiteMin;
	private int quantiteMax;
	private int quantiteInstan;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date fabrication;
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	Date dexpiration;
	public int getIdStockDetail() {
		return idStockDetail;
		
		
		
		
		
		
		
		
		
		
	}
	public StockDetail() {
		super();
	}
	public StockDetail(int idStockDetail, int quantiteMin, int quantiteMax, int quantiteInstan, Date fabrication,
			Date dexpiration) {
		super();
		this.idStockDetail = idStockDetail;
		this.quantiteMin = quantiteMin;
		this.quantiteMax = quantiteMax;
		this.quantiteInstan = quantiteInstan;
		this.fabrication = fabrication;
		this.dexpiration = dexpiration;
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
