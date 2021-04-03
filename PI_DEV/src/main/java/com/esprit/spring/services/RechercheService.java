package com.esprit.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Recherche;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.RechercheRepository;



@Service

public class RechercheService  implements RechercheServiceI{
	
		
		@Autowired
		private RechercheRepository rechercheRepository;
		
		@Autowired
		private ClientRepository clientRepository;
		
		//Long id_user
		public String extract(Long id_client){
			 
			Long max = rechercheRepository.lemax(id_client);
			
			String type = rechercheRepository.extract(max);
			 
			 
			 return type;
			
		}
		
		
		
		
		public Recherche addSearch(Recherche rech,Long client_id){
			//le user introduit :
			Client c = clientRepository.findById(client_id).get();
			//le type introduit :
			String t = rech.getType();
			//la recherche sur ce type :
			Recherche r = rechercheRepository.findByTypeAndClient(t, c);
			
			Long a = 1L;
			///si la recherche sur ce type n'existe pas : 
			if(r==null) {
				
				rech.setClient(c);
				rech.setNbr(a);
				rechercheRepository.save(rech);
			}
			else {
				
				//get nbr from recherche et incrémenter nbr 
				Long count = r.getNbr()+a;
				
				//modifier le recherche et enregistrer
				r.setNbr(count);
				rech=r;
				rechercheRepository.save(rech);
			}
		return rech;
				
			}

		
		

	}



