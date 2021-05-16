package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Command_line;


public interface CommandLineService {
	List<Command_line> retrieveAllCommandLines();
	Command_line addCommandLine(Command_line cl);
	void deleteCommandLine (Long idA);		
	Command_line updateCommandLine(Command_line cl);
	Command_line retrieveCommandLine(Long id);
	public Command_line findOneC(Long id);
	public Command_line findCommandLine(Long id,Long ommandeId);
	public Command_line addCommandLine(int prodId, Long quantity);
	public void updateCommandLineById(Long idcl, Long quantity);
	public int getLastProd();
	public String affecterProductToCl(Long idcl, int idp);
	String affecterBasketsToCl(Long idcl, Long idba);
	
}
