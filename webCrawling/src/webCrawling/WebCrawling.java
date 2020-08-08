package webCrawling;

import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class WebCrawling {

	public static void main(String[] args) {
		String address = "https://www.naver.com";
		Document doc;
		try {
			doc = Jsoup.connect(address).get();
			System.out.println(doc.html());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
