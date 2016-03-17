package pac;

import pac.builder.ProductsDataBuilder;
import pac.builder.ResultsDataBuilder;
import pac.builder.impl.DefaultProductDataBuilder;
import pac.builder.impl.DefaultResultsDataBuilder;
import pac.facade.impl.DefaultScreenScrapperFacade;
import pac.service.ScreenScrapperService;
import pac.service.impl.DefaultScreenScrapperService;

/**
 * Main class to invoke ScreenScrapper
 * 
 * @author Vinod Akkireddy
 *
 */
public class ScreenScrapper {

	public static void main(String[] args) {

		String url = "http://www.sainsburys.co.uk/webapp/wcs/stores/servlet/CategoryDisplay?msg=&langId=44&categoryId=185749&storeId=10151&krypto=DlGrnzisSe5OkfT6AIZSusHxNXJdAq5IKxtd2JBMGVaxWRbZItx0SCaDFDMw7K7n1ygUEIWvMCwNX7R5nW3GNWe6KAct1H09uOXGwmunv3BqIzWxcR8v3rVjhPTuO9XPVu0oQfEWzxw6ffDLOzj89rLMQeD%2FwaI04KeD3vzSZsti75pOZsW7uhVAg%2B34ngSl50Q8lCvpdsMEUqYjKLYoI0zDot75i9OIYMgkEuWBRr9DDm0pwNjU3TtPDH%2Fmd3qNWcvGEDR9Kf1vfWMfiLo5yLgr3ojFWgam4Ni98q0MlJZZP7KsLLwIJd4GJfqAy8uQMAtYiDeeaFGzP21TMun4JQ%3D%3D#langId=44&storeId=10151&catalogId=10122&categoryId=185749&parent_category_rn=12518&top_category=12518&pageSize=20&orderBy=FAVOURITES_FIRST&searchTerm=&beginIndex=0";

		// below dependencies to Facade can be managed by dependency management
		// framework like spring, however in this case created respective POJOs
		// and set in facade object.
		ScreenScrapperService service = new DefaultScreenScrapperService();

		ProductsDataBuilder productBuilder = new DefaultProductDataBuilder();

		ResultsDataBuilder resultsBuilder = new DefaultResultsDataBuilder();

		DefaultScreenScrapperFacade facade = new DefaultScreenScrapperFacade();

		facade.setProductDataBuilder(productBuilder);

		facade.setResultsDataBuilder(resultsBuilder);

		facade.setService(service);

		String jsonString = facade.getProducts(url);

		System.out.println(jsonString);

	}

}
