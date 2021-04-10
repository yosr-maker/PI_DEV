package com.esprit.spring.services;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

import com.esprit.spring.entites.Basket;
import com.esprit.spring.entites.Client;
import com.esprit.spring.entites.Command_line;
import com.esprit.spring.entites.Product;
import com.esprit.spring.entites.Stock;
import com.esprit.spring.repository.BasketRepository;
import com.esprit.spring.repository.ClientRepository;
import com.esprit.spring.repository.CommandLineRepository;
import com.esprit.spring.repository.ProductRepository;
import com.esprit.spring.repository.StockRepository;







@Service
public class BasketServiceImpl  implements BasketService{
	
	@Autowired
	StockRepository stockRepository; 
	
	@Autowired
	CommandLineRepository commandLineRepository;
	
	@Autowired
	BasketRepository basketRepository;
	
	@Autowired
	ClientRepository clientRepository;
	
	@Autowired
	ProductRepository productRepository;
	private static final org.apache.logging.log4j.Logger l= LogManager.getLogger(BasketService.class);
	//List<Command_line> Lcl = commandLineRepository.findAll();
	@Override
	public List<Basket> retrieveAllBaskets() {
		List<Basket> baskets= (List<Basket>) basketRepository.findAll();
		for(Basket basket:baskets) {
			l.info("basket :" + basket);
		}
		return baskets;
	}

	@Override
	public Basket addBasket(Basket basket) {
		
		return basketRepository.save(basket) ;
	}

	@Override
	public void deleteBasket(Long basketId) {
		basketRepository.deleteById(basketId);
		
	}

	@Override
	public Basket updateBasket(Basket basket) {
	
		return basketRepository.save(basket);
	}

	@Override
	public Basket retrieveBasket(Long basketId) {
		
		return basketRepository.findById(basketId).get();
	}

	

	
	@Override
	public void viderMaBasket(Long basketId) {
		Basket b = basketRepository.findById(basketId).get();
		b.setCommandLine(null);
		//((List<Basket>) b.getCommandLine()).clear();
		b.setPrixTotal(0f);
		b.setQuantiteTotale(0);
		
		basketRepository.save(b);
		
		
	}
//calculer la somme de mes achats 
	@Override
	public float SumOfMyPurchases() {
	/*	ArrayList lb = new ArrayList();
		float somme=0f;
		for(Basket b :) {
			somme+=b.getPrixTotal();
		}
		return somme;*/
		Map<Long,Command_line>   cl = new HashMap<Long ,Command_line>();
		float total = 0;
		for(Command_line  lc1 : cl.values())
			total+=((Product) lc1.getProducts()).getPrice()*lc1.getQuantityPurchased();
		
		return total;
		
	}

	@Override
	 public void ValidateMyBasket(Long id) {
		basketRepository.findMyValidBasketJPQL(id);
		
	}
//ajouter un prosuit au basket ent testant son existance dans le paier et dans le stock 
	
	
	public List<Command_line> MyCommandLine(Long basketId){
		return (List<Command_line>) basketRepository.findById(basketId).get().getCommandLine();
		
	}
		
		
	public List<Command_line> CommandLinesOfMyBasket(Client client){
		return basketRepository.findMyBasketCommandLines(client);
	}
	
	public Basket findMyLastBasket(Long id) {
		List<Basket> mybaskets = basketRepository.findMyValidBasketJPQL(id);
		return  mybaskets.get(mybaskets.size()-1);
	}
	
	public float SommeDeMesAchats(Long id) {
		float somme= 0f;
		for(Basket b : basketRepository.findMyValidBasketJPQL(id)) {
			somme=+b.getPrixTotal();
		}
		
		
		return somme;
	
		
	}
	
	@Override
	public List<Basket> getAllValidBaskets() {
		// TODO Auto-generated method stub
		return basketRepository.findAllValidBaskets();
	}
	
