package it.unisa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.DAOS.ProductModelDM;
import it.unisa.model.beans.Carrello;
import it.unisa.model.beans.ProductBean;

@WebServlet("/ProductControl")
public class ProductControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static ProductModelDM model = new ProductModelDM();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CARRELLO
		Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
		if(carrello == null) {
			carrello = new Carrello();
			request.getSession().setAttribute("carrello", carrello);
		}
		//FINE CARRELLO
				
		String action = request.getParameter("action");
		
		if(action != null) {
			if(action.equals("ViewProdotti")) {
				ArrayList<ProductBean> prodotti = null;
				try {
					prodotti = model.doRetrieveAll(null);
				} catch (SQLException e) {
					System.out.println("Errore ProductControl doRetrieveAll");
					e.printStackTrace();
				}
				request.setAttribute("prodotti", prodotti);
			}
			
			if(action.equals("ViewProdotto")) {
				ProductBean prodotto = null;
				try {
					prodotto = model.doRetrieveByKey(request.getParameter("codice"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("prodotto", prodotto);
				response.sendRedirect("/pages/prodotto.jsp");
			}
			
			if(action.equals("AddToCarrello")) {
				try {
					carrello.addProduct(request.getParameter("codice"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				response.sendRedirect("/pages/carrello.jsp");
			}
			
			if(action.equals("RemoveToCarrello")) {
				carrello.removeProduct(request.getParameter("codice"));
				response.sendRedirect("/pages/carrello.jsp");
			}
			
			if(action.equals("DeleteToCarrello")) {
				carrello.deleteProduct(request.getParameter("codice"));
				response.sendRedirect("/pages/carrello.jsp");
			}
			
			request.getSession().setAttribute("carrello", carrello);
			request.setAttribute("carrello", carrello);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/viewProdotti.jsp");
			dispatcher.include(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
