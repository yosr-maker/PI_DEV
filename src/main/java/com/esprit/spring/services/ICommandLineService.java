package com.esprit.spring.services;

import com.esprit.spring.entites.Command_line;
import com.esprit.spring.entites.Product;

public interface ICommandLineService {
	
	
	public Command_line addCommandLine(Command_line cml);
	
	public Product affectaionProduitToCommandLine(int idCommand, int idProduit,int nbr_Produit);

}
