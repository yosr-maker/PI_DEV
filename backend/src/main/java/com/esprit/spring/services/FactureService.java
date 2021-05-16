package com.esprit.spring.services;

import java.util.List;

import com.esprit.spring.entites.Basket;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Facture;



public interface FactureService {
	
	public Facture findFactureByPanier(Basket b);
	public List<Facture> findMyBills(Client id);
	public void deleteMyBill(Long idFacture);
	public List<Facture> getAllBills();
	public void deleteFacture(Long idFacture);

}
