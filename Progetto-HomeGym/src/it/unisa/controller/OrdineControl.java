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
import javax.servlet.http.HttpSession;

import it.unisa.model.DAOS.ComposizioneDM;
import it.unisa.model.DAOS.OrdineDM;
import it.unisa.model.DAOS.ProductModelDM;
import it.unisa.model.beans.Carrello;
import it.unisa.model.beans.ComposizioneBean;
import it.unisa.model.beans.OrdineBean;
import it.unisa.model.beans.ProductBean;
import it.unisa.model.beans.UtenteBean;

@WebServlet("/OrdineControl")
public class OrdineControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private OrdineDM ordineDAO = new OrdineDM();
	private ComposizioneDM composizioneDM = new ComposizioneDM();
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session != null) {
			UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
			if(utente == null) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/login.jsp");
				dispatcher.forward(request, response);
			}
			
			String action = request.getParameter("action");
					
			if(action.equals("checkout")) {
				Carrello carrello = (Carrello) request.getSession().getAttribute("carrello");
				ArrayList<ProductBean> prodotti = carrello.getProducts();
				if(prodotti.size() == 0) {
					request.setAttribute("operazione", "Il carrello è vuoto, visita il nostro catalogo");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
					dispatcher.forward(request, response);
				}
				
				OrdineBean ordine = new OrdineBean();
				try {
					ordine.setID(ordineDAO.getIdCodice());
				} catch (SQLException e) {
					e.printStackTrace();
				}
				ordine.setData(new Date());
				ordine.setStato("Ordinato");
				ordine.setIndirizzoSpedizione("1111");
				ordine.setUtente(utente.getEmail());
				ordine.setTotale(carrello.getTotale());
				try {
					ordineDAO.doSave(ordine);
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				for(ProductBean product : prodotti) {
					ComposizioneBean composizione = new ComposizioneBean();
					composizione.setOrdine(ordine.getID());
					composizione.setProdotto(product.getCodice());
					composizione.setQuantita(product.getQtaCarrello());
					composizione.setPrezzoAcquisto(product.getPrezzo());
					composizione.setIvaAcquisto(product.getIva());
					try {
						composizioneDM.doSave(composizione);
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				request.getSession().removeAttribute("carrello");
				carrello = new Carrello();
				request.getSession().setAttribute("carrello", carrello);
				request.setAttribute("operazione", "Il tuo ordine è stato preso in carico");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("dettagliOrdine")) {
				int id = Integer.parseInt(request.getParameter("id"));
				ArrayList<ProductBean> products = new ArrayList<ProductBean>();
				
				try {
					ArrayList<ComposizioneBean> composizioni = composizioneDM.doRetrieveByOrdine(id);
					
					ProductModelDM productDAO = new ProductModelDM();
					for(ComposizioneBean composizione : composizioni) {
						ProductBean product = productDAO.doRetrieveByKey(composizione.getProdotto());
						product.setPrezzo(composizione.getPrezzoAcquisto());
						product.setIva(composizione.getIvaAcquisto());
						product.setQtaCarrello(composizione.getQuantita());
						products.add(product);
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				request.setAttribute("dettagliOrdine", products);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/dettagliOrdine.jsp");
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
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
