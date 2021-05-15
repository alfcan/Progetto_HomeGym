package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.OrdineBean;

public interface Ordine {

	public void doSave(OrdineBean ordine) throws SQLException;
	
	public void doUpdate(OrdineBean ordine) throws SQLException;
	
	public boolean doDelete(int ID) throws SQLException;

	public OrdineBean doRetrieveByKey(int ID) throws SQLException;
	
	public ArrayList<OrdineBean> doRetrieveAll(String order) throws SQLException;

	public ArrayList<OrdineBean> doRetrieveAllByUtente(String utente) throws SQLException;
	
}
