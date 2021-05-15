package it.unisa.model.beans;

import java.io.Serializable;
import java.util.Date;

public class PersonaFisicaBean implements Serializable
{
	private static final long serialVersionUID=1L;
	
	private int ID;
	private String cognome;
	private String nome;
	private String genere;
	private String numeroTelefono;
	private String email;
	
	public PersonaFisicaBean()
	 {
		ID = 0;
		cognome="";
		nome="";
		genere = "";
		numeroTelefono="";
		email="";
	 }
	
	public int getID() {
		return ID;
	}
	public void setID(int ID) {
		this.ID = ID;
	}
	public String getGenere() {
		return genere;
	}
	public void setGenere(String genere) {
		this.genere = genere;
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
	
}
