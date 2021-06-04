package Ex_Networking;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class URLConnectionTest_03 {
	public static void main(String[] args) {
		
		try {
			URL url = new URL("https://www.google.com/");
			
			//URLConnection : url.openConnection()
			URLConnection con = url.openConnection(); //연결!
			InputStream in = con.getInputStream(); // 데이터를 가져온다. 
			
			int i = 0; //받을 데이터
			while(true) {
				i = in.read();
				if(i == -1) {
					break;
				}
				System.out.print((char)i);
			}
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
