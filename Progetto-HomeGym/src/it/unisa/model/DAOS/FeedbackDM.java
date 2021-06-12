package it.unisa.model.DAOS;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.database.DriverManagerConnectionPool;
import it.unisa.model.beans.FeedbackBean;
import it.unisa.model.beans.ProductBean;

public class FeedbackDM implements Feedback
{
	private static final String TABLE_NAME = "feedback";
	
	@Override
	public synchronized void doSave(FeedbackBean feedback) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String insertSQL = "INSERT INTO " + FeedbackDM.TABLE_NAME
						 + " (valutazione, commento, email, prodotto) VALUES (?, ?, ?, ?)";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(insertSQL);
			preparedStatement.setInt(1, feedback.getValutazione());
			preparedStatement.setString(2, feedback.getCommento());
			preparedStatement.setString(3, feedback.getEmail());
			preparedStatement.setString(4, feedback.getProdotto());
			
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
	public synchronized void doUpdate(FeedbackBean feedback) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		String updateSQL = "UPDATE " + FeedbackDM.TABLE_NAME
						 + " SET valutazione= ?, commento= ?, email= ?, prodotto= ?"
						 + " WHERE ID = ?";
		
		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(updateSQL);
			preparedStatement.setInt(1, feedback.getValutazione());
			preparedStatement.setString(2, feedback.getCommento());
			preparedStatement.setString(3, feedback.getEmail());
			preparedStatement.setString(4, feedback.getProdotto());
			preparedStatement.setInt(5, feedback.getID());
			
			
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

		String deleteSQL = "DELETE FROM " + FeedbackDM.TABLE_NAME + " WHERE ID = ?";

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
	public synchronized FeedbackBean doRetrieveByKey(int ID) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		FeedbackBean bean = new FeedbackBean();

		String selectSQL = "SELECT * FROM " + FeedbackDM.TABLE_NAME + " WHERE ID = ?";

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);
			preparedStatement.setInt(1, ID);
			

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				bean.setValutazione(rs.getInt("valutazione"));
				bean.setCommento(rs.getString("commento"));
				bean.setEmail(rs.getString("email"));
				bean.setProdotto(rs.getString("prodotto"));
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
	public synchronized ArrayList<FeedbackBean> doRetrieveAll(String order) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<FeedbackBean> feedback = new ArrayList<FeedbackBean>();

		String selectSQL = "SELECT * FROM " + FeedbackDM.TABLE_NAME;

		if (order != null && !order.equals("")) {
			selectSQL += " ORDER BY " + order;
		}

		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				FeedbackBean bean = new FeedbackBean();
				bean.setID(rs.getInt("ID"));
				bean.setValutazione(rs.getInt("valutazione"));
				bean.setCommento(rs.getString("commento"));
				bean.setEmail(rs.getString("email"));
				bean.setProdotto(rs.getString("prodotto"));
				feedback.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return feedback;
	}
	
	public synchronized ArrayList<FeedbackBean> doRetrieveByUtente(String utente) throws SQLException {
		Connection connection = null;
		PreparedStatement preparedStatement = null;

		ArrayList<FeedbackBean> feedback = new ArrayList<FeedbackBean>();

		String selectSQL = "SELECT * FROM " + FeedbackDM.TABLE_NAME
						 + " WHERE email = ?";


		try {
			connection = DriverManagerConnectionPool.getConnection();
			preparedStatement = connection.prepareStatement(selectSQL);

			preparedStatement.setString(1, utente);
			ResultSet rs = preparedStatement.executeQuery();

			while (rs.next()) {
				FeedbackBean bean = new FeedbackBean();
				bean.setID(rs.getInt("ID"));
				bean.setValutazione(rs.getInt("valutazione"));
				bean.setCommento(rs.getString("commento"));
				bean.setEmail(rs.getString("email"));
				bean.setProdotto(rs.getString("prodotto"));
				feedback.add(bean);
			}

		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
			} finally {
				DriverManagerConnectionPool.releaseConnection(connection);
			}
		}
		return feedback;
	}
}
