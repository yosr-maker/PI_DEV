
package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="CLAIM")			
public class Claim 	implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idClaim")
	private Long idClaim;
	
	
	@Temporal(TemporalType.DATE)
	private Date dateClaim;
	
	@Column(name="Decision")
	private String Decision;
	
	@ManyToOne
    @JoinColumn(name = "id")
	private Product product;

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Decision == null) ? 0 : Decision.hashCode());
		result = prime * result + ((dateClaim == null) ? 0 : dateClaim.hashCode());
		result = prime * result + ((idClaim == null) ? 0 : idClaim.hashCode());
		result = prime * result + ((product == null) ? 0 : product.hashCode());
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
		Claim other = (Claim) obj;
		if (Decision == null) {
			if (other.Decision != null)
				return false;
		} else if (!Decision.equals(other.Decision))
			return false;
		if (dateClaim == null) {
			if (other.dateClaim != null)
				return false;
		} else if (!dateClaim.equals(other.dateClaim))
			return false;
		if (idClaim == null) {
			if (other.idClaim != null)
				return false;
		} else if (!idClaim.equals(other.idClaim))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public Long getIdClaim() {
		return idClaim;
	}

	public void setIdClaim(Long idClaim) {
		this.idClaim = idClaim;
	}

	public Date getDateClaim() {
		return dateClaim;
	}

	public void setDateClaim(Date dateClaim) {
		this.dateClaim = dateClaim;
	}

	public String getDecision() {
		return Decision;
	}

	public void setDecision(String decision) {
		Decision = decision;
	}

	@Override
	public String toString() {
		return "Claim [idClaim=" + idClaim + ", dateClaim=" + dateClaim + ", Decision=" + Decision + ", product="
				+ product + "]";
	}

	public Claim(Long idClaim, Date dateClaim, String decision, Product product) {
		super();
		this.idClaim = idClaim;
		this.dateClaim = dateClaim;
		Decision = decision;
		this.product = product;
	}

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}

