package com.esprit.spring.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Basket;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Facture;
import com.esprit.spring.repository.FactureRepository;


@Service
public class FactureServiceImpl implements FactureService{

	@Autowired
    private FactureRepository factureRepo;
	
	
	//////////***trouver la facture par panier id***////////////

	@Override
	public Facture findFactureByPanier(Basket b) {
		
		return factureRepo.findMyFactureJPQL(b);
	}

	@Override
	public List<Facture> findMyBills(Client id) {
		// TODO Auto-generated method stub
		return factureRepo.getAllMyBills(id);
	}

	@Override
	public void deleteMyBill(Long idFacture) {
		factureRepo.deleteById(idFacture);
		
	}

	@Override
	public List<Facture> getAllBills() {
		// TODO Auto-generated method stub
		return factureRepo.findAll();
	}

	@Override
	public void deleteFacture(Long idFacture) {
		factureRepo.deleteById(idFacture);		
	}

	



}
