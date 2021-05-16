package com.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.esprit.spring.entites.Comment;
import com.esprit.spring.entites.EvaluationComment;


public interface EvaluationCommentRepository extends CrudRepository<EvaluationComment,Long>{
	
	@Query("select e.comment from EvaluationComment e ")
	public List<Comment> evsave();
	
	@Query("select e from EvaluationComment e where e.comment=:comment")
	public EvaluationComment findevaluation(@Param("comment") Comment comment);

	 
	@Query("select max(e.l) from EvaluationComment e")
	public int mostliked();
	

	
	EvaluationComment findByL(int l);
	
	
	@Query("select e.comment from EvaluationComment e where e.l=:nbrl ")
	public List<Comment> myfind(@Param("nbrl") int nbrl);
	
	
	
	
	
	
	 
	 
	 
	 
	 

}
