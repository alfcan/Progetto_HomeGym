package it.unisa.model.beans;

import java.io.Serializable;

public class FeedbackBean implements Serializable
{
	private static final long serialVersionUID=1L;
	 private int ID;
	 private String valutazione;
	 private String commento;
	 private String email;
	 private String prodotto;
	 
	 public FeedbackBean()
	 {
		 ID=0;
		 valutazione="";
		 commento="";
		 email="";
		 prodotto="";
	 }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getValutazione() {
		return valutazione;
	}

	public void setValutazione(String valutazione) {
		this.valutazione = valutazione;
	}

	public String getCommento() {
		return commento;
	}

	public void setCommento(String commento) {
		this.commento = commento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getProdotto() {
		return prodotto;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}
	 
	
}
