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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;



//@Entity
//@Table(name="T_COMMENT")
//public class Comment implements Serializable 
// {
//	
//	private static final long serialVersionUID = 1L;
//	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
//	@Column(name = "commentId")
//	private long commentId;
//	public long getCommentId() {
//		return commentId;
//	}
//	public void setCommentId(long commentId) {
//		this.commentId = commentId;
//	}
//	
//	@Override
//	public String toString() {
//		return "Comment [commentId=" + commentId + ", evaluationcomments="
//				+ evaluationcomments + ", publication=" + publication + "]";
//	}
//
//	
// 
//	@OneToMany(mappedBy="comment")
//   
//	List <EvaluationComment> evaluationcomments;
//
//	@ManyToOne
//	@JoinColumn(name = "idPublication")
//	Publication publication;
@Entity
public class Comment implements Serializable 
{
private static final long serialVersionUID = 1L;
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column
private long id;

@Column
 private String mot;

//@JsonBackReference
@ManyToOne(cascade=CascadeType.PERSIST)
@JoinColumn(name="idPublication",referencedColumnName="id")
private Publication publication;

//@JsonBackReference
@ManyToOne(cascade=CascadeType.PERSIST)
@JoinColumn(name="idUser",referencedColumnName="id")
private User user;


///evaluation

@OneToMany(mappedBy="comment" , cascade=CascadeType.REMOVE)
private List<EvaluationComment> ratings;


public long getId() {
	return id;
}


public void setId(long id) {
	this.id = id;
}


public String getMot() {
	return mot;
}


public void setMot(String mot) {
	this.mot = mot;
}


public Publication getPublication() {
	return publication;
}


public void setPublication(Publication publication) {
	this.publication = publication;
}


public User getUser() {
	return user;
}


public void setUser(User user) {
	this.user = user;
}


public List<EvaluationComment> getRatings() {
	return ratings;
}


public void setRatings(List<EvaluationComment> ratings) {
	this.ratings = ratings;
}


@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + (int) (id ^ (id >>> 32));
	result = prime * result + ((mot == null) ? 0 : mot.hashCode());
	result = prime * result + ((publication == null) ? 0 : publication.hashCode());
	result = prime * result + ((ratings == null) ? 0 : ratings.hashCode());
	result = prime * result + ((user == null) ? 0 : user.hashCode());
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
	Comment other = (Comment) obj;
	if (id != other.id)
		return false;
	if (mot == null) {
		if (other.mot != null)
			return false;
	} else if (!mot.equals(other.mot))
		return false;
	if (publication == null) {
		if (other.publication != null)
			return false;
	} else if (!publication.equals(other.publication))
		return false;
	if (ratings == null) {
		if (other.ratings != null)
			return false;
	} else if (!ratings.equals(other.ratings))
		return false;
	if (user == null) {
		if (other.user != null)
			return false;
	} else if (!user.equals(other.user))
		return false;
	return true;
}


public Comment(long id, String mot, Publication publication, User user, List<EvaluationComment> ratings) {
	super();
	this.id = id;
	this.mot = mot;
	this.publication = publication;
	this.user = user;
	this.ratings = ratings;
}


public Comment() {
	super();
	// TODO Auto-generated constructor stub
}


}
