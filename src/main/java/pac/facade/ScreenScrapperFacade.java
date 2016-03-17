package pac.facade;

/**
 * ScreenScrapper Facade, invokes service layer to get Document objects and
 * these document objects are further populated in to respective data objects.
 * 
 * @author Vinod Akkireddy
 *
 */
public interface ScreenScrapperFacade {
	public String getProducts(String url);
}
