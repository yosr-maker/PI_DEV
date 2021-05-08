package com.esprit.spring.entites;



import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;

import javax.persistence.Id;

import javax.persistence.Inheritance;

import javax.persistence.InheritanceType;

import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;





@Entity
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
@Table( name = "T_USER_Account")

public class User  implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


		@Id
		@GeneratedValue
		@Column(name = "id")
		private long id;

		@Column(name="Cin")
		private int Cin;

		@Column(name="firstName")
		private String firstName;

		@Column(name="password")
		private String Password;
		
	

	


		public User() {
			super();
			// TODO Auto-generated constructor stub
		}



		@Column(name="lastName", nullable=true)
		private String lastName; 
		

		@Temporal(TemporalType.DATE)
		private Date dateNaissance; 
		
		@Column(name="Status")
		private boolean Status ;
		
		@Column(name="email")
		private String email;

		@Column(name="phoneNumber")
		private  String phoneNumber;
		
		@Column(name="Login")
		private String Login;
		
		public  long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public int getCin() {
			return Cin;
		}

		public void setCin(int cin) {
			Cin = cin;
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
			return Status;
		}

		public void setStatus(boolean status) {
			Status = status;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public  String getPhoneNumber() {
			return phoneNumber;
		}

		public  void setPhoneNumber(String phoneNumber) {
			this.phoneNumber = phoneNumber;
		}

		public String getLogin() {
			return Login;
		}

		public void setLogin(String login) {
			Login = login;
		}

		public String getPassword() {
			return Password;
		}

		public void setPassword(String password) {
			Password = password;
		}

	

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + Cin;
			result = prime * result + ((Login == null) ? 0 : Login.hashCode());
			result = prime * result + ((Password == null) ? 0 : Password.hashCode());
			result = prime * result + (Status ? 1231 : 1237);
			result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
			result = prime * result + ((email == null) ? 0 : email.hashCode());
			result = prime * result + ((firstName == null) ? 0 : firstName.hashCode());
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + ((lastName == null) ? 0 : lastName.hashCode());
			result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
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
			if (Cin != other.Cin)
				return false;
			if (Login == null) {
				if (other.Login != null)
					return false;
			} else if (!Login.equals(other.Login))
				return false;
			if (Password == null) {
				if (other.Password != null)
					return false;
			} else if (!Password.equals(other.Password))
				return false;
			if (Status != other.Status)
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
			if (phoneNumber == null) {
				if (other.phoneNumber != null)
					return false;
			} else if (!phoneNumber.equals(other.phoneNumber))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "User [id=" + id + ", Cin=" + Cin + ", firstName=" + firstName + ", Password=" + Password
					+ ", lastName=" + lastName + ", dateNaissance=" + dateNaissance + ", Status=" + Status + ", email="
					+ email + ", Login=" + Login + "]";
		}

		public User(long id, int cin, String firstName, String password, String lastName, Date dateNaissance,
				boolean status, String email, String login) {
			super();
			this.id = id;
			Cin = cin;
			this.firstName = firstName;
			Password = password;
			this.lastName = lastName;
			this.dateNaissance = dateNaissance;
			Status = status;
			this.email = email;
			Login = login;
		}

		

		


}
