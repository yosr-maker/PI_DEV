package com.esprit.spring.controller;

import java.util.List;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.esprit.spring.entites.Stock;
import com.esprit.spring.entites.StockDetail;
import com.esprit.spring.services.IStockDetailService;

@RestController
public class StockDetailController {
	
	
	
	@Autowired
	IStockDetailService iStockDetailService;
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("affectationProduct/{idProd}/{idStock}")
	@ResponseBody
	public StockDetail affectationProduct(@PathVariable("idProd") int idProd, @PathVariable("idStock") int idStock){
		
		return iStockDetailService.affectationProduitDansStockDetail(idProd, idStock);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//	@PostMapping("add-StockDetail")
//	@ResponseBody
//	public void addStockDetails(@RequestBody StockDetail stcd){
//		iStockDetailService.addStockDetail(stcd);
//		
//	}
	@PostMapping("add-StockDetail")
	@ResponseBody
	public StockDetail addStockDetails(@RequestBody StockDetail stcd){
		//stcd.getProduct().setStockDetail(stcd);
		iStockDetailService.addStockDetail(stcd);
		return stcd ;
		
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@DeleteMapping("/delete-stockDetail/{idStockDetail}")
	@ResponseBody
	public void deleteStockDetails(@PathVariable("idStockDetail") int idStockDetail){
		
		iStockDetailService.deleteStockDetailById(idStockDetail);
	}
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@PutMapping("/updateStockDetail")
	@ResponseBody
	public  StockDetail updateStockDetail(@RequestBody StockDetail stockDetail)
	{
		
		return iStockDetailService.updatestockDetail(stockDetail);
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("GetAllStockDetail")
	@ResponseBody
	public Iterable<StockDetail> getAllStocKDetail()
	{
		Iterable<StockDetail> I = iStockDetailService.getAllStockDetail();
		return I;
	}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@GetMapping("GetByIdStockDetail/{idStocks}")
	@ResponseBody
	public StockDetail GetStocKDetailById(int idStock){
		
		
		
		return iStockDetailService.getStockDetailById(idStock);
	}
	
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@DeleteMapping("deleAllStockDetail")
	@ResponseBody
	public void DeleteAllstockDetais(){
		
		iStockDetailService.deleteAllStockDetail();
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("decrementStock/{idStock}/{nBrProduct}")
	@ResponseBody
	public int decrementStock(@PathVariable("idStock") int idStock,@PathVariable("nBrProduct") int nBrProduct){
		
		
		
		return iStockDetailService.descrementStock(idStock,nBrProduct) ;
	}
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////	
	
	@GetMapping("List-ProductExpirer")
	@ResponseBody
	public List<StockDetail> listProductExprirer(){
		
		return iStockDetailService.sendnotifProductExpiration();
	}
	
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@PostMapping("affectation/{idStock}/{idStockDetail}")
	@ResponseBody
	public StockDetail affectaionStockToStockDetaills(@PathVariable("idStock")int idStock,@PathVariable("idStockDetail") int idStockDetail)
	{
		return iStockDetailService.affectaionStockToStockDetails(idStock, idStockDetail);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	@GetMapping("solde")
	@ResponseBody
	public List<StockDetail> solde(){
		
		List<StockDetail> soldes = iStockDetailService.sendNotifSoldeStock();
				
		return soldes;
	}
	
	
}
