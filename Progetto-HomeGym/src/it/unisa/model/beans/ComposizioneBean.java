package it.unisa.model.beans;

import java.io.Serializable;

public class ComposizioneBean implements Serializable 
{
	private static final long serialVersionUID=1L;
	private int ID;
	private int ordine;
	private String prodotto;
	private int quantita;
	private int prezzoAcquisto;
	private int ivaAcquisto;
	
	public ComposizioneBean()
	 {
		 ID=0;
		 ordine=0;
		 prodotto="";
		 quantita=0;
		 prezzoAcquisto=0;
		 ivaAcquisto=0;
		 
	 }

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public int getOrdine() {
		return ordine;
	}

	public void setOrdine(int ordine) {
		this.ordine = ordine;
	}

	public String getProdotto() {
		return prodotto;
	}

	public void setProdotto(String prodotto) {
		this.prodotto = prodotto;
	}

	public int getQuantita() {
		return quantita;
	}

	public void setQuantita(int quantita) {
		this.quantita = quantita;
	}

	public int getPrezzoAcquisto() {
		return prezzoAcquisto;
	}

	public void setPrezzoAcquisto(int prezzoAcquisto) {
		this.prezzoAcquisto = prezzoAcquisto;
	}

	public int getIvaAcquisto() {
		return ivaAcquisto;
	}

	public void setIvaAcquisto(int ivaAcquisto) {
		this.ivaAcquisto = ivaAcquisto;
	}
	
}
