package pac.builder.impl;

import org.jsoup.nodes.Document;

import pac.builder.ProductsDataBuilder;
import pac.data.Product;
/**
 * Retrieves intended data from Document object and populates Product data object.
 * @author Vinod_madhavi
 *
 */
public class DefaultProductDataBuilder implements ProductsDataBuilder {

	@Override
	public Product build(Document document) {
		Product product = new Product();
		product.setSize(calculateDocumentSize(document.text().getBytes().length));
		product.setTitle(document.select("div.productTitleDescriptionContainer").select("h2").text());
		product.setDescription(document.select("div.productText").select("p").text());
		product.setUnitPrice(document.select("p.pricingPerUnit").text());
		return product;
	}
	
	/**
	 * Calculates for size in Kilo-bytes.
	 * @param length
	 * @return
	 */
	private String calculateDocumentSize(int length){
		StringBuilder stringBuilder = new StringBuilder();
		return stringBuilder.append(length/1024).toString();
	}

}
