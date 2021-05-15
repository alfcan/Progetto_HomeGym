package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.IndirizzoSpedizioneBean;

public interface IndirizzoSpedizione 
{
	public void doSave(IndirizzoSpedizioneBean indirizzoSpedizione) throws SQLException;
	
	public void doUpdate(IndirizzoSpedizioneBean indirizzoSpedizione) throws SQLException;
	
	public boolean doDelete(int ID) throws SQLException;

	public IndirizzoSpedizioneBean doRetrieveByKey(int ID) throws SQLException;
	
	public ArrayList<IndirizzoSpedizioneBean> doRetrieveAll(String order) throws SQLException;
}
