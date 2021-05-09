package it.unisa.model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.database.DriverManagerConnectionPool;
import it.unisa.model.beans.PersonaFisicaBean;

public class PersonaFisicaDM implements PersonaFisica
{
	private static final String TABLE_NAME = "personaFisica";
	
	public synchronized void doSave(PersonaFisicaBean personaFisica) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + PersonaFisicaDM.TABLE_NAME
						 + " (codice_fiscale, cognome, nome, citta, indirizzo, cap, numero_telefono, email) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, personaFisica.getCodiceFiscale());
			preparedStatement.setString(2, personaFisica.getCognome());
			preparedStatement.setString(3, personaFisica.getNome() );
			preparedStatement.setString(4, personaFisica.getCitta());
			preparedStatement.setString(5, personaFisica.getIndirizzo());
			preparedStatement.setString(6, personaFisica.getCap());
			preparedStatement.setString(7, personaFisica.getNumeroTelefono() );
			preparedStatement.setString(8, personaFisica.getEmail());
			
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
	public synchronized void doUpdate(PersonaFisicaBean personaFisica) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE " + PersonaFisicaDM.TABLE_NAME
						 + " SET cognome= ?, nome= ?, citta= ?, indirizzo= ?,cap= ?,  numero_telefono= ?, email= ?)"
						 + " WHERE codice_fiscale = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, personaFisica.getCognome());
			preparedStatement.setString(2, personaFisica.getNome());
			preparedStatement.setString(3, personaFisica.getCitta());
			preparedStatement.setString(4, personaFisica.getIndirizzo());
			preparedStatement.setString(5, personaFisica.getCap());
			preparedStatement.setString(6, personaFisica.getNumeroTelefono());
			preparedStatement.setString(7, personaFisica.getEmail());
			preparedStatement.setString(8, personaFisica.getCodiceFiscale());
			
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
	public synchronized boolean doDelete(String codiceFiscale) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		int result = 0;

		String deleteSQL = "DELETE FROM " + PersonaFisicaDM.TABLE_NAME + " WHERE codiceFiscale = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(deleteSQL);
			preparedStatement.setString(1, codiceFiscale);

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
	public synchronized PersonaFisicaBean doRetrieveByKey(String codiceFiscale) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		PersonaFisicaBean bean = new PersonaFisicaBean();

		String selectSQL = "SELECT * FROM " + PersonaFisicaDM.TABLE_NAME + " WHERE codice_fiscale = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codiceFiscale);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
				bean.setCitta(rs.getString("citta"));
				bean.setIndirizzo(rs.getString("indirizzo"));
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
	public synchronized ArrayList<PersonaFisicaBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<PersonaFisicaBean> personaFisica = new ArrayList<PersonaFisicaBean>();

		String selectSQL = "SELECT * FROM " + PersonaFisicaDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				PersonaFisicaBean bean = new PersonaFisicaBean();
				bean.setCodiceFiscale(rs.getString("codice_fiscale"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
				bean.setCitta(rs.getString("citta"));
				bean.setIndirizzo(rs.getString("indirizzo"));
				bean.setCap(rs.getString("cap"));
				bean.setNumeroTelefono(rs.getString("numero_telefono"));
				bean.setEmail(rs.getString("email"));
				personaFisica.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return personaFisica;
	}
}
