package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.ComposizioneBean;

public interface Composizione 
{
	public void doSave(ComposizioneBean composizione) throws SQLException;
	
	public void doUpdate(ComposizioneBean composizione) throws SQLException;
	
	public boolean doDelete(int ordine, String prodotto) throws SQLException;

	public ComposizioneBean doRetrieveByKey(int ordine, String prodotto) throws SQLException;
	
	public ArrayList<ComposizioneBean> doRetrieveAll(String order) throws SQLException;
	
	public ArrayList<ComposizioneBean> doRetrieveByOrdine(int id) throws SQLException;
}
