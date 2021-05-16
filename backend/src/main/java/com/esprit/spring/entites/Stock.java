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
	

	



	public List<StockDetail> getStockDetail() {
		return stockDetail;
	}






	public void setStockDetail(List<StockDetail> stockDetail) {
		this.stockDetail = stockDetail;
	}






	public Stock() {
		super();
	}






	@OneToMany
	private List<StockDetail> stockDetail;
	
	
	



	
	
	
}


