package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.Date;
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




	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}




	public int getAdminId() {
		return adminId;
	}




	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}




	public List<Ray> getRays() {
		return rays;
	}




	public void setRays(List<Ray> rays) {
		this.rays = rays;
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




	@Override
	public String toString() {
		return "Admin [adminId=" + adminId + ", rays=" + rays + "]";
	}




	public Admin(int adminId, List<Ray> rays) {
		super();
		this.adminId = adminId;
		this.rays = rays;
	}




	public Admin(int id, int cin, String firstName, String lastName, Date dateNaissance, boolean status, String email,
			String phoneNumber, String username, String password, String role) {
		super(id, cin, firstName, lastName, dateNaissance, status, email, phoneNumber, username, password, role);
		// TODO Auto-generated constructor stub
	}


	



	
	
}