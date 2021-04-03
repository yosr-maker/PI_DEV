package com.esprit.spring.entites;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;




@Entity
@Table(name="T_EvaluationPublication")
public class EvaluationPublication implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column
	private long id;
	
	@Column
	 private int value;
	
	
	
	//@JsonIgnore 
    @ManyToOne(cascade=CascadeType.PERSIST)
    private Publication publication;



	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public int getValue() {
		return value;
	}



	public void setValue(int value) {
		this.value = value;
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
		result = prime * result + ((publication == null) ? 0 : publication.hashCode());
		result = prime * result + value;
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
		if (publication == null) {
			if (other.publication != null)
				return false;
		} else if (!publication.equals(other.publication))
			return false;
		if (value != other.value)
			return false;
		return true;
	}



	@Override
	public String toString() {
		return "Evaluation_publication [id=" + id + ", value=" + value + ", publication=" + publication + "]";
	}



	public EvaluationPublication(long id, int value, Publication publication) {
		super();
		this.id = id;
		this.value = value;
		this.publication = publication;
	}



	public EvaluationPublication() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
