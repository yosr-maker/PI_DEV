package com.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Basket;
import com.esprit.spring.entites.Facture;
import com.esprit.spring.entites.Visitor;
import com.esprit.spring.repository.BasketRepository;
import com.esprit.spring.repository.VisitorRepository;


@Service
public class VisitorServiceImpl implements VisitorService {
	@Autowired
	BasketRepository basketRepository;
	@Autowired
	VisitorRepository visitorRepository;
	
	public String affecterBasketToVisitor(Long idb,int idv) {
		return null;
		
	/*	Basket b = basketRepository.findById(idb).get();
		
		Visitor v = visitorRepository.findById(idv).get();
		
		v.setBasket(b);
		visitorRepository.save(v);
		
		return "affecterBasketToVisitor";*/
		
	}
}
