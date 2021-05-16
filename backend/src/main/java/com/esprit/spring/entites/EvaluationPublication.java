package com.esprit.spring.entites;

import java.io.Serializable;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


//

@Entity
@Table(name="T_EvaluationPublication")
public class EvaluationPublication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	 private int nbr;
	
	
	
	@JsonIgnore 
    @ManyToOne
    private Publication publication;



	
	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public int getNbr() {
		return nbr;
	}




	public void setNbr(int nbr) {
		this.nbr = nbr;
	}




	public Publication getPublication() {
		return publication;
	}




	public void setPublication(Publication publication) {
		this.publication = publication;
	}




	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + nbr;
		result = prime * result + ((publication == null) ? 0 : publication.hashCode());
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
		EvaluationPublication other = (EvaluationPublication) obj;
		if (id != other.id)
			return false;
		if (nbr != other.nbr)
			return false;
		if (publication == null) {
			if (other.publication != null)
				return false;
		} else if (!publication.equals(other.publication))
			return false;
		return true;
	}




	@Override
	public String toString() {
		return "EvaluationPublication [id=" + id + ", nbr=" + nbr + ", publication=" + publication + "]";
	}




	public EvaluationPublication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
