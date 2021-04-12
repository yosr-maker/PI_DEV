package com.esprit.spring.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Stock;
import com.esprit.spring.entites.StockDetail;
import com.esprit.spring.repository.StockDetailRepository;
import com.esprit.spring.repository.StockRepository;

@Service
public class StockServiceImpl implements IStockService {


	@Autowired
	StockDetailRepository stockDetailRepository;
	
	@Autowired
	StockRepository  stockRepository;

	@Override
	public Stock addStock(Stock stock) {
		// TODO Auto-generated method stub
		
		return stockRepository.save(stock);
		
	}

	@Override
	public void deleteStockById(int id) {
		// TODO Auto-generated method stub
		
		stockRepository.deleteById(id);
		
	}

	@Override
	public Stock updatestock(Stock stock) {
		// TODO Auto-generated method stub  
		
		return stockRepository.save(stock);
		
	}

	@Override
	public Stock getStockById(int id) {
		// TODO Auto-generated method stub

		
	   Stock stock = stockRepository.findById(id).orElse(null);
		
		return stock;
		
	}

	
	@Override
	public Iterable <Stock> getAllStock() {
		// TODO Auto-generated method stub
		
 Iterable<Stock> stock =  stockRepository.findAll();
		 
		 return stock;
		
	}

	@Override
	public void deleteAllStock() {
		// TODO Auto-generated method stub
		
		stockRepository.deleteAll();
		
	}

	
	
	
	
	public Stock affectaionStockToStockDetail( int idStock, int idStockDetail)
	{
		StockDetail stockD = stockDetailRepository.findById(idStockDetail).get();
		Stock stock = stockRepository.findById(idStock).get();
				
		stock.getStockDeatail().add(stockD);
		
		return stockRepository.save(stock);
		
		
	}
	
	
	
	
	
	
	
	
	       
}
