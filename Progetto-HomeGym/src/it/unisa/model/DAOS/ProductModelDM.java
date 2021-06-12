package it.unisa.model.DAOS;
import it.unisa.model.beans.*;
import it.unisa.database.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ProductModelDM implements ProductModel {

	private static final String TABLE_NAME = "prodotto";

	@Override
	public synchronized void doSave(ProductBean product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String insertSQL = "INSERT INTO " + ProductModelDM.TABLE_NAME
				+ " (codice, nome, descrizione, prezzo, iva, quantitaMagazzino, sconto, sottocategoria, categoria, url_immagine) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, product.getCodice());
			preparedStatement.setString(2, product.getNome());
			preparedStatement.setString(3, product.getDescrizione());
			preparedStatement.setDouble(4, product.getPrezzo());
			preparedStatement.setInt(5, product.getIva());
			preparedStatement.setInt(6, product.getQtaMagazzino());
			preparedStatement.setInt(7, product.getSconto());
			preparedStatement.setString(8, product.getSottocategoria());
			preparedStatement.setInt(9, product.getIdCategoria());
			preparedStatement.setString(10, product.getUrlImmagine());
			
			preparedStatement.executeUpdate();

			connection.commit();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}

	@Override
	public synchronized void doUpdate(ProductBean product) throws SQLException {

		Connection connection = null;
		PreparedStatement preparedStatement = null;

		String updateSQL = "UPDATE " + ProductModelDM.TABLE_NAME
				+ " SET nome = ?, descrizione = ?, prezzo = ?, iva = ?, quantitaMagazzino = ?, sconto = ?, sottocategoria = ?, categoria = ?, url_immagine = ?"
				+ " WHERE codice = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, product.getNome());
			preparedStatement.setString(2, product.getDescrizione());
			preparedStatement.setDouble(3, product.getPrezzo());
			preparedStatement.setInt(4, product.getIva());
			preparedStatement.setInt(5, product.getQtaMagazzino());
			preparedStatement.setInt(6, product.getSconto());
			preparedStatement.setString(7, product.getSottocategoria());
			preparedStatement.setInt(8, product.getIdCategoria());
			preparedStatement.setString(9, product.getUrlImmagine());
			preparedStatement.setString(10, product.getCodice());
			
			preparedStatement.executeUpdate();
			connection.commit();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
	}
	
	@Override
	public synchronized ProductBean doRetrieveByKey(String codice) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ProductBean bean = new ProductBean();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME + " WHERE codice = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codice);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setCodice(rs.getString("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setIva(rs.getInt("iva"));
				bean.setQtaMagazzino(rs.getInt("quantitaMagazzino"));
				bean.setSconto(rs.getInt("sconto"));
				bean.setSottocategoria(rs.getString("sottocategoria"));
				bean.setIdCategoria(rs.getInt("categoria"));
				bean.setUrlImmagine(rs.getString("url_immagine"));
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return bean;
	}

	@Override
	public synchronized boolean doDelete(String codice) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ProductModelDM.TABLE_NAME + " WHERE codice = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, codice);

			result = preparedStatement.executeUpdate();
			connection.commit();

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return (result != 0);
	}

	@Override
	public synchronized ArrayList<ProductBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ProductBean> products = new ArrayList<ProductBean>();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setCodice(rs.getString("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setIva(rs.getInt("iva"));
				bean.setQtaMagazzino(rs.getInt("quantitaMagazzino"));
				bean.setSconto(rs.getInt("sconto"));
				bean.setSottocategoria(rs.getString("sottocategoria"));
				bean.setIdCategoria(rs.getInt("categoria"));
				bean.setUrlImmagine(rs.getString("url_immagine"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	@Override
	public synchronized ArrayList<ProductBean> doRetrieveCategoria(int categoria) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ProductBean> products = new ArrayList<ProductBean>();

		String selectSQL = "SELECT * FROM " + ProductModelDM.TABLE_NAME
						 + " WHERE categoria = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, categoria);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ProductBean bean = new ProductBean();
				bean.setCodice(rs.getString("codice"));
				bean.setNome(rs.getString("nome"));
				bean.setDescrizione(rs.getString("descrizione"));
				bean.setPrezzo(rs.getInt("prezzo"));
				bean.setIva(rs.getInt("iva"));
				bean.setQtaMagazzino(rs.getInt("quantitaMagazzino"));
				bean.setSconto(rs.getInt("sconto"));
				bean.setSottocategoria(rs.getString("sottocategoria"));
				bean.setIdCategoria(rs.getInt("categoria"));
				bean.setUrlImmagine(rs.getString("url_immagine"));
				products.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return products;
	}
	
	public ArrayList<ProductBean> doRetrieveProductBuy (String utente){
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		ArrayList<ProductBean> products = new ArrayList<ProductBean>();
		ArrayList<String> idProducts = new ArrayList<String>();
		
		
		String selectSQL = "SELECT DISTINCT COMPOSIZIONE.PRODOTTO FROM ORDINE,COMPOSIZIONE WHERE ORDINE.UTENTE = ? "
						 + " AND ORDINE.ID = COMPOSIZIONE.ORDINE";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			
			preparedStatement.setString(1, utente);
			ResultSet rs = preparedStatement.executeQuery();

			while(rs.next()) {
				idProducts.add(rs.getString(1));
			}
			
			for(String s : idProducts) {
				products.add(this.doRetrieveByKey(s));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return products;
	}

}