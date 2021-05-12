package it.unisa.model.beans;

import java.util.Date;

public class OrdineBean {
	
	private int ID;
	private String stato;
	private Date data;
	private String utente;
	private String indirizzoSpedizione;
	
	public OrdineBean() {
		ID = 0;
		stato = "";
		utente = "";
		indirizzoSpedizione = "";
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getStato() {
		return stato;
	}

	public void setStato(String stato) {
		this.stato = stato;
	}

	public String getUtente() {
		return utente;
	}

	public void setUtente(String utente) {
		this.utente = utente;
	}

	public String getIndirizzoSpedizione() {
		return indirizzoSpedizione;
	}

	public void setIndirizzoSpedizione(String indirizzoSpedizione) {
		this.indirizzoSpedizione = indirizzoSpedizione;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	
}
