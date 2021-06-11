package it.unisa.model.beans;

import java.util.Date;

public class DatiPagamentoBean 
{
	private String numeroCarta;
	private int cvv;
	private Date dataScadenza;
	
	public DatiPagamentoBean() 
	{
		numeroCarta ="";
		cvv=0;
		dataScadenza=null;
	}

	public String getNumeroCarta() {
		return numeroCarta;
	}

	public void setNumeroCarta(String numeroCarta) {
		this.numeroCarta = numeroCarta;
	}

	public int getCvv() {
		return cvv;
	}

	public void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public Date getDataScadenza() {
		return dataScadenza;
	}

	public void setDataScadenza(Date dataScadenza) {
		this.dataScadenza = dataScadenza;
	}
	
}
