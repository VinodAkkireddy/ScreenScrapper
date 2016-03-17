# ScreenScrapper
Java Console application to ScreenScrape a web page

This application has 3 layess

Service Layer - Package : pac.service:
Responsible for connecting to web page and retrieve the content - Used Jsoup library to retrieve content as Documents.

Builder layer - Package : pac.builder
Responsible for Converting/Populating Jsoup Document objects as POJOs

Facade layer - Package : pac.facade
Responsible for orchestrating the process, 
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
