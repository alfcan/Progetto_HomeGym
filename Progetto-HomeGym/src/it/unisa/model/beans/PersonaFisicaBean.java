package it.unisa.model.beans;

import java.io.Serializable;

public class PersonaFisicaBean implements Serializable
{
	private static final long serialVersionUID=1L;
	private String codiceFiscale;
	private String cognome;
	private String nome;
	private String citta;
	private String indirizzo;
	private String cap;
	private String numeroTelefono;
	private String email;
	
	public PersonaFisicaBean()
	 {
		 codiceFiscale="";
		 cognome="";
		 nome="";
		 citta="";
		 indirizzo="";
		 cap="";
		 numeroTelefono="";
		 email="";
	 }
	
	public String getCodiceFiscale() {
		return codiceFiscale;
	}
	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}
	public String getCognome() {
		return cognome;
	}
	public void setCognome(String cognome) {
		this.cognome = cognome;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
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
	public String getIndirizzo() {
		return indirizzo;
	}
	public void setIndirizzo(String indirizzo) {
		this.indirizzo = indirizzo;
	}
	
	
	
}
