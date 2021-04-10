package com.esprit.spring.services;

import java.util.Collection;
import java.util.List;
import java.util.Map;

import com.esprit.spring.entites.Basket;
import com.esprit.spring.entites.Command_line;
import com.esprit.spring.entites.Product;

public interface BasketService {

	List< Basket> retrieveAllBaskets();
	Basket addBasket( Basket basket);
	void deleteBasket (Long basketId);		
	Basket updateBasket(Basket basket);
	Basket retrieveBasket(Long basketId);
	
	
	public float SumOfMyPurchases();
	public List<Basket> getAllValidBaskets();
	public String incrementProductBasket(Product p , float quantity);
	//public void desaffectProdLineFromChart(int PlId);
	public String decrementProductBasket(Product p , float quantity);
	void viderMaBasket(Long basketId);
	public Collection<Command_line> consulteListCl();
	public Command_line addProductBasket(Long idcl,Long idp);
	void ValidateMyBasket(Long id);
	
	
}
