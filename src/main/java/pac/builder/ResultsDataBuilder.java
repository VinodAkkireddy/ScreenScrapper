package pac.builder;

import java.util.List;

import pac.data.Product;
import pac.data.Results;

public interface ResultsDataBuilder {
	public Results build(List<Product> products);
}
