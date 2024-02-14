package bbProductTracker;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SiteData {
	private static String url;
	private static Boolean available;
	static Document document;
	
	// Constructor
	public SiteData(String url) {
		SiteData.url = url;
		available = true;
		
		// Connect to the URL
		document = null;
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	// Check if the product is available by finding the "sold out" button
	public static Boolean isAvailable() {
		Element soldOutButton = document.selectFirst(":containsOwn(sold out)");
		
		if (soldOutButton != null) {
        	available = false;
        	return available;
        } else {
        	return available;
        }
	}
	
	// Check if the product is available and return appropriate string
	public static String inStock() {
		isAvailable();
		
		if (available) {
			return "In Stock";
		} else {
			return "Not in Stock";
		}
	}
	
	// Get the image URL from product page
	public static String getImageUrl() {
        Element imageElement = document.selectFirst("meta[property=og:image]");
        String imageUrl = imageElement.attr("content");
		return imageUrl;
	}
	
	// Get the product description from product page
	public static String getDescription() {
        Element description = document.selectFirst(".sku-title");
        String text = description.text();
        text.replaceAll("\\s+", " ");
        
        
        return text;
		}
	
	public static String getUrl() {
		return url;
	}
	
	public static void refresh() {
		new SiteData(url);
	}
	
	
}

