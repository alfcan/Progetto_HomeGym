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
					System.out.println("Errore ProductControll doRetrieveAll");
					e.printStackTrace();
				}
				request.setAttribute("prodotti", prodotti);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/viewProdotti.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("ViewProdotti")) {
				ProductBean prodotto = null;
				try {
					prodotto = model.doRetrieveByKey(request.getParameter("codice"));
				} catch (SQLException e) {
					System.out.println("Errore ProductControll doRetrieveAll");
					e.printStackTrace();
				}
				request.setAttribute("prodotto", prodotto);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/prodotto.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("AddToCarrello")) {
				carrello = (Carrello) request.getSession().getAttribute("carrello");
				try {
					carrello.addProduct(request.getParameter("codice"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getSession().setAttribute("carrello", carrello);
			}
			
			if(action.equals("RemoveToCarrello")) {
				carrello = (Carrello) request.getSession().getAttribute("carrello");
				carrello.removeProduct(request.getParameter("codice"));
				request.getSession().setAttribute("carrello", carrello);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/carrello.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("DeleteToCarrello")) {
				carrello = (Carrello) request.getSession().getAttribute("carrello");
				carrello.deleteProduct(request.getParameter("codice"));
				request.getSession().setAttribute("carrello", carrello);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/Carrello.jsp");
				dispatcher.forward(request, response);				
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
