package it.unisa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import it.unisa.model.DAOS.UtenteDM;
import it.unisa.model.beans.UtenteBean;

@WebServlet("/Login")
public class LoginControl extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	private static UtenteDM model = new UtenteDM();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		try {
			UtenteBean utente = model.doRetrieve(email, password);
			if(utente != null) {
				HttpSession session = request.getSession(true);
				session.setMaxInactiveInterval(60*20);
				session.setAttribute("Utente", utente);
				response.sendRedirect("pages/areaUtente.jsp");
			}
			else {
				response.sendRedirect("pages/login.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
