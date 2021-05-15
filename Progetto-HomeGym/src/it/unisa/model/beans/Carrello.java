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
				product.setQtaCarello(product.getQtaCarello()+1);
				products.set(i, product);
			}
			i++;
		}
		if(!flag) {
			ProductModelDM prodottoDAO = new ProductModelDM();
			ProductBean product = prodottoDAO.doRetrieveByKey(codice);
			product.setQtaCarello(1);
			products.add(product);
		}
	}
	
	public synchronized void removeProduct(String codice) {
		int i = 0;
		if(products.size() == 1 && products.get(0).getQtaCarello() == 1) {
			products = new ArrayList<ProductBean>();
		} else {
			for(ProductBean product : products) {
				if(codice.equals(product.getCodice())) {
					int newQtaCarello = product.getQtaCarello() - 1;
					if(newQtaCarello <= 0)
						products.remove(i);
					else
						product.setQtaCarello(newQtaCarello);
				}
				i++;
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
			totale = totale + (product.getPrezzo()*product.getQtaCarello());
		}
		return totale;
	}
	
}
