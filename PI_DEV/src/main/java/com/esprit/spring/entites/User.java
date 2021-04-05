package com.esprit.spring.entites;



import java.io.Serializable;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Inheritance;

import javax.persistence.InheritanceType;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table( name = "T_USER")

public class User   implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		@Id
		@Column(name = "id")
		@GeneratedValue(strategy = GenerationType.TABLE)
		private Long id;
		
	
		@Column(name="Cin")
		private int cin;

		
		

		@Column(name="firstName")
		private String firstName;
		
		@Column(name="lastName", nullable=true)
		private String lastName; 
		

		@Temporal(TemporalType.DATE)
		private Date dateNaissance; 
		
		@Column(name="Status")
		private boolean status ;
		
		@Column(name="email")
		private String email;

		@Column(name="phoneNumber")
		private String phoneNumber;
		
		@Column(name="Username")
		private String username;
		
		@Column(name="password")
		private String password;
		
		@Column(name="role")
		private String role;

		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public int getCin() {
			return cin;
		}

		public void setCin(int cin) {
			this.cin = cin;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public Date getDateNaissance() {
			return dateNaissance;
		}

		public void setDateNaissance(Date dateNaissance) {
			this.dateNaissance = dateNaissance;
		}

		public boolean isStatus() {
			return status;
		}

		

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPhoneNumber() {
			return phoneNumber;
		}

		public void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getRole() {
			return role;
		}

		public void setRole(String role) {
			this.role = role;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (status ? 1231 : 1237);
			result = prime * result + cin;
			result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = (int) (prime * result + id);
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((password == null) ? 0 : password.hashCode());
			result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
			result = prime * result + ((role == null) ? 0 : role.hashCode());
			result = prime * result + ((username == null) ? 0 : username.hashCode());
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
			User other = (User) obj;
			if (status != other.status)
				return false;
			if (cin != other.cin)
				return false;
			if (dateNaissance == null) {
				if (other.dateNaissance != null)
					return false;
			} else if (!dateNaissance.equals(other.dateNaissance))
				return false;
			if (email == null) {
				if (other.email != null)
					return false;
			} else if (!email.equals(other.email))
				return false;
			if (firstName == null) {
				if (other.firstName != null)
					return false;
			} else if (!firstName.equals(other.firstName))
				return false;
			if (id != other.id)
				return false;
			if (lastName == null) {
				if (other.lastName != null)
					return false;
			} else if (!lastName.equals(other.lastName))
				return false;
			if (password == null) {
				if (other.password != null)
					return false;
			} else if (!password.equals(other.password))
				return false;
			if (phoneNumber == null) {
				if (other.phoneNumber != null)
					return false;
			} else if (!phoneNumber.equals(other.phoneNumber))
				return false;
			if (role == null) {
				if (other.role != null)
					return false;
			} else if (!role.equals(other.role))
				return false;
			if (username == null) {
				if (other.username != null)
					return false;
			} else if (!username.equals(other.username))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", cin=" + cin + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", dateNaissance=" + dateNaissance + ", Status=" + status + ", email=" + email + ", phoneNumber="
					+ phoneNumber + ", username=" + username + ", password=" + password + ", role=" + role + "]";
		}

		public User() {
			super();
			// TODO Auto-generated constructor stub
		}

		public User(int id, int cin, String firstName, String lastName, Date dateNaissance, boolean status,
				String email, String phoneNumber, String username, String password, String role) {
			super();
			this.id = (long) id;
			this.cin = cin;
			this.firstName = firstName;
			this.lastName = lastName;
			this.dateNaissance = dateNaissance;
			this.status = status;
			this.email = email;
			this.phoneNumber = phoneNumber;
			this.username = username;
			this.password = password;
			this.role = role;
		}
}

		
	
	    
//	    public void addRole(Role alg) {roles.add(alg);}
//	    public Set<Role> getRoles(){
//	        if(this.roles==null){this.roles = new HashSet<Role>();}
//	        return this.roles;
//	    }
//	    public void setRoles(Set<Role> alg){this.roles = alg;}
//	    public boolean isInRoles(int aid){
//	        ArrayList<Role> mylgs = new ArrayList<Role>();
//	        mylgs.addAll(this.roles);
//	        for(int a=0;a<mylgs.size();a++){if(mylgs.get(a).getId()==aid){return true;}}
//	        return false;
	


		
		