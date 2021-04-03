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
@Entity
@Table(name="T_STOCK")
public class Stock implements Serializable {

	
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
      private int idStock;
	
	@Column(name = "stockname")
	private String stockname;
	 
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
//	
//	private List<Product> products;


	
	
	
	
	
	
	
	
	
	
	
	public Stock() {
		super();
	}

	
	
	
	
	

	public Stock(int idStock, String stockname) {
	super();
	this.idStock = idStock;
	this.stockname = stockname;
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



	
	

//
//	public List<Product> getProducts() {
//		return products;
//	}
//
//
//	public void setProducts(List<Product> products) {
//		this.products = products;
//	}
	
	
	
	
	
	
	
	
	
	
	
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

	

	
	//List<Shalves> shalves;
	
//	
//	public Stock( int quantiteMin, int quantiteMax, int quantiteInstan) {
//		super();
//		this.quantiteMin = quantiteMin;
//		this.quantiteMax = quantiteMax;
//		this.quantiteInstan = quantiteInstan;
//	}
//
//	public Stock(int id,  int quantiteMin, int quantiteMax, int quantiteInstan) {
//		super();
//		this.id = id;
//		this.quantiteMin = quantiteMin;
//		this.quantiteMax = quantiteMax;
//		this.quantiteInstan = quantiteInstan;
//	}
//
//
//
//	public int getQuantiteMin() {
//		return quantiteMin;
//	}
//
//	public void setQuantiteMin(int quantiteMin) {
//		this.quantiteMin = quantiteMin;
//	}
//
//	public int getQuantiteMax() {
//		return quantiteMax;
//	}
//
//	public void setQuantiteMax(int quantiteMax) {
//		this.quantiteMax = quantiteMax;
//	}
//
//	public int getQuantiteInstan() {
//		return quantiteInstan;
//	}
//
//	public void setQuantiteInstan(int quantiteInstan) {
//		this.quantiteInstan = quantiteInstan;
//	}


//
//	public Stock() {
//		super();
//		// TODO Auto-generated constructor stub
//	}
//	
	
	
}


