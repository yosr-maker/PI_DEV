package com.esprit.spring.entites;



import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_RAYMASTER")

public class RayMaster extends User_account {

	
	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy="raymaster")
	private List<Ray> rays; 
	
	
	

	public RayMaster() {
		super();
		// TODO Auto-generated constructor stub
	}


	public RayMaster(int cin, String firstName, String lastName, Date dateNaissance, boolean status, String email,
			String phoneNumber, String login, String password, List<Ray> rays) {
		super(cin, firstName, lastName, dateNaissance, status, email, phoneNumber, login, password);
		this.rays = rays;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
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
		RayMaster other = (RayMaster) obj;
		if (rays == null) {
			if (other.rays != null)
				return false;
		} else if (!rays.equals(other.rays))
			return false;
		return true;
	}


	public List<Ray> getRays() {
		return rays;
	}


	public void setRays(List<Ray> rays) {
		this.rays = rays;
	}


	public RayMaster(int cin, String firstName, String lastName, Date dateNaissance, boolean status, String email,
			String phoneNumber, String login, String password) {
		super(cin, firstName, lastName, dateNaissance, status, email, phoneNumber, login, password);
		// TODO Auto-generated constructor stub
	}
	
}

