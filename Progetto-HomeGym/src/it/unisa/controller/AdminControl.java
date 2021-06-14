package it.unisa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
import it.unisa.model.DAOS.FeedbackDM;
import it.unisa.model.DAOS.IndirizzoSpedizioneDM;
import it.unisa.model.DAOS.OrdineDM;
import it.unisa.model.DAOS.ProductModelDM;
import it.unisa.model.DAOS.UtenteDM;
import it.unisa.model.beans.ComposizioneBean;
import it.unisa.model.beans.FeedbackBean;
import it.unisa.model.beans.IndirizzoSpedizioneBean;
import it.unisa.model.beans.OrdineBean;
import it.unisa.model.beans.ProductBean;
import it.unisa.model.beans.UtenteBean;

@WebServlet("/AdminControl")
public class AdminControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
		if(utente == null && !utente.getTipo().equalsIgnoreCase("admin")) {
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/index.jsp");
			dispatcher.forward(request, response);
		}
		
		String action = request.getParameter("action");
		
		if(action.equals("gestioneClienti")) {
			UtenteDM search = new UtenteDM();
			ArrayList <UtenteBean> result	= new ArrayList <UtenteBean>();
			try {
				result = search.doRetrieveAll(null);
			} catch (SQLException e1) {
				e1.printStackTrace();
				e1.getMessage();
			}
			request.setAttribute("listaUtenti", result);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/admin/adminClienti.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("gestioneCatalogo")) {
			ProductModelDM search = new ProductModelDM();
			ArrayList <ProductBean> result	= new ArrayList <ProductBean>();
			try {
				result = search.doRetrieveAll(null);
			} catch (SQLException e) {
				e.printStackTrace();
				e.getMessage();
			}
			
			request.setAttribute("listaProdotti", result);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/admin/adminCatalogo.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("gestioneOrdini")) {
			OrdineDM search = new OrdineDM();
			ArrayList<OrdineBean> listor=new ArrayList<OrdineBean>();
			try {
				listor  = search.doRetrieveAll(null);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("ordini", listor);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/admin/adminOrdini.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("viewOrdinePerData")) {
			SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date da = null;
			Date a = null;
			try {
				da = dateFormat.parse(request.getParameter("dataDa"));
				a = dateFormat.parse(request.getParameter("dataA"));
			} catch (ParseException e1) {
				e1.printStackTrace();
			}
			
			OrdineDM search = new OrdineDM();
			ArrayList<OrdineBean> listor = new ArrayList<OrdineBean>();
			try {
				listor  = search.doRetrieveByDate(da, a);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("ordini", listor);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/admin/adminOrdini.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("viewOrdine")) {
			ComposizioneDM model = new ComposizioneDM();
			IndirizzoSpedizioneDM indirizzoDAO = new IndirizzoSpedizioneDM();
			OrdineDM ordineDAO = new OrdineDM();
			
			int id = Integer.parseInt(request.getParameter("idOrdine"));
			ArrayList<ProductBean> products = new ArrayList<ProductBean>();
			IndirizzoSpedizioneBean indirizzo = null;
			
			try {
				ArrayList<ComposizioneBean> composizioni = model.doRetrieveByOrdine(id);
				
				ProductModelDM productDAO = new ProductModelDM();
				for(ComposizioneBean composizione : composizioni) {
					ProductBean product = productDAO.doRetrieveByKey(composizione.getProdotto());
					product.setQtaCarrello(composizione.getQuantita());
					products.add(product);
				}
				OrdineBean o = ordineDAO.doRetrieveByKey(id);
				indirizzo = indirizzoDAO.doRetrieveByKey(Integer.parseInt(o.getIndirizzoSpedizione()));
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String indCompleto = indirizzo.getVia() + " Città " + indirizzo.getCitta() + " CAP " + indirizzo.getCap();
			request.setAttribute("dettagliOrdine", products);
			request.setAttribute("indirizzo", indCompleto);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/dettagliOrdine.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("ordiniUtente")) {
			OrdineDM model = new OrdineDM();
			String utente1 = request.getParameter("utente");
			try {
				ArrayList<OrdineBean> ordini = model.doRetrieveAllByUtente(utente1);
				request.setAttribute("ordini", ordini);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/ordiniUtente.jsp");
			dispatcher.forward(request, response);
		}
		
		/*if(action.equals("eliminaProdotto")) {
			ProductModelDM model = new ProductModelDM();
			String codice = request.getParameter("prodotto");
			try {
				model.doDelete(codice);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("operazione", "L'eliminazione del prodotto è avvenuta con successo");
			response.sendRedirect("pages/operazione.jsp");
		}*/
		
		if(action.equals("aggiungiProdotto")) {
			ProductBean product = new ProductBean();
			product.setCodice(request.getParameter("codice"));
			product.setNome(request.getParameter("nome"));
			product.setDescrizione(request.getParameter("descrizione"));
			product.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
			product.setIva(Integer.parseInt(request.getParameter("iva")));
			product.setQtaMagazzino(Integer.parseInt(request.getParameter("qtaMagazzino")));
			product.setIdCategoria(Integer.parseInt(request.getParameter("categoria")));
			product.setUrlImmagine("fotoProdotti/"+request.getParameter("img"));
			
			ProductModelDM model = new ProductModelDM();
			try {
				model.doSave(product);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("operazione", "L'aggiunta del prodotto al catalogo è avvenuta con successo");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("modificaProdotto")) {
			ProductBean product = new ProductBean();
			product.setCodice(request.getParameter("codice"));
			product.setNome(request.getParameter("nome"));
			product.setDescrizione(request.getParameter("descrizione"));
			product.setPrezzo(Double.parseDouble(request.getParameter("prezzo")));
			product.setIva(Integer.parseInt(request.getParameter("iva")));
			product.setQtaMagazzino(Integer.parseInt(request.getParameter("qtaMagazzino")));
			product.setIdCategoria(Integer.parseInt(request.getParameter("categoria")));
			product.setUrlImmagine("fotoProdotti/"+request.getParameter("img"));
			
			ProductModelDM model = new ProductModelDM();
			try {
				model.doUpdate(product);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			request.setAttribute("operazione", "La modifica del prodotto al catalogo è avvenuta con successo");
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
			dispatcher.forward(request, response);
		}
		
		if(action.equals("feedbackUtente")) {
			FeedbackDM feedbackDAO = new FeedbackDM();
			ArrayList<FeedbackBean> feedbacks = null;
			try {
				feedbacks = feedbackDAO.doRetrieveByUtente(request.getParameter("utente"));
			} catch (SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("feedbackUtente", feedbacks);
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/admin/feedbackUtente.jsp");
			dispatcher.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
