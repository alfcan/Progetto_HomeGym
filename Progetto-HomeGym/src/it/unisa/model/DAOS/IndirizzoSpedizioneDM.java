package it.unisa.model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.database.DriverManagerConnectionPool;
import it.unisa.model.beans.IndirizzoSpedizioneBean;

public class IndirizzoSpedizioneDM implements IndirizzoSpedizione
{
	private static final String TABLE_NAME = "indirizzoSpedizione";
	
	@Override
	public synchronized void doSave(IndirizzoSpedizioneBean indirizzoSpedizione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + IndirizzoSpedizioneDM.TABLE_NAME
						 + " (ID, via, citta, cap, utente) VALUES (?, ?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, indirizzoSpedizione.getID());
			preparedStatement.setString(2, indirizzoSpedizione.getVia());
			preparedStatement.setString(3, indirizzoSpedizione.getCitta());
			preparedStatement.setString(4, indirizzoSpedizione.getCap());
			preparedStatement.setString(5, indirizzoSpedizione.getUtente());
			
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
	public synchronized void doUpdate(IndirizzoSpedizioneBean indirizzoSpedizione) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE " + IndirizzoSpedizioneDM.TABLE_NAME
						 + " SET via= ?, citta= ?, cap= ?, utente= ?"
						 + " WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, indirizzoSpedizione.getVia());
			preparedStatement.setString(2, indirizzoSpedizione.getCitta());
			preparedStatement.setString(3, indirizzoSpedizione.getCap());
			preparedStatement.setString(4, indirizzoSpedizione.getUtente());
			preparedStatement.setInt(5, indirizzoSpedizione.getID());
			
			
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

		String deleteSQL = "DELETE FROM " + IndirizzoSpedizioneDM.TABLE_NAME + " WHERE ID = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setInt(1, ID);

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
	public synchronized IndirizzoSpedizioneBean doRetrieveByKey(int ID) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		IndirizzoSpedizioneBean bean = new IndirizzoSpedizioneBean();

		String selectSQL = "SELECT * FROM " + IndirizzoSpedizioneDM.TABLE_NAME + " WHERE ID = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, ID);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setVia(rs.getString("via"));
				bean.setCitta(rs.getString("citta"));
				bean.setCap(rs.getString("cap"));
				bean.setUtente(rs.getString("utente"));
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
	
	public synchronized ArrayList<IndirizzoSpedizioneBean> doRetrieveByUtente(String utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		IndirizzoSpedizioneBean bean = new IndirizzoSpedizioneBean();
		ArrayList<IndirizzoSpedizioneBean> indirizzi=new ArrayList<IndirizzoSpedizioneBean>();

		String selectSQL = "SELECT * FROM " + IndirizzoSpedizioneDM.TABLE_NAME + " WHERE utente = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, utente);
			
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setVia(rs.getString("via"));
				bean.setCitta(rs.getString("citta"));
				bean.setCap(rs.getString("cap"));
				bean.setUtente(rs.getString("utente"));
				indirizzi.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return indirizzi;
	}

	@Override
	public synchronized ArrayList<IndirizzoSpedizioneBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<IndirizzoSpedizioneBean> indirizzoSpedizione = new ArrayList<IndirizzoSpedizioneBean>();

		String selectSQL = "SELECT * FROM " + IndirizzoSpedizioneDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				IndirizzoSpedizioneBean bean = new IndirizzoSpedizioneBean();
				bean.setID(rs.getInt("ID"));
				bean.setVia(rs.getString("via"));
				bean.setCitta(rs.getString("citta"));
				bean.setCap(rs.getString("cap"));
				bean.setUtente(rs.getString("utente"));
				indirizzoSpedizione.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return indirizzoSpedizione;
	}
}
