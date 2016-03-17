package pac.service;

import java.util.List;

import org.jsoup.nodes.Document;

/**
 * Service layer for ScreenScrapper which connects to web page to scrape and
 * returns the Document objects of the intended products list.
 * 
 * @author Vinod Akkireddy
 *
 */
public interface ScreenScrapperService {
	public List<Document> getDocuments(String url);
}
