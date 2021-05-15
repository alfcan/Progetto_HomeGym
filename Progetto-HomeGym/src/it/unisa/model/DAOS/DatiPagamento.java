package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.DatiPagamentoBean;

public interface DatiPagamento 
{
	public void doSave(DatiPagamentoBean dati) throws SQLException;
	
	public void doUpdate(DatiPagamentoBean dati) throws SQLException;
	
	public boolean doDelete(String numeroCarta) throws SQLException;

	public DatiPagamentoBean doRetrieveByKey(String numeroCarta) throws SQLException;
	
	public ArrayList<DatiPagamentoBean> doRetrieveAll(String order) throws SQLException;

	public ArrayList<DatiPagamentoBean> doRetrieveAllByUtente(String utente) throws SQLException;
}
