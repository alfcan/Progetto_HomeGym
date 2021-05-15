package it.unisa.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.DAOS.AziendaDM;
import it.unisa.model.DAOS.PersonaFisicaDM;
import it.unisa.model.DAOS.UtenteDM;
import it.unisa.model.beans.AziendaBean;
import it.unisa.model.beans.PersonaFisicaBean;
import it.unisa.model.beans.UtenteBean;

@WebServlet("/RegistrazioneControl")
public class RegistrazioneControl extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		UtenteBean utente = new UtenteBean();
		utente.setEmail(request.getParameter("email"));
		utente.setPassword(request.getParameter("password"));
		utente.setTipo(request.getParameter("tipo"));
		
		UtenteDM utenteDAO = new UtenteDM();
		try {
			utenteDAO.doSave(utente);
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	
		if(request.getParameter("tipo").equals("Azienda")) {
			AziendaBean azienda = new AziendaBean();
			azienda.setRagioneSociale(request.getParameter("ragioneSociale"));
			azienda.setPartitaIva(request.getParameter("partitaIva"));
			azienda.setCitta(request.getParameter("citta"));
			azienda.setIndirizzoSedeLegale(request.getParameter("indirizzo"));
			azienda.setCap(request.getParameter("cap"));
			azienda.setNumeroTelefono(request.getParameter("telefono"));
			azienda.setEmail(request.getParameter("email"));
			
			AziendaDM aziendaDAO = new AziendaDM();
			try {
				aziendaDAO.doSave(azienda);
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}else {
			PersonaFisicaBean persona = new PersonaFisicaBean();
			persona.setCognome(request.getParameter("cognome"));
			persona.setNome(request.getParameter("nome"));
			persona.setGenere(request.getParameter("genere"));
			persona.setNumeroTelefono(request.getParameter("telefono"));
			persona.setEmail(request.getParameter("email"));
			
			PersonaFisicaDM personaDAO = new PersonaFisicaDM();
			try {
				personaDAO.doSave(persona);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		HttpSession session = request.getSession(true);
		session.setAttribute("Utente", utente);
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/areaUtente.jsp");
		dispatcher.forward(request, response);
	}

}
