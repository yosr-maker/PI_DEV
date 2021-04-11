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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="EVALUATION")
	
public class EvaluationComment implements Serializable {

	
		private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(name = "idEvaluation")
		private  Long idEvaluation;
		
		
		@JsonIgnore
		@ManyToOne
		
		@JoinColumn(name = "commentId")
		private Comment comment;
		
		
		@Column
		 private int l;
		
		@Column
		 private int d;

		public Long getIdEvaluation() {
			return idEvaluation;
		}

		public void setIdEvaluation(Long idEvaluation) {
			this.idEvaluation = idEvaluation;
		}

		public Comment getComment() {
			return comment;
		}

		public void setComment(Comment comment) {
			this.comment = comment;
		}

		public int getL() {
			return l;
		}

		public void setL(int l) {
			this.l = l;
		}

		public int getD() {
			return d;
		}

		public void setD(int d) {
			this.d = d;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((comment == null) ? 0 : comment.hashCode());
			result = prime * result + d;
			result = prime * result + ((idEvaluation == null) ? 0 : idEvaluation.hashCode());
			result = prime * result + l;
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
			if (d != other.d)
				return false;
			if (idEvaluation == null) {
				if (other.idEvaluation != null)
					return false;
			} else if (!idEvaluation.equals(other.idEvaluation))
				return false;
			if (l != other.l)
				return false;
			return true;
		}

		@Override
		public String toString() {
			return "EvaluationComment [idEvaluation=" + idEvaluation + ", comment=" + comment + ", l=" + l + ", d=" + d
					+ "]";
		}

		public EvaluationComment(Long idEvaluation, Comment comment, int l, int d) {
			super();
			this.idEvaluation = idEvaluation;
			this.comment = comment;
			this.l = l;
			this.d = d;
		}

		public EvaluationComment() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		
		
	}

