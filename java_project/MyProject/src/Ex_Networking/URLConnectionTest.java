package Ex_Networking;

import java.net.MalformedURLException;
import java.net.URL;

public class URLConnectionTest {
	public static void main(String[] args) {
		
		try {
			URL url = new URL("www.google.com");
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
	}
}
