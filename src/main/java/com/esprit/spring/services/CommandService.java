package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Command;

public interface CommandService {
	List<Command> retrieveAllCommands();
	Command addCommand(Command comm);
	void deleteCommand (Long commandId);		
	Command updateCommand(Command comm);
	Command retrieveCommand(Long commandId);
}
