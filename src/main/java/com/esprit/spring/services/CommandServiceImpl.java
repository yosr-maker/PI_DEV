package com.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Command;
import com.esprit.spring.repository.CommandRepository;

@Service
public class CommandServiceImpl implements CommandService {

	@Autowired
	CommandRepository  	commandRepository;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(CommandService.class);

	
	
	@Override
	public List<Command> retrieveAllCommands() {
		List<Command> commands = (List<Command>) commandRepository.findAll();
		for(Command command:commands) {
			l.info("command :" + command);
		}
		return commands;
	}

	@Override
	public Command addCommand(Command comm) {
		return 	commandRepository.save(comm);
	}

	@Override
	public void deleteCommand(Long commandId) {
		commandRepository.deleteById(commandId);
		
	}

	@Override
	public Command updateCommand(Command comm) {
		return 	commandRepository.save(comm);
		
	}

	@Override
	public Command retrieveCommand(Long commandId) {
		
		return 	commandRepository.findById(commandId).get();
	}

}
