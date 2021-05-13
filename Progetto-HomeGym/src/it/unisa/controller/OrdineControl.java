package it.unisa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import it.unisa.model.DAOS.OrdineDM;
import it.unisa.model.beans.Carrello;
import it.unisa.model.beans.ComposizioneBean;
import it.unisa.model.beans.OrdineBean;
import it.unisa.model.beans.ProductBean;
import it.unisa.model.beans.UtenteBean;

@WebServlet("/OrdineControl")
public class OrdineControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OrdineDM ordineDAO = new OrdineDM();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean utente = (UtenteBean) request.getSession().getAttribute("Utente");
		if(utente == null) {
			response.sendRedirect("/pages/login.jsp");
		}
		
		String action = request.getParameter("action");
				
		if(action.equals("checkout")) {
			Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
			ArrayList<ProductBean> prodotti = carrello.getProducts();
			if(prodotti.size() == 0) {
				request.setAttribute("indirizzamento", "carelloVuoto");
				response.sendRedirect("/pages/carrello.jsp");
			}
			
			OrdineBean ordine = new OrdineBean();
			try {
				ordine.setID(ordineDAO.getIdCodice());
			} catch (SQLException e) {
				e.printStackTrace();
			}
			ordine.setData(new Date());
			ordine.setStato("Ordinato");
			ordine.setIndirizzoSpedizione("via standard");
			ordine.setUtente(utente.getEmail());
			//ordine.setTotale(carrello.getTotale()); --> modificare la tabella ordine con atributo ridondate totale
			//modificare quindi dao ordine e ordine bean
			
			//composizione 
			
			carrello = new Carrello();
			request.getSession().setAttribute("carrello", carrello);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/carrello.jsp");
			dispatcher.forward(request, response);
		}

		if(action.equals("viewOrdini")) {
			try {
				ArrayList<OrdineBean> ordini = ordineDAO.doRetrieveAllByUtente(utente.getEmail());
				request.setAttribute("ordini", ordini);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/ordiniUtente.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
