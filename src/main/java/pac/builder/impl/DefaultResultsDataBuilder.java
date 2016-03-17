package pac.builder.impl;

import java.util.List;

import pac.builder.ResultsDataBuilder;
import pac.data.Product;
import pac.data.Results;
/**
 * Builder class for populating Results data.
 * @author Vinod Akkireddy
 *
 */
public class DefaultResultsDataBuilder implements ResultsDataBuilder {

	/**
	 * Populates Results data.
	 */
	@Override
	public Results build(List<Product> products) {
		Results results = new Results();
		results.setProducts(products);
		Double totals = products.stream().mapToDouble(product -> Double.parseDouble(product.getUnitPrice())).sum();
		results.setTotals(totals.toString());
		return results;
	}

}
