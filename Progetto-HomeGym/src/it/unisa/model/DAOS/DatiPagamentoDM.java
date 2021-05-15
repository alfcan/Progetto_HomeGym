package it.unisa.model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.database.DriverManagerConnectionPool;
import it.unisa.model.beans.DatiPagamentoBean;

public class DatiPagamentoDM implements DatiPagamento
{
	private static final String TABLE_NAME = "DatiPagamento";
	
	@Override
	public synchronized void doSave(DatiPagamentoBean dati) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + DatiPagamentoDM.TABLE_NAME
						 + " (numero_carta, cvv, data_scadenza, utente) VALUES (?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1,dati.getNumeroCarta() );
			preparedStatement.setInt(2,dati.getCvv());
			preparedStatement.setDate(3, new java.sql.Date(dati.getDataScadenza().getTime()));
		
			
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
	public synchronized void doUpdate(DatiPagamentoBean dati) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE " + DatiPagamentoDM.TABLE_NAME
						 + " SET cvv = ?, data_scadenza= ?"
						 + " WHERE numero_carta = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1,dati.getCvv());
			preparedStatement.setDate(2, new java.sql.Date(dati.getDataScadenza().getTime()));
			preparedStatement.setString(3,dati.getNumeroCarta());


			
			
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
	public synchronized boolean doDelete(String numeroCarta) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + DatiPagamentoDM.TABLE_NAME + " WHERE numero_carta = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, numeroCarta);

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
	public synchronized DatiPagamentoBean doRetrieveByKey(String numeroCarta) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		DatiPagamentoBean bean = new DatiPagamentoBean();

		String selectSQL = "SELECT * FROM " + DatiPagamentoDM.TABLE_NAME + " WHERE numero_carta = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, numeroCarta);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setNumeroCarta(rs.getString("numeroCarta"));
				bean.setCvv(rs.getInt("cvv"));
				bean.setDataScadenza(new java.util.Date(rs.getDate("dataScadenza").getTime()));
				
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
	public synchronized ArrayList<DatiPagamentoBean> doRetrieveAllByUtente(String numeroCarta) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<DatiPagamentoBean> datiPagamento = new ArrayList<DatiPagamentoBean>();

		String selectSQL = "SELECT * FROM " + DatiPagamentoDM.TABLE_NAME
						 + " WHERE numero_carta = ?";

		try {
				connection = DriverManagerConnectionPool.getConnection();
				preparedStatement = connection.prepareStatement(selectSQL);
				preparedStatement.setString(1, numeroCarta);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				DatiPagamentoBean bean = new DatiPagamentoBean();
				bean.setCvv(rs.getInt("Cvv"));
				bean.setDataScadenza(new java.util.Date(rs.getDate("data").getTime()));
				bean.setNumeroCarta(rs.getString("numeroCarta"));
				
				datiPagamento.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return datiPagamento;
	}

	@Override
	public synchronized ArrayList<DatiPagamentoBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<DatiPagamentoBean> datiPagamento = new ArrayList<DatiPagamentoBean>();

		String selectSQL = "SELECT * FROM " + DatiPagamentoDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				DatiPagamentoBean bean = new DatiPagamentoBean();
				bean.setNumeroCarta(rs.getString("numeroCarta"));
				bean.setCvv(rs.getInt("cvv"));
				bean.setDataScadenza(new java.util.Date(rs.getDate("data").getTime()));
				datiPagamento.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return datiPagamento;
	}
	
}