	/*
	//retourner chaque produit et la somme de son prix de vente
	public Map<String,Long> ProductsByBasket() {
		List<String> list = new ArrayList<>();
		Map<String, Long> map = new HashMap<>();
		for(Command_line cl:basketRepository.getAllCommandLineOfValidBasket()) {
			
			if(!(list.contains(cl.getProducts().get()))) {
				text.add(pl.getProduit().getName());
			}
		}
		
		for(String word : text) {
			for(Product_Line pl:panierRepository.getAllProdLinesOfValidChart()) {
				if(pl.getProduit().getName().equals(word)) {
				 Integer times = map.get(word);
			        if(times == null) {
			           map.put(word, (int) pl.getPrix());
			        } else {
			           map.put(word, times + (int) pl.getPrix());
			        }
			}
		}
			}
		return map;
		
	}
	*/
	
		
		
		
		
		
		
		
	@Override	
	public Command_line addProductBasket(Long idcl, Long idp) {
		return null;
   /* Command_line cl = new Command_line();
	List<Command_line> Lcl = commandLineRepository.findAll();
	List<Product> Lp = productRepository.findAll();
	for(Command_line x : Lcl) {
		if(x.getId()==idcl) {
			cl = x;
		}
	}	
	System.out.println(cl.getId());
	//Basket b = basketRepository.findOne(null);
	//Stock s = new Stock();
	Product p = new Product();
	for(Product p1 : Lp) {
		if(p1.getId()==idcl) {
			p = p1;
		}
	}	
	System.out.println(p.getId());
	if( cl.getId()>0 ) {
		 Long q = p.getQuantity()+1;
		p.setQuantity(q);
		
		p.getPrice();
		//s.setQuantiteInstan( (s.getQuantiteInstan()-1));
		 cl.getProduct();
		 cl.save(p);
		System.out.print("ajout au panier avec succes ");
		 
	}else {

         System.out.println("else");
		/*p.setQuantity((long) 0);
		s.setQuantiteInstan((long) 0);*/
		//cl.getProducts().clear();
	/*	
	}
	commandLineRepository.save(cl);
	//stockRepository.save(s);
	
	return  cl;	}*/
	}
	

	@Override
	public String incrementProductBasket(Product p, float quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String decrementProductBasket(Product p, float quantity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Command_line> consulteListCl() {
		// TODO Auto-generated method stub
		return null;
	}

	
	
	/*if(cl.get(p).getId()==null && s.getProduct()!= null ) {
		Command_line cl1 = new Command_line();
		cl1.setProducts((List<Product>) p);
		cl1.setQuantityPurchased(quantity);
		cl1.setPrixToPay(p.getPrice());
	}else 
	{
		Command_line cl1 =cl.get(p);
		cl1.setQuantityPurchased(cl1.getQuantityPurchased()+quantity);
		
	}
			 boolean isHere=true;
	Basket b =basketRepository.getOne(basId);
	
		return cl;
	}*/
//incrementer la qte d'un produit 
/*	@Override
	public String incrementProductBasket(Product p , float quantity) {
		Map<Long,Command_line>  cl = new HashMap<Long ,Command_line>();
		Stock s = new Stock();
		
		if(cl.get(p).getId()!=null && s.getProduct()!= null ) {
			Command_line cl1 = new Command_line();
			cl1.setProducts((List<Product>) p);
			cl1.setQuantityPurchased(quantity+=p.getQuantity()+quantity);
			cl1.setPrixToPay(p.getPrice()*p.getQuantity());
		}else 
		{
			Command_line cl1 =cl.get(p);
			((Product) cl1.getProducts()).setQuantity(0);
			s.setQuantiteInstan(0);
			
		}
		return cl.toString();*/
		
	
/*
	////decrementer la qte d'un produit 
@Override
	public String decrementProductBasket(Product p , Long quantity) {
		Map<Long,Command_line>  cl = new HashMap<Long ,Command_line>();
		Stock s = new Stock();
		
		if(cl.get(p).getId()!=null && s.getProduct()!= null || s.getProduct()==null) {
			Command_line cl1 = new Command_line();
			
			cl1.setQuantityPurchased(quantity-=p.getQuantity()-quantity);
			cl1.setPrixToPay(p.getPrice()*p.getQuantity());
			s.setQuantiteInstan((int) (p.getQuantity()+quantity));
		}else 
		{
			Command_line cl1 =cl.get(p);
			((Product) cl1.getProducts()).setQuantity(0);
			s.setQuantiteInstan(0);
			
		}
		return cl.toString();
		
	}

	*/
//recuperer la liste des cl 
	
	 
	public String affecterBasketToClient(Long idb,Long idc) {
		Client c = clientRepository.findById(idc).get();
		Basket b = basketRepository.findById(idb).get();
		
		b.setClient(c);
		basketRepository.save(b);
		return "affecter Basket to client";
		
	}

	

}
	


