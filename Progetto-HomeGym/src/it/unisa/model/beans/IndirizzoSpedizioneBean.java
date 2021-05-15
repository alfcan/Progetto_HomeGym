package it.unisa.model.beans;

import java.io.Serializable;

public class IndirizzoSpedizioneBean implements Serializable
{
	private static final long serialVersionUID=1L;
	 private int ID;
	 private String via;
	 private String citta;
	 private String cap;
	 private String utente;
	 
	 public IndirizzoSpedizioneBean()
	 {
		 ID=0;
		 via="";
		 citta="";
		 cap="";
		 utente="";
	 }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	

}
