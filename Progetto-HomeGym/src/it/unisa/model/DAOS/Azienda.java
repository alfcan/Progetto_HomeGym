package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.AziendaBean;

public interface Azienda 
{
	public void doSave(AziendaBean azienda) throws SQLException;
	
	public void doUpdate(AziendaBean azienda) throws SQLException;
	
	public boolean doDelete(String partitaIva) throws SQLException;

	public AziendaBean doRetrieveByKey(String partitaIva) throws SQLException;
	
	public ArrayList<AziendaBean> doRetrieveAll(String order) throws SQLException;
}
