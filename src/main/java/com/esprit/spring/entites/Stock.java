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
	
	
	@Column(name = "quantiteMin")
	private int quantiteMin;
	
	@Column(name = "quantiteMax")
	private int quantiteMax;
	
	@Column(name = "quantiteInstan")
	private Long quantiteInstan;



	
	@OneToOne(mappedBy="stock")
	@JoinColumn(name="id")
	private Product product;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	List<Shalves> shalves;

	public int getIdStock() {
		return idStock;
	}

	public void setIdStock(int idStock) {
		this.idStock = idStock;
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

	public Long getQuantiteInstan() {
		return quantiteInstan;
	}

	public void setQuantiteInstan(Long quantiteInstan) {
		this.quantiteInstan = quantiteInstan;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public List<Shalves> getShalves() {
		return shalves;
	}

	public void setShalves(List<Shalves> shalves) {
		this.shalves = shalves;
	}

	public Stock() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}


