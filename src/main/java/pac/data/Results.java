package pac.data;

import java.util.List;

public class Results {
	
	private List<Product> products;
	
	private String totals;

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public String getTotals() {
		return totals;
	}

	public void setTotals(String totals) {
		this.totals = totals;
	}

}
