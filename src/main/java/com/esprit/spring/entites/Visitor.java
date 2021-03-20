package com.esprit.spring.entites;

import java.io.Serializable;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="T_VISITOR")

public  class Visitor implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idVisitor")
	private int idVisitor;
	
	
	
	@OneToOne(mappedBy="visitor")
	private Basket basket;
	
	public int getIdVisitor() {
		return idVisitor;
	}
	public void setIdVisitor(int idVisitor) {
		this.idVisitor = idVisitor;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + idVisitor;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visitor other = (Visitor) obj;
		if (idVisitor != other.idVisitor)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Visitor [idVisitor=" + idVisitor + "]";
	}
	public Visitor(int idVisitor) {
		super();
		this.idVisitor = idVisitor;
	}
	public Visitor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	
	
}
