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

import it.unisa.model.DAOS.FeedbackDM;
import it.unisa.model.DAOS.ProductModelDM;
import it.unisa.model.beans.Carrello;
import it.unisa.model.beans.FeedbackBean;
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
				int cat = Integer.parseInt(request.getParameter("cat"));
				try {
					prodotti = model.doRetrieveCategoria(cat);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("prodotti", prodotti);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/viewProdotti.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("ViewProdotto")) {
				ProductBean prodotto = null;
				ArrayList<FeedbackBean> f = null;
				FeedbackDM fDAO = new FeedbackDM();
				
				String cod = request.getParameter("codice");
				try {
					prodotto = model.doRetrieveByKey(cod);
					f = fDAO.doRetrieveByProduct(cod);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("feedbacks", f);
				request.setAttribute("prodotto", prodotto);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/prodotto.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("AddToCarrello")) {
				try {
					carrello.addProduct(request.getParameter("codice"));
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.getSession().setAttribute("carrello", carrello);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/carrello.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("RemoveToCarrello")) {
				carrello.removeProduct(request.getParameter("codice"));
				request.getSession().setAttribute("carrello", carrello);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/carrello.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("DeleteToCarrello")) {
				carrello.deleteProduct(request.getParameter("codice"));
				request.getSession().setAttribute("carrello", carrello);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/carrello.jsp");
				dispatcher.forward(request, response);
			}
			
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
