package com.esprit.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Command_line;
import com.esprit.spring.entites.Product;
import com.esprit.spring.services.ICommandLineService;
import com.esprit.spring.services.IProductService;

@RestController
public class Command_lineController {

	@Autowired
	ICommandLineService iCommandLineService;

	@Autowired
	IProductService productS;

	@PostMapping("add-commandLine")
	@ResponseBody
	public Command_line adCommandLine(@RequestBody Command_line cml) {
		return iCommandLineService.addCommandLine(cml);
	}

	@PostMapping("affectationProduitToCommandLine/{idCommand}/{idProduit}/{nbr_Produit}")
	@ResponseBody
	public void affectaionProduitToCommandLine(@PathVariable("idCommand") int idCommand,
			@PathVariable("idProduit") int idProduit, @PathVariable("nbr_Produit") int nbr_Produit) {
		iCommandLineService.affectaionProduitToCommandLine(idCommand, idProduit, nbr_Produit);
	}

}
