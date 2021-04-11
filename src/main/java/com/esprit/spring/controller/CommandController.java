package com.esprit.spring.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Command;
import com.esprit.spring.services.CommandService;

@RestController
@RequestMapping("/api")
public class CommandController {
	@Autowired
	CommandService commandService;
	
	//localhost:8092/api/add-command
	/*{ "TotalPrice":"123",	"statusBasket":"remplie","dateCommande":"2020-21-13"
*/
	@PostMapping(value = "/add-command")
	@ResponseBody
	public Command addCommand(@RequestBody Command comm) {
		Command command = commandService.addCommand(comm);
		System.out.println("command add works properly");
	return command;	
	}
	
	//localhost:8092/api/remove-command/2
	@DeleteMapping("/remove-command/{Command-id}")
	@ResponseBody
	public void removeCommand(@PathVariable("Command-id")Long commandId) {
		commandService.deleteCommand(commandId);
	}
	
	//localhost:8092/api/modify-command
	/*{ "commandId":1,"TotalPrice":"250",	"statusBasket":"remplie","dateCommande":"2019-21-13"
*/
	@PutMapping("/modify-command")
	@ResponseBody
	public Command modifyCommand(@RequestBody Command comm) {
	return commandService.updateCommand(comm);
	}
	
	//localhost:8092/api/retrieve-command/4
	@GetMapping("/retrieve-command/{command-id}")
	@ResponseBody
	public Command retrieveCommand(@PathVariable("command-id") Long commandId) {
	return commandService.retrieveCommand(commandId);
	}
	
	//localhost:8092/api/retrieve-all-commands
	@GetMapping("/retrieve-all-commands")
	@ResponseBody
	public List<Command> getCommand() {
	List<Command> list = commandService.retrieveAllCommands();
	return list;
	}

}
