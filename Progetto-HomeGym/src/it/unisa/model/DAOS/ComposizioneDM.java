package it.unisa.model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.database.DriverManagerConnectionPool;
import it.unisa.model.beans.ComposizioneBean;


public class ComposizioneDM implements Composizione
{
	private static final String TABLE_NAME = "Composizione";
	
	public synchronized void doSave(ComposizioneBean composizione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + ComposizioneDM.TABLE_NAME
						 + " (ID, ordine, prodotto, quantita, prezzo_acquisto, iva_acquisto) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, composizione.getID());
			preparedStatement.setInt(2, composizione.getOrdine());
			preparedStatement.setString(3, composizione.getProdotto() );
			preparedStatement.setInt(4, composizione.getQuantita());
			preparedStatement.setInt(5, composizione.getPrezzoAcquisto() );
			preparedStatement.setInt(6, composizione.getIvaAcquisto());
			
			
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
						 + " SET ordine= ?, prodotto= ?, quantita= ?, prezzo_acquisto= ?,iva_acquisto= ?)"
						 + " WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, composizione.getOrdine());
			preparedStatement.setString(2, composizione.getProdotto());
			preparedStatement.setInt(3, composizione.getQuantita());
			preparedStatement.setString(4, composizione.getProdotto());
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
	public synchronized boolean doDelete(int ID) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + ComposizioneDM.TABLE_NAME + " WHERE ID = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, ID);

			result = preparedStatement.executeUpdate();

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
	public synchronized ComposizioneBean doRetrieveByKey(int ID) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ComposizioneBean bean = new ComposizioneBean();

		String selectSQL = "SELECT * FROM " + ComposizioneDM.TABLE_NAME + " WHERE ID = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, ID);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setID(ID);
				bean.setOrdine(rs.getInt("ordine"));
				bean.setProdotto(rs.getString("prodotto"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzoAcquisto(rs.getInt("prezzo_acquisto"));
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
				bean.setID(rs.getInt("ID"));
				bean.setOrdine(rs.getInt("ordine"));
				bean.setProdotto(rs.getString("prodotto"));
				bean.setQuantita(rs.getInt("quantita"));
				bean.setPrezzoAcquisto(rs.getInt("prezzo_acquisto"));
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
