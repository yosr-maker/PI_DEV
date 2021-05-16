package com.esprit.spring.entites;
import java.io.Serializable;
import java.util.Date;
import java.util.List;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;



@Entity
@Table(name="PUBLICATION")
public class Publication implements Serializable{
	
	private static final long serialVersionUID = -6236517548335858347L
			;
//
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	@Column(name = "idPublication")
	private  Long id;
	
	@Column
	 private String type;
	
	@Column
	 private String title;
	
	@Column
	 private String description;
	
	@Temporal(TemporalType.DATE)
    private Date date;
	
	
	@JsonIgnore
	@OneToMany(mappedBy="publication")
	
	public List<Comment> comments;
	
	
    
	
	@OneToMany(mappedBy="publication" )
	    private List<EvaluationPublication> ratings;
	    
		public Long getId() {
			return id;
		}

		public void setId(Long id) {
			this.id = id;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Date getDate() {
			return date;
		}

		public void setDate(Date date) {
			this.date = date;
		}

		public List<Comment> getComments() {
			return comments;
		}

		public void setComments(List<Comment> comments) {
			this.comments = comments;
		}

		public List<EvaluationPublication> getRatings() {
			return ratings;
		}

		public void setRatings(List<EvaluationPublication> ratings) {
			this.ratings = ratings;
		}



		

		
		

		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comments == null) ? 0 : comments.hashCode());
			result = prime * result + ((date == null) ? 0 : date.hashCode());
			result = prime * result + ((description == null) ? 0 : description.hashCode());
			result = prime * result + ((id == null) ? 0 : id.hashCode());
			result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
			result = prime * result + ((title == null) ? 0 : title.hashCode());
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
			Publication other = (Publication) obj;
			if (comments == null) {
				if (other.comments != null)
					return false;
			} else if (!comments.equals(other.comments))
				return false;
			if (date == null) {
				if (other.date != null)
					return false;
			} else if (!date.equals(other.date))
				return false;
			if (description == null) {
				if (other.description != null)
					return false;
			} else if (!description.equals(other.description))
				return false;
			if (id == null) {
				if (other.id != null)
					return false;
			} else if (!id.equals(other.id))
				return false;
			if (ratings == null) {
				if (other.ratings != null)
					return false;
			} else if (!ratings.equals(other.ratings))
				return false;
			if (title == null) {
				if (other.title != null)
					return false;
			} else if (!title.equals(other.title))
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
			return "Publication [id=" + id + ", type=" + type + ", title=" + title + ", description=" + description
					+ ", date=" + date + ", comments=" + comments + ", ratings=" + ratings + "]";
		}
		
		
		
		
		

		public Publication(Long id, String type, String title, String description, Date date, List<Comment> comments,
				List<EvaluationPublication> ratings) {
			super();
			this.id = id;
			this.type = type;
			this.title = title;
			this.description = description;
			this.date = date;
			this.comments = comments;
			this.ratings = ratings;
		}

		public Publication() {
			super();
			// TODO Auto-generated constructor stub
		}

		

		
		
}

		