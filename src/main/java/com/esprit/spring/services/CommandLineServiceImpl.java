package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Automobile;
import com.esprit.spring.entites.Command_line;
import com.esprit.spring.entites.Driver;
import com.esprit.spring.entites.Product;
import com.esprit.spring.repository.CommandLineRepository;
import com.esprit.spring.repository.ProductRepository;

@Service
public class CommandLineServiceImpl implements CommandLineService {
	@Autowired
	CommandLineRepository commandLineRepository ;
	@Autowired
	ProductRepository proRepository ;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(CommandLineService.class);


	@Override
	public List<Command_line> retrieveAllCommandLines() {
		List<Command_line>  cls= (List<Command_line>) commandLineRepository.findAll();
		for(Command_line cl:cls) {
			l.info("command line :" + cl);
		}
		return cls;
	}

	@Override
	public Command_line addCommandLine(Command_line cl) {
		
		return commandLineRepository.save(cl);
	}

	@Override
	public void deleteCommandLine(Long id) {
		commandLineRepository.deleteById(id);
		
	}
	
	public Command_line addCommandLine(Long prodId, Long quantity) {
		
		
			Product p = proRepository.findById(prodId).get();
			p.setQuantity(p.getQuantity()-quantity);
			proRepository.save(p);
			Command_line cl = new Command_line();
			cl.setProducts((List<Product>) p); //cl.setProduit(p);
			Long price =  commandLineRepository.getPriceProdJPQL(prodId);
			cl.setQuantityPurchased(quantity);
			cl.setPrixToPay(price * quantity);
			commandLineRepository.save(cl);
			return cl;
	}
	
	public void updateCommandLineById(Long idcl, Long quantity) {
		Command_line  cl = commandLineRepository.findById(idcl).get();
		float prix1 = (cl.getPrixToPay()/cl.getQuantityPurchased())*quantity;
		commandLineRepository.mettreAjourCommandLineByIdJPQL(quantity, prix1, idcl);
		
	}

	public int getLastProd() {
		return commandLineRepository.getLastCommandLineJPQL();
		
	}
	
	

	

	@Override
	public Command_line retrieveCommandLine(Long id) {
		
		return commandLineRepository.findById(id).get();
	}

	@Override
	public Command_line updateCommandLine(Command_line cl) {
		
		return  commandLineRepository.save(cl);
	}

	@Override
	public Command_line findOneC(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Command_line findCommandLine(Long id, Long ommandeId) {
		// TODO Auto-generated method stub
		return null;
	}
	public void affecterCLToProduct(Long idCl, Long idp) {
		Product p = proRepository.findById(idp).get();
		Command_line cl =commandLineRepository.findById(idCl).get();
		
		cl.setProducts((List<Product>) p);
		proRepository.save(p);
	}
}
