package it.unisa.model.beans;

import java.io.Serializable;

public class FeedbackBean implements Serializable
{
	private static final long serialVersionUID=1L;
	 private int ID;
	 private int valutazione;
	 private String commento;
	 private String email;
	 private String prodotto;
	 
	 public FeedbackBean()
	 {
		 ID=0;
		 valutazione=0;
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

	public int getValutazione() {
		return valutazione;
	}

	public void setValutazione(int valutazione) {
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
