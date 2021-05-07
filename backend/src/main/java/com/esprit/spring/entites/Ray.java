package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="T_RAY")
public class Ray implements Serializable{

	

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "idRay")
	private int idRay;
	
	@Column(name="Type")
	private String Type;
	

	@Column(name="Category")
	private String Category;
	

	@Column(name="Quantity")
	private String Quantity;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy="ray")
	List<Product> products;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private Admin admin;
	
	@ManyToMany
	private List<RayMaster> raymaster;
	
	public List<RayMaster> getRaymaster() {
		return raymaster;
	}


	public Admin getAdmin() {
		return admin;
	}


	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	

	public List<Product> getProducts() {
		return products;
	}


	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	public Ray() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Ray [idRay=" + idRay + ", Type=" + Type + ", Category=" + Category + ", Quantity=" + Quantity
				+ ", products=" + products + ", admin=" + admin + ", raymaster=" + raymaster + "]";
	}


	public Ray(int idRay, String type, String category, String quantity, List<Product> products, Admin admin,
			List<RayMaster> raymaster) {
		super();
		this.idRay = idRay;
		Type = type;
		Category = category;
		Quantity = quantity;
		this.products = products;
		this.admin = admin;
		this.raymaster = raymaster;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((Category == null) ? 0 : Category.hashCode());
		result = prime * result + ((Quantity == null) ? 0 : Quantity.hashCode());
		result = prime * result + ((Type == null) ? 0 : Type.hashCode());
		result = prime * result + ((admin == null) ? 0 : admin.hashCode());
		result = prime * result + idRay;
		result = prime * result + ((products == null) ? 0 : products.hashCode());
		result = prime * result + ((raymaster == null) ? 0 : raymaster.hashCode());
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
		Ray other = (Ray) obj;
		if (Category == null) {
			if (other.Category != null)
				return false;
		} else if (!Category.equals(other.Category))
			return false;
		if (Quantity == null) {
			if (other.Quantity != null)
				return false;
		} else if (!Quantity.equals(other.Quantity))
			return false;
		if (Type == null) {
			if (other.Type != null)
				return false;
		} else if (!Type.equals(other.Type))
			return false;
		if (admin == null) {
			if (other.admin != null)
				return false;
		} else if (!admin.equals(other.admin))
			return false;
		if (idRay != other.idRay)
			return false;
		if (products == null) {
			if (other.products != null)
				return false;
		} else if (!products.equals(other.products))
			return false;
		if (raymaster == null) {
			if (other.raymaster != null)
				return false;
		} else if (!raymaster.equals(other.raymaster))
			return false;
		return true;
	}




	public void setRaymaster(List<RayMaster> raymaster) {
		this.raymaster = raymaster;
	}


	public int getIdRay() {
		return idRay;
	}


	public void setIdRay(int idRay) {
		this.idRay = idRay;
	}


	public String getType() {
		return Type;
	}


	public void setType(String type) {
		Type = type;
	}


	public String getCategory() {
		return Category;
	}


	public void setCategory(String category) {
		Category = category;
	}


	public String getQuantity() {
		return Quantity;
	}


	public void setQuantity(String quantity) {
		Quantity = quantity;
	}






	
}

