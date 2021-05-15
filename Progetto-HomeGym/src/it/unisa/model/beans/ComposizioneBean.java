package it.unisa.model.beans;

import java.io.Serializable;

public class ComposizioneBean implements Serializable 
{
	private static final long serialVersionUID=1L;
	private int ordine;
	private String prodotto;
	private int quantita;
	private double prezzoAcquisto;
	private int ivaAcquisto;
	
	public ComposizioneBean()
	 {
		 ordine=0;
		 prodotto="";
		 quantita=0;
		 prezzoAcquisto=0;
		 ivaAcquisto=0;
		 
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

	public double getPrezzoAcquisto() {
		return prezzoAcquisto;
	}

	public void setPrezzoAcquisto(double d) {
		this.prezzoAcquisto = d;
	}

	public int getIvaAcquisto() {
		return ivaAcquisto;
	}

	public void setIvaAcquisto(int ivaAcquisto) {
		this.ivaAcquisto = ivaAcquisto;
	}
	
}
