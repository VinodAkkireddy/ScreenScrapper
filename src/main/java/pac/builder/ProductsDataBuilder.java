package pac.builder;

import org.jsoup.nodes.Document;

import pac.data.Product;

/**
 * Populator class to build Products data object.
 * @author Vinod Akkireddy
 *
 */
public interface ProductsDataBuilder {
	public Product build(Document document);
}
