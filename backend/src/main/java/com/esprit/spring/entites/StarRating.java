package com.esprit.spring.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="STARRATING")
	

public class StarRating implements Serializable{

	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idStar")
	private  Long idStar;
	
	
	public Long getIdStar() {
		return idStar;
	}
	public void setIdStar(Long idStar) {
		this.idStar = idStar;
	}
	
	@OneToOne(mappedBy="starrating")
    @JoinColumn(name = "commentId", referencedColumnName = "idStar", insertable=false, updatable=false)
	private Comment comment;

		
	
		public StarRating(Long idStar, Comment comment) {
		super();
		this.idStar = idStar;
		this.comment = comment;
	}
		@Override
	public String toString() {
		return "StarRating [idStar=" + idStar + ", comment=" + comment + "]";
	}
		@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((comment == null) ? 0 : comment.hashCode());
		result = prime * result + ((idStar == null) ? 0 : idStar.hashCode());
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
		StarRating other = (StarRating) obj;
		if (comment == null) {
			if (other.comment != null)
				return false;
		} else if (!comment.equals(other.comment))
			return false;
		if (idStar == null) {
			if (other.idStar != null)
				return false;
		} else if (!idStar.equals(other.idStar))
			return false;
		return true;
	}
		public StarRating() {
			super();
			// TODO Auto-generated constructor stub
		}
	
		
}


