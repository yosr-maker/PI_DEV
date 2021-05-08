package com.esprit.spring.entites;

import java.io.Serializable;

//import java.util.List;
import java.util.List;

import javax.persistence.CascadeType;

//import javax.persistence.CascadeType;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_ADMIN")

public class Admin extends User implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	private int adminId;
	
	

	@OneToMany(cascade = CascadeType.ALL, mappedBy="admin")
	List<Ray> rays;



	public List<Ray> getRays() {
		return rays;
	}



	public void setRays(List<Ray> rays) {
		this.rays = rays;
	}



	public int getAdminId() {
		return adminId;
	}



	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + adminId;
		result = prime * result + ((rays == null) ? 0 : rays.hashCode());
		return result;
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Admin other = (Admin) obj;
		if (adminId != other.adminId)
			return false;
		if (rays == null) {
			if (other.rays != null)
				return false;
		} else if (!rays.equals(other.rays))
			return false;
		return true;
	}



	public Admin(int adminId, List<Ray> rays) {
		super();
		this.adminId = adminId;
		this.rays = rays;
	}




	
	
}