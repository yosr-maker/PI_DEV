
package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import com.sun.istack.NotNull;

@Entity
@Table(name="CLAIM")			
public class Claim 	implements Serializable {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idClaim")
	private Long idClaim;
	
	@Enumerated(EnumType.STRING)
    private ClaimDecision decision;
	
	@Temporal(TemporalType.DATE)
	private Date dateClaim;
	
	

	
	 @Column(name = "DESCRIPTION_TEXT")
	    @NotNull
	    private String descriptionText;
	 
	
	 @ManyToOne 
	 private Client client;
	 

	@ManyToOne
    @JoinColumn(name = "id")
	private Product product;

	
	public ClaimDecision getDecision() {
		return decision;
	}

	public void setDecision(ClaimDecision decision) {
		this.decision = decision;
	}

	public String getDescriptionText() {
		return descriptionText;
	}

	public void setDescriptionText(String descriptionText) {
		this.descriptionText = descriptionText;
	}



	


	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
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




	public Claim(Long idClaim, ClaimDecision decision, Date dateClaim,String descriptionText, Client client, Product product) {
		super();
		this.idClaim = idClaim;
		this.decision = decision;
		this.dateClaim = dateClaim;

		this.descriptionText = descriptionText;
		this.client = client;
		this.product = product;
	}



	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claim(Long idClaim, ClaimDecision decision, Date dateClaim, String descriptionText, Product product) {
		super();
		this.idClaim = idClaim;
		this.decision = decision;
		this.dateClaim = dateClaim;
		this.descriptionText = descriptionText;
		this.product = product;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateClaim == null) ? 0 : dateClaim.hashCode());
		result = prime * result + ((decision == null) ? 0 : decision.hashCode());
		result = prime * result + ((descriptionText == null) ? 0 : descriptionText.hashCode());
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
		if (dateClaim == null) {
			if (other.dateClaim != null)
				return false;
		} else if (!dateClaim.equals(other.dateClaim))
			return false;
		if (decision != other.decision)
			return false;
		if (descriptionText == null) {
			if (other.descriptionText != null)
				return false;
		} else if (!descriptionText.equals(other.descriptionText))
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
	
	
	
}

