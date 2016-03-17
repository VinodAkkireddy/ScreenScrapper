package pac.facade.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.BDDMockito.given;

import java.util.Collections;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import pac.builder.ProductsDataBuilder;
import pac.builder.ResultsDataBuilder;
import pac.service.ScreenScrapperService;

@RunWith(MockitoJUnitRunner.class)
public class DefaultScreenScrapperFacadeTest {

	@Mock
	private ScreenScrapperService service;

	@Mock
	private ProductsDataBuilder productDataBuilder;

	@Mock
	private ResultsDataBuilder resultsDataBuilder;
	
	@InjectMocks
	private DefaultScreenScrapperFacade facade;
	
	/**
	 * given: ScreenScrapper application
	 * 
	 * when: Url to web page is null
	 * 
	 * then: return as "Sorry, Url is null or empty"
	 */
	@Test
	public void testGetProductsNullUrl() {
		String result = facade.getProducts(null);
		assertEquals("Sorry, url is either null or empty", result);
	}
	
	/**
	 * given: ScreenScrapper application
	 * 
	 * when: no documents are retrieved.
	 * 
	 * then: return as "Sorry problem in retrieving data"
	 */
	@Test
	public void testGetProductsEmptyDocuments() {
		String url = "some url";
		given(service.getDocuments(url)).willReturn(Collections.EMPTY_LIST);
		String result = facade.getProducts(url);
		assertEquals("Sorry problem in retrieving data", result);
	}
	
	//Other positive tests to follow on

}
