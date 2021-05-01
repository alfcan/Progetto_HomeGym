package it.unisa.model.beans;

import java.io.Serializable;

public class ProductBean implements Serializable {

	private static final long serialVersionUID = 1L;

	private String codice;
	private String nome;
	private String descrizione;
	private double prezzo;
	private int iva;
	private int sconto;
	private String sottocategoria;
	private int idCategoria;
	private String urlImmagine;
	private int qtaCarello;

	public ProductBean() {
		codice = "";
		nome = "";
		descrizione = "";
		prezzo = 0;
		iva = 0;
		sconto = 0;
		sottocategoria = "";
		idCategoria = 0;
		urlImmagine = "";
		qtaCarello = 0;
	}

	public String getCodice() {
		return codice;
	}

	public void setCodice(String codice) {
		this.codice = codice;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}

	public double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(double prezzo) {
		this.prezzo = prezzo;
	}

	public int getIva() {
		return iva;
	}

	public void setIva(int iva) {
		this.iva = iva;
	}

	public int getSconto() {
		return sconto;
	}

	public void setSconto(int sconto) {
		this.sconto = sconto;
	}

	public String getSottocategoria() {
		return sottocategoria;
	}

	public void setSottocategoria(String sottocategoria) {
		this.sottocategoria = sottocategoria;
	}

	public int getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getUrlImmagine() {
		return urlImmagine;
	}

	public void setUrlImmagine(String url_immagini) {
		this.urlImmagine = url_immagini;
	}
	
	public int getQtaCarello() {
		return qtaCarello;
	}

	public void setQtaCarello(int qtaCarello) {
		this.qtaCarello = qtaCarello;
	}

	@Override
	public String toString() {
		return "ProductBean [codice=" + codice + ", nome=" + nome + ", descrizione=" + descrizione + ", prezzo=" + prezzo
				+ ", iva=" + iva + ", sconto=" + sconto + ", sottocategoria=" + sottocategoria + ", idCategoria="
				+ idCategoria + ", urlImmagine=" + urlImmagine + "]";
	}

}
