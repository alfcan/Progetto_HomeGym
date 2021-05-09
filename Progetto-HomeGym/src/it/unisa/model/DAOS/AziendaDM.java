package it.unisa.model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.database.DriverManagerConnectionPool;
import it.unisa.model.beans.AziendaBean;

public class AziendaDM implements Azienda
{
	private static final String TABLE_NAME = "azienda";
	
	@Override
	public synchronized void doSave(AziendaBean azienda) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + AziendaDM.TABLE_NAME
						 + " (ragione_sociale, partita_iva, citta, indirizzo_sede_legale, cap, numero_telefono, email) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, azienda.getRagioneSociale());
			preparedStatement.setString(2, azienda.getPartitaIva());
			preparedStatement.setString(3, azienda.getCitta());
			preparedStatement.setString(4, azienda.getIndirizzoSedeLegale());
			preparedStatement.setString(5, azienda.getCap());
			preparedStatement.setString(6, azienda.getNumeroTelefono());
			preparedStatement.setString(7, azienda.getEmail());
			
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
	public synchronized void doUpdate(AziendaBean azienda) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE " + AziendaDM.TABLE_NAME
						 + " SET ragione_sociale= ?, citta= ?, indirizzo_sede_legale= ?, cap= ?, numero_telefono= ?, email= ?)"
						 + " WHERE partita_iva = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, azienda.getRagioneSociale());
			preparedStatement.setString(2, azienda.getCitta());
			preparedStatement.setString(3, azienda.getIndirizzoSedeLegale());
			preparedStatement.setString(4, azienda.getCap());
			preparedStatement.setString(5, azienda.getNumeroTelefono());
			preparedStatement.setString(6, azienda.getEmail());
			preparedStatement.setString(7, azienda.getPartitaIva());
			
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
	public synchronized boolean doDelete(String partitaIva) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + AziendaDM.TABLE_NAME + " WHERE partita_iva = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, partitaIva);

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
	public synchronized AziendaBean doRetrieveByKey(String partitaIva) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		AziendaBean bean = new AziendaBean();

		String selectSQL = "SELECT * FROM " + AziendaDM.TABLE_NAME + " WHERE partita_iva = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, partitaIva);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setRagioneSociale(rs.getString("ragione_sociale"));
				bean.setCitta(rs.getString("citta"));
				bean.setIndirizzoSedeLegale(rs.getString("indirizzo_sede_legale"));
				bean.setCap(rs.getString("cap"));
				bean.setNumeroTelefono(rs.getString("numero_telefono"));
				bean.setEmail(rs.getString("email"));
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
	public synchronized ArrayList<AziendaBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<AziendaBean> aziende = new ArrayList<AziendaBean>();

		String selectSQL = "SELECT * FROM " + AziendaDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				AziendaBean bean = new AziendaBean();
				bean.setRagioneSociale(rs.getString("ragione_sociale"));
				bean.setPartitaIva(rs.getString("partita_iva"));
				bean.setCitta(rs.getString("citta"));
				bean.setIndirizzoSedeLegale(rs.getString("indirizzo_sede_legale"));
				bean.setCap(rs.getString("cap"));
				bean.setNumeroTelefono(rs.getString("numero_telefono"));
				bean.setEmail(rs.getString("email"));
				aziende.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return aziende;
	}
}
