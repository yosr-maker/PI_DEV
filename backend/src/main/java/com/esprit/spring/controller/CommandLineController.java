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

import com.esprit.spring.services.CommandLineService;
import com.esprit.spring.entites.Command_line;

//il ya un prob au modif
@RestController
@RequestMapping("/api")
public class CommandLineController {
	@Autowired
	CommandLineService commandLineService;
	
	//localhost:8092/api/add-commandLine
	/*{ "id":1,	"quantityPurchased":2.5
}*/
	@PostMapping(value = "/add-commandLine")
	@ResponseBody
	public Command_line addCommandLine(@RequestBody Command_line cl) {
		Command_line Cl = commandLineService.addCommandLine(cl);
		System.out.println("cl add works properly");
	return Cl;	
	}
	//localhost:8092/api/remove-commandLine/4
	@DeleteMapping("/remove-commandLine/{commandLine-id}")
	@ResponseBody
	public void removeCommandLine(@PathVariable("commandLine-id")Long commandLineId) {
		commandLineService.deleteCommandLine(commandLineId);
	}
	
	//localhost:8092/api/modify-commandLine
	@PutMapping("/modify-commandLine")
	@ResponseBody
	public Command_line modifyCommandLine(@RequestBody Command_line cl) {
	return commandLineService.updateCommandLine(cl);
	}
	
	//localhost:8092/api/retrieve-commandLine/3
	@GetMapping("/retrieve-commandLine/{commandLine-id}")
	@ResponseBody
	public Command_line retrievecommandLine(@PathVariable("commandLine-id") Long commandLineId) {
	return commandLineService.retrieveCommandLine(commandLineId);
	}
	
	//localhost:8092/api/retrieve-all-commandLine
	@GetMapping("/retrieve-all-commandLine")
	@ResponseBody
	public List<Command_line> getCommandLine() {
	List<Command_line> list = commandLineService.retrieveAllCommandLines();
	return list;
	
	}
	//NON
	@PostMapping(value = "/add-commandLineprod/{prodid}/{quant}")
	@ResponseBody
	public Command_line addCommandLine(@PathVariable ("prodid")int prodId, @PathVariable("quant")Long quantity) {
		return commandLineService.addCommandLine(prodId, quantity);
		
	}
	//OK
	@PutMapping("/modify-commandLineByid/{idcl}/{newquant}")
	@ResponseBody
	public void updateCommandLineById(@PathVariable ("idcl")Long idcl,@PathVariable("newquant") Long quantity) {
		commandLineService.updateCommandLineById(idcl, quantity);
	}
	//OK
	@GetMapping("/last")
	@ResponseBody
	public int getLastProd() {
		return commandLineService.getLastProd();
		
	}
	//ok
	@PostMapping("/affecterProToCl/{idcl}/{idp}")
	public String affecterProductToCl(@PathVariable ("idcl")Long idcl,@PathVariable ("idp") int idp) {
		return commandLineService.affecterProductToCl(idcl, idp);
	}
	//ok
	@PostMapping("/affecterBasketsToCl/{idcl}/{idba}")
	public String affecterBasketsToCl(@PathVariable("idcl")Long idcl,@PathVariable("idba") Long idba) {
		return commandLineService.affecterBasketsToCl(idcl, idba);
	}
}
