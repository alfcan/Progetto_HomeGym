package it.unisa.model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.database.DriverManagerConnectionPool;
import it.unisa.model.beans.ComposizioneBean;
import it.unisa.model.beans.ProductBean;


public class ComposizioneDM implements Composizione
{
	private static final String TABLE_NAME = "Composizione";
	
	public synchronized void doSave(ComposizioneBean composizione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + ComposizioneDM.TABLE_NAME
						 + " (ordine, prodotto, quantita, prezzo_acquisto, iva_acquisto) VALUES (?, ?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, composizione.getOrdine());
			preparedStatement.setString(2, composizione.getProdotto() );
			preparedStatement.setInt(3, composizione.getQuantita());
			preparedStatement.setDouble(4, composizione.getPrezzoAcquisto() );
			preparedStatement.setInt(5, composizione.getIvaAcquisto());
			
			
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
	public synchronized void doUpdate(ComposizioneBean composizione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE " + ComposizioneDM.TABLE_NAME
						 + " SET quantita= ?, prezzo_acquisto= ?,iva_acquisto= ?"
						 + " WHERE ordine= ?, prodotto= ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, composizione.getQuantita());
			preparedStatement.setDouble(2, composizione.getPrezzoAcquisto());
			preparedStatement.setInt(3, composizione.getIvaAcquisto());
			preparedStatement.setInt(4, composizione.getOrdine());
			preparedStatement.setString(5, composizione.getProdotto());
			
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
	public synchronized boolean doDelete(int ordine, String prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ComposizioneDM.TABLE_NAME + " WHERE ordine= ?, prodotto= ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, ordine);
			preparedStatement.setString(2, prodotto);

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
	public synchronized ComposizioneBean doRetrieveByKey(int ordine, String prodotto) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ComposizioneBean bean = new ComposizioneBean();

		String selectSQL = "SELECT * FROM " + ComposizioneDM.TABLE_NAME + " WHERE ordine= ?, prodotto= ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, ordine);
			preparedStatement.setString(2, prodotto);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setOrdine(rs.getInt("ordine"));
				bean.setProdotto(rs.getString("prodotto"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzoAcquisto(rs.getDouble("prezzo_acquisto"));
				bean.setIvaAcquisto(rs.getInt("iva_acquisto"));
				
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
	public synchronized ArrayList<ComposizioneBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ComposizioneBean> composizione = new ArrayList<ComposizioneBean>();

		String selectSQL = "SELECT * FROM " + ComposizioneDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ComposizioneBean bean = new ComposizioneBean();
				bean.setOrdine(rs.getInt("ordine"));
				bean.setProdotto(rs.getString("prodotto"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzoAcquisto(rs.getDouble("prezzo_acquisto"));
				bean.setIvaAcquisto(rs.getInt("iva_acquisto"));
				composizione.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return composizione;
	}
	
	public synchronized ArrayList<ComposizioneBean> doRetrieveByOrdine(int id) throws SQLException{
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<ComposizioneBean> composizione = new ArrayList<ComposizioneBean>();

		String selectSQL = "SELECT * FROM " + ComposizioneDM.TABLE_NAME
						  +" WHERE ordine = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, id);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				ComposizioneBean bean = new ComposizioneBean();
				bean.setOrdine(rs.getInt("ordine"));
				bean.setProdotto(rs.getString("prodotto"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzoAcquisto(rs.getDouble("prezzo_acquisto"));
				bean.setIvaAcquisto(rs.getInt("iva_acquisto"));
				composizione.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return composizione;
	}
}
