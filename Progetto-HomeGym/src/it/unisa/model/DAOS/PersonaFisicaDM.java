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
	private static final String TABLE_NAME = "persona_fisica";
	
	public synchronized void doSave(PersonaFisicaBean personaFisica) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + PersonaFisicaDM.TABLE_NAME
						 + " (ID,cognome, nome, genere, numero_telefono, email) VALUES (?, ?, ?, ?, ?,?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, personaFisica.getID());
			preparedStatement.setString(2, personaFisica.getCognome());
			preparedStatement.setString(3, personaFisica.getNome() );;
			preparedStatement.setString(4, personaFisica.getGenere());
			preparedStatement.setString(5, personaFisica.getNumeroTelefono() );
			preparedStatement.setString(6, personaFisica.getEmail());
			
			preparedStatement.execute();
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
						 + " SET cognome= ?, nome= ?, genere= ?,  numero_telefono= ?, email= ?"
						 + " WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setString(1, personaFisica.getCognome());
			preparedStatement.setString(2, personaFisica.getNome() );
			preparedStatement.setString(3, personaFisica.getGenere());
			preparedStatement.setString(4, personaFisica.getNumeroTelefono() );
			preparedStatement.setString(5, personaFisica.getEmail());
			preparedStatement.setInt(6, personaFisica.getID());
			
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

		String deleteSQL = "DELETE FROM " + PersonaFisicaDM.TABLE_NAME + " WHERE ID = ?";

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
	public synchronized PersonaFisicaBean doRetrieveByKey(int ID) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		PersonaFisicaBean bean = new PersonaFisicaBean();

		String selectSQL = "SELECT * FROM " + PersonaFisicaDM.TABLE_NAME + " WHERE ID = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, ID);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setID(rs.getInt("ID"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
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
				bean.setID(rs.getInt("ID"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
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
				bean.setID(rs.getInt("ID"));
				bean.setCognome(rs.getString("cognome"));
				bean.setNome(rs.getString("nome"));
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
