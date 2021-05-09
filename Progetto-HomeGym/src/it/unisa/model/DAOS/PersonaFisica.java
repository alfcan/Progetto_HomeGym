package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.PersonaFisicaBean;

public interface PersonaFisica 
{
	public void doSave(PersonaFisicaBean personaFisica) throws SQLException;
	
	public void doUpdate(PersonaFisicaBean personaFisica) throws SQLException;
	
	public boolean doDelete(String codiceFiscale) throws SQLException;

	public PersonaFisicaBean doRetrieveByKey(String codicaFiscale) throws SQLException;
	
	public ArrayList<PersonaFisicaBean> doRetrieveAll(String order) throws SQLException;
}
