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

import it.unisa.model.DAOS.AziendaDM;
import it.unisa.model.DAOS.DatiPagamentoDM;
import it.unisa.model.DAOS.FeedbackDM;
import it.unisa.model.DAOS.IndirizzoSpedizioneDM;
import it.unisa.model.DAOS.PersonaFisicaDM;
import it.unisa.model.DAOS.ProductModelDM;
import it.unisa.model.DAOS.UtenteDM;
import it.unisa.model.beans.AziendaBean;
import it.unisa.model.beans.DatiPagamentoBean;
import it.unisa.model.beans.FeedbackBean;
import it.unisa.model.beans.IndirizzoSpedizioneBean;
import it.unisa.model.beans.PersonaFisicaBean;
import it.unisa.model.beans.ProductBean;
import it.unisa.model.beans.UtenteBean;


@WebServlet("/UtenteControl")
public class UtenteControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IndirizzoSpedizioneDM indirizzoDAO= new IndirizzoSpedizioneDM();
	private DatiPagamentoDM datiDAO= new DatiPagamentoDM();
    	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		HttpSession session = request.getSession(false);
		if(session != null) {
			UtenteBean utente = (UtenteBean) session.getAttribute("Utente");
			if(utente == null) {
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/login.jsp");
				dispatcher.forward(request, response);
			}
			String action=request.getParameter("action");
			
			if(action.equals("viewDatiPagamentoSpedizione")) {
				try {
					DatiPagamentoBean dati = datiDAO.doRetrieveByKey(utente.getDatiPagamento());
					request.setAttribute("datiPagamento", dati);
					ArrayList<IndirizzoSpedizioneBean> indirizzi = indirizzoDAO.doRetrieveByUtente(utente.getEmail());
					request.setAttribute("indirizzi", indirizzi);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/viewDatiPagamentoSpedizione.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("addIndirizzoSpedizione")) {
				String via=request.getParameter("via");
				String cap=request.getParameter("cap");
				String citta=request.getParameter("citta");
				IndirizzoSpedizioneBean indirizzo=new IndirizzoSpedizioneBean();
				indirizzo.setVia(via);
				indirizzo.setCap(cap);
				indirizzo.setCitta(citta);
				indirizzo.setUtente(utente.getEmail());
				try {
					indirizzoDAO.doSave(indirizzo);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("operazione", "L'aggiunta dell'indirizzo di spedizione è avvenuta correttamente");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
				dispatcher.forward(request, response);
			}
			if(action.equals("rimuoviIndirizzoSpedizione")) {
				int id = Integer.parseInt(request.getParameter("idIndirizzo"));
				try {
					indirizzoDAO.doDelete(id);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("operazione", "La rimozione dell'indirizzo di spedizione è avvenuta correttamente");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
				dispatcher.forward(request, response);
			}
			if(action.equals("rimuoviDatiPagamento")) {
				String numeroCarta=request.getParameter("carta");
				try {
					datiDAO.doDelete(numeroCarta);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("operazione", "La rimozione dei Dati di Pagamento è avvenuta correttamente");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("addDatiPagamento")) {
				String numeroCarta=request.getParameter("carta");
				int cvv=Integer.parseInt(request.getParameter("cvv"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date dataScadenza=null;
				try {
					dataScadenza=dateFormat.parse(request.getParameter("data"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				DatiPagamentoBean datiPagamento=new DatiPagamentoBean();
				datiPagamento.setNumeroCarta(numeroCarta);;
				datiPagamento.setCvv(cvv);
				datiPagamento.setDataScadenza(dataScadenza);
				utente.setDatiPagamento(numeroCarta);
				try {
					datiDAO.doSave(datiPagamento);
					UtenteDM uDAO = new UtenteDM();
					uDAO.doUpdate(utente);
				} catch (SQLException e) {
					e.printStackTrace();
					request.setAttribute("operazione", "Si è verificato un errore. Ci scusiamo per il disagio.");
					RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
					dispatcher.forward(request, response);
				}
				request.setAttribute("operazione", "L'aggiunta dei Dati di Pagamento è avvenuta correttamente");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("feedback")) {
				ProductModelDM prodottoDAO = new ProductModelDM();
				ArrayList<ProductBean> prodotti = prodottoDAO.doRetrieveProductBuy(utente.getEmail());
				request.setAttribute("prodottiBuy", prodotti);
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/feedback.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("valutazione")) {
				FeedbackBean f = new FeedbackBean();
				f.setValutazione(Integer.parseInt(request.getParameter("val")));
				f.setCommento(request.getParameter("commento"));
				f.setEmail(request.getParameter("utente"));
				f.setProdotto(request.getParameter("prodotto"));
				
				FeedbackDM feedbackDAO = new FeedbackDM();
				try {
					feedbackDAO.doSave(f);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				request.setAttribute("operazione", "Grazie per il tuo feedback. Il tuo parere per noi è molto importante.");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
				dispatcher.forward(request, response);
			}
			
			if(action.equals("viewDatiAnagrafica")) {
				PersonaFisicaBean persona = null;
				AziendaBean azienda = null;
				
				if(utente.getTipo().equalsIgnoreCase("persona fisica")) {
					PersonaFisicaDM personaDAO = new PersonaFisicaDM();
					try {
						 persona = personaDAO.doRetrieveByEmail(utente.getEmail());
						 request.setAttribute("anagrafica", persona);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				if(utente.getTipo().equalsIgnoreCase("azienda")) {
					AziendaDM aziendaDAO = new AziendaDM();
					try {
						azienda = aziendaDAO.doRetrieveByEmail(utente.getEmail());
						request.setAttribute("anagrafica", azienda);
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
				
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/datiAnagrafici.jsp");
				dispatcher.forward(request, response);
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
