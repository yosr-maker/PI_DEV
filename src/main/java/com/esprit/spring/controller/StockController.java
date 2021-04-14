 package com.esprit.spring.controller;



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
import com.esprit.spring.services.IStockDetailService;
import com.esprit.spring.services.IStockService;

@RestController
public class StockController {
	
	
	@Autowired
	IStockService iStockService;
	
	@Autowired
	IStockDetailService iStockDetailService;
	
	@PostMapping("add-stock")
	@ResponseBody
	public Stock addstok(@RequestBody  Stock stock)
	{
		return iStockService.addStock(stock);
	}
	
	@DeleteMapping("/delete-stock/{id}")
	@ResponseBody
	public void  deletestock(@PathVariable("id") int id)
	{
		
		iStockService.deleteStockById(id);
	}
	
	
	@PutMapping("/modify-stock")
	@ResponseBody
	public Stock updateStock(@RequestBody Stock stock) {
	return iStockService.updatestock(stock);
	}
	
	@GetMapping("/getall-stock")
	@ResponseBody
	public  Iterable <Stock> getAllStocks(){
		Iterable <Stock> list= iStockService.getAllStock();
		
		return list;
	}
	
	
	
	@DeleteMapping("/deleAllStock")
	@ResponseBody
	void deleAllStock() {
		
		
		iStockService.deleteAllStock();
	}
	
	
	@GetMapping("/getStockById/{id}")
	@ResponseBody
	public  Stock getStockByIdd(@PathVariable int id){
		
		Stock s =iStockService.getStockById(id);
		
		return s ;
	}
	
/*	@PutMapping("affectationStockDetaiToStock/{idStock}/{idStockDetail}")
	@ResponseBody
	public Stock affectationStockDetaiToStock(@PathVariable("idStock") int idStock,@PathVariable("idStockDetail")  int idStockDetail )
	{
		
		return iStockService.affectaionStockToStockDetail(idStock, idStockDetail);
		
	}*/

}
