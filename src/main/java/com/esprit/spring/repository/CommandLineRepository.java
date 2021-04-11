package com.esprit.spring.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.esprit.spring.entites.Command_line;

import antlr.collections.List;

@Repository
public interface CommandLineRepository extends JpaRepository<Command_line,Long> {

	@Query("select DISTINCT p from Command_line p join p.products a on a.id=:prodId where a.Quantity=:quantity ")
	public List findCommandLlinByProductAndQuantityJPQL(@Param("prodId")Long prodId,@Param("quantity")Long quantity);
	
	

	@Query("select a.Price from Product a where a.id=:prodId")
	public Long getPriceProdJPQL(@Param("prodId")Long prodId);
	


	@Modifying
    @Transactional
    @Query("UPDATE Command_line c SET c.quantityPurchased=:quant , c.prixToPay=:prix1 where c.id=:clId")
    public void mettreAjourCommandLineByIdJPQL(@Param("quant")Long quant,@Param("prix1")float prix1, @Param("clId")Long id);

	@Query("select count(*) from Command_line c ")
	public int getLastCommandLineJPQL();
	
}
