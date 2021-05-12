package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.PersonaFisicaBean;

public interface PersonaFisica 
{
	public void doSave(PersonaFisicaBean personaFisica) throws SQLException;
	
	public void doUpdate(PersonaFisicaBean personaFisica) throws SQLException;
	
	public boolean doDelete(int ID) throws SQLException;

	public PersonaFisicaBean doRetrieveByKey(int ID) throws SQLException;
	
	public ArrayList<PersonaFisicaBean> doRetrieveAll(String order) throws SQLException;

	PersonaFisicaBean doRetrieveByEmail(String email) throws SQLException;
}
