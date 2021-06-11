package it.unisa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.DAOS.DatiPagamentoDM;
import it.unisa.model.DAOS.IndirizzoSpedizioneDM;
import it.unisa.model.beans.DatiPagamentoBean;
import it.unisa.model.beans.IndirizzoSpedizioneBean;
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
			if(action.equals("AddIndirizzoSpedizione")) {
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
			}
			if(action.equals("RimuoviIndirizzoSpedizione")) {
				
			}
			if(action.equals("ModificaDatiPagamento")) {
				String numeroCarta=request.getParameter("numeroCarta");
				int cvv=Integer.parseInt(request.getParameter("cvv"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date dataScadenza=null;
				try {
					dataScadenza=dateFormat.parse(request.getParameter("dataScadenza"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				DatiPagamentoBean datiPagamento=new DatiPagamentoBean();
				datiPagamento.setNumeroCarta(numeroCarta);;
				datiPagamento.setCvv(cvv);
				datiPagamento.setDataScadenza(dataScadenza);
				try {
					datiDAO.doUpdate(datiPagamento);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
			if(action.contentEquals("AddDatiPagamento")) {
				String numeroCarta=request.getParameter("numeroCarta");
				int cvv=Integer.parseInt(request.getParameter("cvv"));
				SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
				Date dataScadenza=null;
				try {
					dataScadenza=dateFormat.parse(request.getParameter("dataScadenza"));
				} catch (ParseException e) {
					e.printStackTrace();
				}
				DatiPagamentoBean datiPagamento=new DatiPagamentoBean();
				datiPagamento.setNumeroCarta(numeroCarta);;
				datiPagamento.setCvv(cvv);
				datiPagamento.setDataScadenza(dataScadenza);
				try {
					datiDAO.doSave(datiPagamento);
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			}
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
