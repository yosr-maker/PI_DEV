package com.esprit.spring.entites;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.Table;

@Entity
@Table(name="EVALUATION")
	
public class EvaluationComment implements Serializable {

	
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "idEvaluation")
		private  Long idEvaluation;
		
		@ManyToOne
		@JoinColumn(name = "commentId")
		private Comment comment;
		
		
		public Comment getComment() {
			return comment;
		}
		public void setComment(Comment comment) {
			this.comment = comment;
		}
		public Long getIdEvaluation() {
			return idEvaluation;
		}
		public void setIdEvaluation(Long idEvaluation) {
			this.idEvaluation = idEvaluation;
		}
		@Override
		public String toString() {
			return "EvaluationComment [idEvaluation=" + idEvaluation + ", comment=" + comment + "]";
		}
		public EvaluationComment(Long idEvaluation, Comment comment) {
			super();
			this.idEvaluation = idEvaluation;
			this.comment = comment;
		}
		
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comment == null) ? 0 : comment.hashCode());
			result = prime * result + ((idEvaluation == null) ? 0 : idEvaluation.hashCode());
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
			EvaluationComment other = (EvaluationComment) obj;
			if (comment == null) {
				if (other.comment != null)
					return false;
			} else if (!comment.equals(other.comment))
				return false;
			if (idEvaluation == null) {
				if (other.idEvaluation != null)
					return false;
			} else if (!idEvaluation.equals(other.idEvaluation))
				return false;
			return true;
		}
		
		
		public EvaluationComment(int idEvaluation, Comment comment) {
			super();
			this.idEvaluation = (long) idEvaluation;
			this.comment = comment;
		}
		
		public EvaluationComment() {
			super();
			// TODO Auto-generated constructor stub
		}
		

			
		
	}

