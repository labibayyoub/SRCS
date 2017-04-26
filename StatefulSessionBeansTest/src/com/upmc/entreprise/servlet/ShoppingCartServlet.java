package com.upmc.entreprise.servlet;

import java.io.IOException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.upmc.enterprise.ejb.Cart;
import com.upmc.enterprise.ejb.CartBean;
import com.upmc.entreprise.product.Product;

/**
 * Servlet implementation class ShoppingCartServlet
 */
@WebServlet("/ShoppingCartServlet")
public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String CART_SESSION_KEY = "shoppingCart";


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ShoppingCartServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SERVLET");
		Cart c=(CartBean)  request.getSession().getAttribute(CART_SESSION_KEY);
		if(c==null){
			InitialContext ic;
			try {
				ic = new InitialContext();
				c=(Cart)ic.lookup("java:global/StatefulEJBEAR/StatefulSessionBeansEJB/CartBean!"
						+ "com.upmc.enterprise.ejb.Cart");
				request.getSession().setAttribute(CART_SESSION_KEY, c);

			} catch (NamingException e) {


				e.printStackTrace();
			}
			String productName = request.getParameter("product");
			if(productName!=null && productName.length()>0){
				Product p = new Product();
				p.setType(productName);
				c.addToCart(p);
				System.out.println("product "+productName+" added");

			}
			String checkOut = request.getParameter("checkout");
			if(checkOut!=null && checkOut.equalsIgnoreCase("yes")){
				c.checkOut();
				System.out.println("checked out !!!	");

			}


		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
