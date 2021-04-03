package com.esprit.spring.services;

import com.esprit.spring.entites.StockDetail;

public interface IStockDetailService {
	
	public void  addStockDetail(StockDetail stockDetail);
	public void  deleteStockDetailById(int id);
	public StockDetail  updatestockDetail(StockDetail stock);
	public StockDetail getStockDetailById(int id);
	public Iterable<StockDetail> getAllStockDetail();
	public void deleteAllStockDetail();

}
