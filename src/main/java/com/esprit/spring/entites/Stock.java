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
	
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
	private List<StockDetail> stockDeatail;
	 
	
//	@OneToMany(cascade = CascadeType.ALL, mappedBy="stock")
//	
//	private List<Product> products;

	
	
}


