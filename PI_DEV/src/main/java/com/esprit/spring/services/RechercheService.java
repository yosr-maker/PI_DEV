package com.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Recherche;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.RechercheRepository;


	@Service
	public class RechercheService implements RechercheServiceI{
		
		@Autowired
		RechercheRepository rechercheRepository;
		
		@Autowired
		ClientRepository clientRepository;
		
		@Override
		public String extract(Long idClient){
			 
			Long max = rechercheRepository.lemax(idClient);
			
			String type = rechercheRepository.extract(max);
			 
			 
			 return type;
			
		}
		
		
		
		@Override
		public Recherche addSearch(Recherche recherche,Long idClient){
		
			Client clt = clientRepository.findById(idClient).get();
			
			String t = recherche.getType();
		
			Recherche r = rechercheRepository.findByTypeAndClient(t, clt);
			
			Long a = 1L;
			///si la recherche sur ce type n'existe pas : 
			if(r==null) {
				
				recherche.setClient(clt);
				recherche.setNbr(a);
				rechercheRepository.save(recherche);
			}
			else {
				
				//get nbr from recherche et incrémenter nbr 
				Long count = r.getNbr()+a;
				
				//modifier le recherche et enregistrer
				r.setNbr(count);
				recherche=r;
				rechercheRepository.save(recherche);
			}
		return recherche;
				
			}

		
		


}
