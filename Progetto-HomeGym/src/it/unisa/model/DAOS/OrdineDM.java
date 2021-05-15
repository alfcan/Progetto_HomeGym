package it.unisa.model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.database.DriverManagerConnectionPool;
import it.unisa.model.beans.ComposizioneBean;
import it.unisa.model.beans.OrdineBean;

public class OrdineDM implements Ordine{

	private static final String TABLE_NAME = "Ordine";
	
	public synchronized int getIdCodice() throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String selectSQL = "SELECT MAX(ID) AS MAXID FROM " + OrdineDM.TABLE_NAME;
		int idMax = 0;
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
	
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				idMax = rs.getInt("MAXID");
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return idMax;
		
	}
	
	@Override
	public synchronized void doSave(OrdineBean ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + OrdineDM.TABLE_NAME
						 + " (ID, stato, data, utente, indirizzo_spedizione, totale) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1,ordine.getID());
			preparedStatement.setString(2,ordine.getStato());
			preparedStatement.setDate(3, new java.sql.Date(ordine.getData().getTime()));
			preparedStatement.setString(4,ordine.getUtente());
			preparedStatement.setString(5,ordine.getIndirizzoSpedizione());
			preparedStatement.setInt(6,ordine.getTotale());
			
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
	public synchronized void doUpdate(OrdineBean ordine) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE " + OrdineDM.TABLE_NAME
						 + " SET stato = ?, data= ?, utente= ?, indirizzo_spedizione= ?, totale=?"
						 + " WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1,ordine.getStato());
			preparedStatement.setDate(2, new java.sql.Date(ordine.getData().getTime()));
			preparedStatement.setString(3,ordine.getUtente());
			preparedStatement.setString(4,ordine.getIndirizzoSpedizione());		
			preparedStatement.setInt(5,ordine.getID());
			preparedStatement.setInt(6,ordine.getTotale());
			
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

		String deleteSQL = "DELETE FROM " + OrdineDM.TABLE_NAME + " WHERE ID = ?";

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
	public synchronized OrdineBean doRetrieveByKey(int ID) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		OrdineBean bean = new OrdineBean();

		String selectSQL = "SELECT * FROM " + OrdineDM.TABLE_NAME + " WHERE ID = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, ID);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setID(ID);
				bean.setStato(rs.getString("stato"));
				bean.setData(new java.util.Date(rs.getDate("data").getTime()));
				bean.setUtente(rs.getString("utente"));
				bean.setIndirizzoSpedizione(rs.getString("indirizzo_spedizione"));
				bean.setTotale(rs.getInt("totale"));
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
	public synchronized ArrayList<OrdineBean> doRetrieveAllByUtente(String utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<OrdineBean> ordini = new ArrayList<OrdineBean>();

		String selectSQL = "SELECT * FROM " + OrdineDM.TABLE_NAME
						 + " WHERE utente = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, utente);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setID(rs.getInt("ID"));
				bean.setStato(rs.getString("stato"));
				bean.setData(new java.util.Date(rs.getDate("data").getTime()));
				bean.setUtente(rs.getString("utente"));
				bean.setIndirizzoSpedizione(rs.getString("indirizzo_spedizione"));
				bean.setTotale(rs.getInt("totale"));
				ordini.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return ordini;
	}

	@Override
	public synchronized ArrayList<OrdineBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<OrdineBean> ordini = new ArrayList<OrdineBean>();

		String selectSQL = "SELECT * FROM " + OrdineDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				OrdineBean bean = new OrdineBean();
				bean.setID(rs.getInt("iD"));
				bean.setStato(rs.getString("stato"));
				bean.setData(new java.util.Date(rs.getDate("data").getTime()));
				bean.setUtente(rs.getString("utente"));
				bean.setIndirizzoSpedizione(rs.getString("indirizzo_spedizione"));
				bean.setTotale(rs.getInt("totale"));
				ordini.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return ordini;
	}
	
	

}
