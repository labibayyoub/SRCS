package com.upmc.enterprise.ejb;

import javax.ejb.Local;

import com.upmc.entreprise.product.Product;

@Local
public interface Cart {
	
	void addToCart(Product p);
	void checkOut();

}
