package com.upmc.enterprise.ejb;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;
import javax.ejb.Stateful;
import javax.ejb.StatefulTimeout;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.*;


import com.upmc.entreprise.product.Product;

@Stateful
@StatefulTimeout (unit = TimeUnit.MINUTES,value = 20)
public class CartBean implements Cart {
	@PersistenceContext (unitName = "pc",  type= PersistenceContextType.EXTENDED)
	private EntityManager em;
	private List<Product> cart;
	
	
	
	@PostConstruct
	public void intialize() {
		cart = new ArrayList<>();
	}
	

	@Override
	public void addToCart(Product p) {
		cart.add(p);
		
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	@Override
	public void checkOut() {
		for (Product product : cart) 
			em.persist(product);
		cart.clear();
			
		
		
	}

}
