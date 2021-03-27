package com.esprit.spring.entites;

	import java.io.Serializable;

	
	import javax.persistence.Column;
	import javax.persistence.Entity;
	import javax.persistence.GeneratedValue;
	import javax.persistence.GenerationType;
	import javax.persistence.Id;
import javax.persistence.Table;




	@Entity
	@Table(name="RECHERCHE")
	public class Recherche implements Serializable{
		
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue (strategy = GenerationType.IDENTITY)
		@Column
		private long id;
		
		@Column
		 private String type;
		
		@Column
		private Long nbr;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public Long getNbr() {
			return nbr;
		}

		public void setNbr(Long nbr) {
			this.nbr = nbr;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + (int) (id ^ (id >>> 32));
			result = prime * result + ((nbr == null) ? 0 : nbr.hashCode());
			result = prime * result + ((type == null) ? 0 : type.hashCode());
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
			Recherche other = (Recherche) obj;
			if (id != other.id)
				return false;
			if (nbr == null) {
				if (other.nbr != null)
					return false;
			} else if (!nbr.equals(other.nbr))
				return false;
			if (type == null) {
				if (other.type != null)
					return false;
			} else if (!type.equals(other.type))
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "Recherche [id=" + id + ", type=" + type + ", nbr=" + nbr + "]";
		}

		public Recherche(long id, String type, Long nbr) {
			super();
			this.id = id;
			this.type = type;
			this.nbr = nbr;
		}

		public Recherche() {
			super();
			// TODO Auto-generated constructor stub
		}

		public Recherche(String type2) {
			// TODO Auto-generated constructor stub
		}

		public void setClient(Client c) {
			// TODO Auto-generated method stub
			
		}
		
		
		
		
		
		
		
		
		
}
