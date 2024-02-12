package bbProductTracker;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

public class SiteData {
	private static String url;
	private static Boolean available;
	static Document document;
	
	public SiteData(String url) {
		this.url = url;
		available = true;
		
		document = null;
		try {
			document = Jsoup.connect(url).get();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Boolean isAvailable() {
		Element soldOutButton = document.selectFirst(":containsOwn(sold out)");
		
		if (soldOutButton != null) {
        	available = false;
        	return available;
        } else {
        	return available;
        }
	}
	
	public static String inStock() {
		isAvailable();
		
		if (available) {
			return "In Stock";
		} else {
			return "Not in Stock";
		}
	}
	
	public static String getImageUrl() {
        Element imageElement = document.selectFirst("meta[property=og:image]");
        String imageUrl = imageElement.attr("content");
		return imageUrl;
	}
	
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

