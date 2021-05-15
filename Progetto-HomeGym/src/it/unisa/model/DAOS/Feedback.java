package it.unisa.model.DAOS;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.beans.FeedbackBean;

public interface Feedback 
{
	public void doSave(FeedbackBean feedback) throws SQLException;
	
	public void doUpdate(FeedbackBean feedback) throws SQLException;
	
	public boolean doDelete(int ID) throws SQLException;

	public FeedbackBean doRetrieveByKey(int ID) throws SQLException;
	
	public ArrayList<FeedbackBean> doRetrieveAll(String order) throws SQLException;
}
