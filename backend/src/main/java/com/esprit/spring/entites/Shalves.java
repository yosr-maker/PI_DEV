package com.esprit.spring.entites;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="T_SHALVES")

public class Shalves implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "shalvesId")
	private int shalvesId;
	
	@Column(name="typeShalves")
	private String typeShalves ;

	@ManyToOne
	@JoinColumn(name = "idStock")
	Stock stock;
	
	public int getShalvesyId() {
		return shalvesId;
	}
	public void setShalvesyId(int shalvesyId) {
		this.shalvesId = shalvesyId;
	}
	public String getTypeShalves() {
		return typeShalves;
	}
	public void setTypeShalves(String typeShalves) {
		this.typeShalves = typeShalves;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + shalvesId;
		result = prime * result + ((stock == null) ? 0 : stock.hashCode());
		result = prime * result + ((typeShalves == null) ? 0 : typeShalves.hashCode());
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
		Shalves other = (Shalves) obj;
		if (shalvesId != other.shalvesId)
			return false;
		if (stock == null) {
			if (other.stock != null)
				return false;
		} else if (!stock.equals(other.stock))
			return false;
		if (typeShalves == null) {
			if (other.typeShalves != null)
				return false;
		} else if (!typeShalves.equals(other.typeShalves))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Shalves [shalvesyId=" + shalvesId + ", typeShalves=" + typeShalves + ", stock=" + stock + "]";
	}
	public Shalves(int shalvesyId, String typeShalves, Stock stock) {
		super();
		this.shalvesId = shalvesyId;
		this.typeShalves = typeShalves;
		this.stock = stock;
	}
	public Shalves() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
