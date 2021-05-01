package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.Collection;

import it.unisa.model.beans.ProductBean;

public interface ProductModel {
	public void doSave(ProductBean product) throws SQLException;
	
	public void doUpdate(ProductBean product) throws SQLException;
	
	public boolean doDelete(String codice) throws SQLException;

	public ProductBean doRetrieveByKey(String codice) throws SQLException;
	
	public Collection<ProductBean> doRetrieveAll(String order) throws SQLException;
}
