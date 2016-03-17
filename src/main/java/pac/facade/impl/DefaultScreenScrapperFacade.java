package pac.facade.impl;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;
import org.codehaus.jackson.map.ObjectMapper;
import org.jsoup.nodes.Document;

import pac.builder.ProductsDataBuilder;
import pac.builder.ResultsDataBuilder;
import pac.data.Product;
import pac.data.Results;
import pac.facade.ScreenScrapperFacade;
import pac.service.ScreenScrapperService;

/**
 * Implementation class for ScreenScrapperFacades.
 * 
 * @author Vinod Akkireddy
 *
 */
public class DefaultScreenScrapperFacade implements ScreenScrapperFacade {

	// dependancies
	private ScreenScrapperService service;

	private ProductsDataBuilder productDataBuilder;

	private ResultsDataBuilder resultsDataBuilder;

	public void setResultsDataBuilder(ResultsDataBuilder resultsDataBuilder) {
		this.resultsDataBuilder = resultsDataBuilder;
	}

	/**
	 * Following process is carried out in this method
	 * 
	 * Step 1: Get List of Jsoup Document objects from service layer representing the products on web page.
	 * 
	 * Step 2: Convert/Populate List of Documents objects to List of Product data objects - Uses ProductDataBuilder
	 * 
	 * Step 3: Convert/Populate List of Product objects in Results - Uses ResultsDataPopulator.
	 * 
	 * Step 4: Convert Results Object to JSON
	 * 
	 * Step 5: Return JSON string.
	 */
	@Override
	public String getProducts(String url) {
		if (StringUtils.isEmpty(url)) {
			return "Sorry, url is either null or empty";
		}
		List<Document> documents = service.getDocuments(url);
		
		if(documents.isEmpty()){
			return "Sorry problem in retrieving data";
		}
		List<Product> products = documents.stream().map(document -> productDataBuilder.build(document))
				.collect(Collectors.toList());
		Results results = resultsDataBuilder.build(products);
		ObjectMapper mapper = new ObjectMapper();
		try {
			return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(results);
		} catch (IOException e) {
			return "Sorry problem in processing json response";
		}
	}
	
	public ScreenScrapperService getService() {
		return service;
	}

	public void setService(ScreenScrapperService service) {
		this.service = service;
	}

	public ProductsDataBuilder getProductDataBuilder() {
		return productDataBuilder;
	}

	public void setProductDataBuilder(ProductsDataBuilder productDataBuilder) {
		this.productDataBuilder = productDataBuilder;
	}

	public ResultsDataBuilder getResultsDataBuilder() {
		return resultsDataBuilder;
	}

}
