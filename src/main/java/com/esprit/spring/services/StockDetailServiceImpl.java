package com.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;

import com.esprit.spring.entites.StockDetail;
import com.esprit.spring.repository.StockDetailRepository;

public class StockDetailServiceImpl implements IStockDetailService{
	
	
	
	@Autowired
	StockDetailRepository stockDetailRepository;

	@Override
	public void addStockDetail(StockDetail stockDetail) {
		// TODO Auto-generated method stub
		//stockDetailRepository.save(stockDetail);
	}

	@Override
	public void deleteStockDetailById(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public StockDetail updatestockDetail(StockDetail stock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public StockDetail getStockDetailById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<StockDetail> getAllStockDetail() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteAllStockDetail() {
		// TODO Auto-generated method stub
		
	}

	
}
