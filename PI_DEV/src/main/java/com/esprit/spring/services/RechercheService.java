//package com.esprit.spring.services;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.esprit.spring.entites.Client;
//import com.esprit.spring.entites.Recherche;
//import com.esprit.spring.repository.ClientRepository;
//import com.esprit.spring.repository.RechercheRepository;
//
//
//
//	@Service
//	public class RechercheService implements RechercheServiceI{
//		
//		@Autowired
//		private RechercheRepository var;
//		
//		@Autowired
//		private ClientRepository var1;
//		
//		//Long id_user
//		@Override
//		public String extract(Long id_client){
//			 
//			Long max = var.lemax(id_client);
//			
//			String type = var.extract(max);
//			 
//			 
//			 return type;
//			
//		}
//		
//		
//		
//		
//		@Override	
//		public Recherche addSearch(Recherche rech,Long id_client){
//			//le client introduit :
//			Client c = var1.findById(id_client).get();
//			//le type introduit :
//			String t = rech.getType();
//			//la recherche sur ce type :
//			Recherche r = var.findByTypeAndClient(t, c);
//			
//			Long a = 1L;
//			///si la recherche sur ce type n'existe pas : 
//			if(r==null) {
//				
//				rech.setClient(c);
//				rech.setNbr(a);
//				var.save(rech);
//			}
//			else {
//				
//				//get nbr from recherche et incrémenter nbr 
//				Long count = r.getNbr()+a;
//				
//				//modifier le recherche et enregistrer
//				r.setNbr(count);
//				rech=r;
//				var.save(rech);
//			}
//		return rech;
//				
//			}
//
//
//
//
//		@Override
//		public Recherche addSearch(Recherche rech, int i) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//
//
//
//		@Override
//		public String extract(int i) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//
//		
//		
//
//	}
//
//
//
