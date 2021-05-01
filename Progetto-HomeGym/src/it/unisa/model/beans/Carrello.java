package it.unisa.model.beans;

import java.util.ArrayList;

public class Carrello {
	
	private ArrayList<ProductBean> products;
	private double totale;
	
	public Carrello() {
		products = new ArrayList<ProductBean>();
		totale = 0;
	}
	
	public double getTotale() {
		return totale;
	}

	public void setTotale(double totale) {
		this.totale = totale;
	}

	public void addProduct(ProductBean product) {
		products.add(product);
	}
	
	public void deleteProduct(String codice) {
		int i = 0;
		for(ProductBean product : products) {
			if(codice.equals(product.getCodice())) {
				double incremento = product.getQtaCarello() * product.getPrezzo();
				double newTotale = getTotale() - incremento;
				setTotale(newTotale);
				products.remove(i);
			}
			i++;
		}
	}

}
