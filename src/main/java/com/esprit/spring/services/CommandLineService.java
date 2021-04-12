package com.esprit.spring.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Command_line;
import com.esprit.spring.entites.Product;
import com.esprit.spring.repository.ICommandLineRepository;
import com.esprit.spring.repository.ProductRepository;

@Service
public class CommandLineService implements ICommandLineService {
	
	
	
	@Autowired
	ICommandLineRepository iCommandLineRepository ;
	@Autowired
	ProductRepository productRepository ;
	
	public Command_line addCommandLine(Command_line cml)
	{
		return iCommandLineRepository.save(cml);
	}


	@Override
	public Product affectaionProduitToCommandLine(int idCommand, int idProduit, int nbr_Produit) {
		// TODO Auto-generated method stub
		
		int r=0;
		Command_line cmline = iCommandLineRepository.findById(idCommand).get();
		 Product prod     = productRepository.findById(idProduit).get();
		 
		 r=  prod.getNbrcommanline()+nbr_Produit;
		  
		prod.setNbrcommanline(r);
		 
		cmline.getProducts().add(prod);
		prod.setCommandLine(cmline);
		iCommandLineRepository.save(cmline);
		 return productRepository.save(prod);
		 
		  
		
		 
	}
	
	

	
	
}
	
	
	



	
	
	
	


