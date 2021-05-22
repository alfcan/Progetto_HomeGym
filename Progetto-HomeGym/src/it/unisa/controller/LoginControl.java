package it.unisa.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
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
				if(utente.getTipo().equalsIgnoreCase("admin")) {
					session.setMaxInactiveInterval(60*35);
					session.setAttribute("Utente", utente);
					response.sendRedirect("pages/areaUtente.jsp");
				}else {
					session.setMaxInactiveInterval(60*20);
					session.setAttribute("Utente", utente);
					response.sendRedirect("pages/areaUtente.jsp");
				}
			}
			else {
				request.setAttribute("operazione", "Login non riuscito");
				RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/pages/operazione.jsp");
				dispatcher.forward(request, response);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}

}
