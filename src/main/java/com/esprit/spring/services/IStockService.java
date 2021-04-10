package com.esprit.spring.services;



import com.esprit.spring.entites.Stock;

public interface IStockService {
	
	
	public Stock  addStock(Stock stock);
	public void  deleteStockById(int id);
	public Stock  updatestock(Stock stock);
	public Stock getStockById(int id);
	public Iterable<Stock> getAllStock();
	public void deleteAllStock();
	
		
	public Stock affectaionStockToStockDetail( int idStock, int idStockDetail);
	

}
