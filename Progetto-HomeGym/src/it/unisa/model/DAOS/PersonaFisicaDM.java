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
						 + " (cognome, nome, dataNascita, genere, numero_telefono, email) VALUES (?, ?, ?, ?, ?, ?)";
		
		try {
			java.sql.Date dataNascita = new java.sql.Date(personaFisica.getDataNascita().getTime());
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setString(1, personaFisica.getCognome());
			preparedStatement.setString(2, personaFisica.getNome() );
			preparedStatement.setDate(3, dataNascita);
			preparedStatement.setString(4, personaFisica.getGenere());
			preparedStatement.setString(5, personaFisica.getNumeroTelefono() );
			preparedStatement.setString(6, personaFisica.getEmail());
			
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
						 + " SET cognome= ?, nome= ?, dataNascita= ?, genere= ?,  numero_telefono= ?, email= ?)"
						 + " WHERE id = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			java.sql.Date dataNascita = new java.sql.Date(personaFisica.getDataNascita().getTime());
			preparedStatement.setString(1, personaFisica.getCognome());
			preparedStatement.setString(2, personaFisica.getNome() );
			preparedStatement.setDate(3, dataNascita);
			preparedStatement.setString(4, personaFisica.getGenere());
			preparedStatement.setString(5, personaFisica.getNumeroTelefono() );
			preparedStatement.setString(6, personaFisica.getEmail());
			preparedStatement.setInt(7, personaFisica.getID());
			
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

		String deleteSQL = "DELETE FROM " + PersonaFisicaDM.TABLE_NAME + " WHERE id = ?";

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

		String selectSQL = "SELECT * FROM " + PersonaFisicaDM.TABLE_NAME + " WHERE id = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, codiceFiscale);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setID(rs.getInt("id"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
				bean.setDataNascita(rs.getDate("dataNascita"));
				bean.setGenere(rs.getString("genere"));
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
	public synchronized PersonaFisicaBean doRetrieveByEmail(String email) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		PersonaFisicaBean bean = new PersonaFisicaBean();

		String selectSQL = "SELECT * FROM " + PersonaFisicaDM.TABLE_NAME + " WHERE email = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setString(1, email);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setID(rs.getInt("id"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
				bean.setDataNascita(rs.getDate("dataNascita"));
				bean.setGenere(rs.getString("genere"));
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
				bean.setID(rs.getInt("id"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
				bean.setDataNascita(rs.getDate("dataNascita"));
				bean.setGenere(rs.getString("genere"));
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
		return personaFisica;
	}
}
