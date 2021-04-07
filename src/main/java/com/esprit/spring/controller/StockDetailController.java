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

import com.esprit.spring.entites.StockDetail;
import com.esprit.spring.services.IStockDetailService;

@RestController
public class StockDetailController {
	
	
	
	@Autowired
	IStockDetailService iStockDetailService;
	
	
	
	@GetMapping("affectationProduct/{idProd}/{idStock}")
	@ResponseBody
	public StockDetail affectationProduct(@PathVariable("idProd") int idProd, @PathVariable("idStock") int idStock){
		
		
	
		
		return iStockDetailService.affectationProduitDansStockDetail(idProd, idStock);
	}
	
	
	@PostMapping("add-StockDetail")
	@ResponseBody
	public void addStockDetails(@RequestBody StockDetail stcd){
		iStockDetailService.addStockDetail(stcd);
		
	}
	
	
	
	@GetMapping("decrementStock/{idStock}/{nBrProduct}")
	@ResponseBody
	public int decrementStock(@PathVariable("idStock") int idStock,@PathVariable("nBrProduct") int nBrProduct){
		
		
		
		
		return iStockDetailService.descrementStock(idStock,nBrProduct) ;
	}
	
	
	@GetMapping("List-ProductExpirer")
	@ResponseBody
	public List<StockDetail> listProductExprirer(){
		
		return iStockDetailService.sendnotifProductExpiration();
	}
	
}
