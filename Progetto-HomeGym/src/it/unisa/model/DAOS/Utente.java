package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.UtenteBean;

public interface Utente {
	public void doSave(UtenteBean utente) throws SQLException;
	
	public void doUpdate(UtenteBean utente) throws SQLException;
	
	public boolean doDelete(String email) throws SQLException;

	public UtenteBean doRetrieve(String email, String password) throws SQLException;
	
	public ArrayList<UtenteBean> doRetrieveAll(String order) throws SQLException;
}
