package com.esprit.spring.entites;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
@Entity
@Table(name="T_COMMENT")
public class Comment implements Serializable 
 {
	
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "commentId")
	private int commentId;
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	
	@OneToOne
    @JoinColumn(name = "idStar")
	private StarRating starrating;

	@OneToMany(mappedBy="comment")
   
	List <EvaluationComment> evaluationcomments;

	@ManyToOne
	@JoinColumn(name = "idPublication")
	Publication publication;

	
	public Comment(int commentId, StarRating starrating, List<EvaluationComment> evaluationcomments,
			Publication publication) {
		super();
		this.commentId = commentId;
		this.starrating = starrating;
		this.evaluationcomments = evaluationcomments;
		this.publication = publication;
	}
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + commentId;
		result = prime * result + ((evaluationcomments == null) ? 0 : evaluationcomments.hashCode());
		result = prime * result + ((publication == null) ? 0 : publication.hashCode());
		result = prime * result + ((starrating == null) ? 0 : starrating.hashCode());
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
		if (commentId != other.commentId)
			return false;
		if (evaluationcomments == null) {
			if (other.evaluationcomments != null)
				return false;
		} else if (!evaluationcomments.equals(other.evaluationcomments))
			return false;
		if (publication == null) {
			if (other.publication != null)
				return false;
		} else if (!publication.equals(other.publication))
			return false;
		if (starrating == null) {
			if (other.starrating != null)
				return false;
		} else if (!starrating.equals(other.starrating))
			return false;
		return true;
	}
	
	public Comment() {
	super();
	// TODO Auto-generated constructor stub
}


}

