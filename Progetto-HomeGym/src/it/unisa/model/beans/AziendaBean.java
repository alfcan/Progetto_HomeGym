package it.unisa.model.beans;

import java.io.Serializable;

public class AziendaBean implements Serializable
{
	private static final long serialVersionUID=1L;
	 private String ragioneSociale;
	 private String partitaIva;
	 private String citta;
	 private String indirizzoSedeLegale;
	 private String cap;
	 private String numeroTelefono;
	 private String email;
	 
	 public AziendaBean()
	 {
		 ragioneSociale="";
		 partitaIva="";
		 citta="";
		 indirizzoSedeLegale="";
		 numeroTelefono="";
		 email="";
	 }

	public String getRagioneSociale() {
		return ragioneSociale;
	}

	public void setRagioneSociale(String ragioneSociale) {
		this.ragioneSociale = ragioneSociale;
	}

	public String getPartitaIva() {
		return partitaIva;
	}

	public void setPartitaIva(String partitaIva) {
		this.partitaIva = partitaIva;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public String getIndirizzoSedeLegale() {
		return indirizzoSedeLegale;
	}

	public void setIndirizzoSedeLegale(String indirizzoSedeLegale) {
		this.indirizzoSedeLegale = indirizzoSedeLegale;
	}

	public String getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	

	public String getCap() {
		return cap;
	}

	public void setCap(String cap) {
		this.cap = cap;
	}

}
	 
	 

