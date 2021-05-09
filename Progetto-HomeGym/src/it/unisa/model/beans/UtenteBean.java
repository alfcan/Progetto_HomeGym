package it.unisa.model.beans;

import java.io.Serializable;

public class UtenteBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String email;
	private String password;
	private String datiPagamento;
	private String tipo;
	
	public UtenteBean() {
		email = "";
		password = "";
		datiPagamento = "";
		tipo = "";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatiPagamento() {
		return datiPagamento;
	}

	public void setDatiPagamento(String datiPagamento) {
		this.datiPagamento = datiPagamento;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

}
