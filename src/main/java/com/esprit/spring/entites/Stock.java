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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.ManyToAny;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
@Table(name="T_STOCK")
public class Stock implements Serializable {

	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
      private int idStock;
	
	//@Column(name = "stockname")
	private String stockname;
	
   
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private List<StockDetail> stockDeatail;


	
	

	
	
	
	public Stock(int idStock, String stockname, List<StockDetail> stockDeatail) {
		super();
		this.idStock = idStock;
		this.stockname = stockname;
		this.stockDeatail = stockDeatail;
	}


	public Stock() {
		super();
	}


	public int getIdStock() {
		return idStock;
	}


	public void setIdStock(int idStock) {
		this.idStock = idStock;
	}


	public String getStockname() {
		return stockname;
	}


	public void setStockname(String stockname) {
		this.stockname = stockname;
	}


	public List<StockDetail> getStockDeatail() {
		return stockDeatail;
	}


	public void setStockDeatail(List<StockDetail> stockDeatail) {
		this.stockDeatail = stockDeatail;
	}
	 
	

	
	
	
	
	
	
	
	
	
}


