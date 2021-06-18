package it.unisa.model.beans;

import java.sql.SQLException;
import java.util.ArrayList;

import it.unisa.model.DAOS.ProductModelDM;

public class Carrello {
	
	private ArrayList<ProductBean> products;
	
	public Carrello() {
		products = new ArrayList<ProductBean>();
	}
	
	public ArrayList<ProductBean> getProducts() {
		return products;
	}

	public synchronized void addProduct(String codice) throws SQLException {
		int i = 0;
		boolean flag = false;
		for(ProductBean product : products) {
			if(codice.equals(product.getCodice())) {
				flag = true;
				if(product.getQtaMagazzino() >= 1) {
					product.setQtaCarrello(product.getQtaCarrello()+1);
					product.setQtaMagazzino(product.getQtaMagazzino() - 1);
				}
				products.set(i, product);
			}
			i++;
		}
		if(!flag) {
			ProductModelDM prodottoDAO = new ProductModelDM();
			ProductBean product = prodottoDAO.doRetrieveByKey(codice);
			product.setQtaCarrello(1);
			product.setQtaMagazzino(product.getQtaMagazzino() - 1);
			products.add(product);
		}
	}
	
	public synchronized void removeProduct(String codice) {
		for(int i = 0; i < products.size(); i++) {
			ProductBean product = products.get(i);
			if(codice.equals(product.getCodice())) {
				product.setQtaMagazzino(product.getQtaMagazzino() + 1);
				int newQtaCarrello = product.getQtaCarrello() - 1;
				if(newQtaCarrello <= 0)
					products.remove(i);
				else
					product.setQtaCarrello(newQtaCarrello);
			}
		}
	}
	
	public synchronized void deleteProduct(String codice) {
		for(int i = 0; i < products.size(); i++) {
			ProductBean product = products.get(i);
			if(product.getCodice().equals(codice))
				products.remove(i);
		}
	}
	
	public synchronized double getTotale() {
		double totale = 0;
		for(ProductBean product : products) {
			totale = totale + (product.getPrezzo()*product.getQtaCarrello());
		}
		return totale;
	}
	
	public synchronized int getQtaProducts() {
		int qta = 0;
		for(int i = 0; i < products.size(); i++) {
			ProductBean p = products.get(i);
			qta += p.getQtaCarrello();
		}
		return qta;
	}
}
