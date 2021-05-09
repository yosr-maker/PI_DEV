package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="PUBLICATION")

 

public class Publication  implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idPublication")
	private  Long idPublication;


	@OneToMany(mappedBy="publication")
	List<Comment> comments ; 

	@ManyToOne
	@JoinColumn(name = "id")
	private Product product;
	
	public Long getIdPublication() {
		return idPublication;
	}



	public void setIdPublication(Long idPublication) {
		this.idPublication = idPublication;
	}



	public List<Comment> getComments() {
		return comments;
	}



	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}



	public Product getProduct() {
		return product;
	}



	public void setProduct(Product product) {
		this.product = product;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comments == null) ? 0 : comments.hashCode());
		result = prime * result + ((idPublication == null) ? 0 : idPublication.hashCode());
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
		Publication other = (Publication) obj;
		if (comments == null) {
			if (other.comments != null)
				return false;
		} else if (!comments.equals(other.comments))
			return false;
		if (idPublication == null) {
			if (other.idPublication != null)
				return false;
		} else if (!idPublication.equals(other.idPublication))
			return false;
		if (product == null) {
			if (other.product != null)
				return false;
		} else if (!product.equals(other.product))
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Publication [idPublication=" + idPublication + ", comments=" + comments + ", product=" + product + "]";
	}



	public Publication(Long idPublication, List<Comment> comments, Product product) {
		super();
		this.idPublication = idPublication;
		this.comments = comments;
		this.product = product;
	}



	public Publication() {
		super();
		// TODO Auto-generated constructor stub
	}


}
