package pac.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import pac.service.ScreenScrapperService;

/**
 * Service layer class connects to the third party system with the provided url
 * and retrieved the Document object.
 * 
 * @author Vinod Akkireddy
 *
 */
public class DefaultScreenScrapperService implements ScreenScrapperService{
	/**
	 * Retrieves document objects of each product from the remote url.
	 * 
	 * @param url
	 *            String representing Url of the remote web page.
	 * @return List<Document>
	 */
	@Override
	public List<Document> getDocuments(String url) {
		List<Document> ripeFruitsDocuments = new ArrayList<>();
		Document doc = retrieveFromRemoteWebsite(url);
		Elements productList = doc.select("div#productLister").select("li");
		for (int i = 0; i < productList.size(); i++) {
			Element ele = productList.get(i);
			Elements anchorElement = ele.select("div#productInfo").select("h3").select("a");
			ripeFruitsDocuments.add(retrieveFromRemoteWebsite(anchorElement.attr("href")));
		}
		return ripeFruitsDocuments;
	}

	protected Document retrieveFromRemoteWebsite(String url) {
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
		} catch (IOException e) {
			// Log error, failed to connect to website.
			return null;
		}
		return doc;
	}

}
