package Ex_Networking;

import java.net.MalformedURLException;
import java.net.URL;

public class UrlTest_02 {

	public static void main(String[] args) {
		
		String urlStr = "https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=011&aid=0003919023";
		
		try {
			URL url = new URL(urlStr);
			System.out.println("Protocol : " + url.getProtocol());
			System.out.println("Host name :" +url.getHost());
			System.out.println("Port number: "+ url.getPort());
			System.out.println("Defualt Port number: "+ url.getDefaultPort());
			System.out.println("Query : "+ url.getQuery()); // ?뒤쪽~
			System.out.println("Path : "+ url.getPath());
			System.out.println("File : "+ url.getFile());
			
			
			
		} catch (MalformedURLException e) {//규격에 맞는 주소
			e.printStackTrace();
		}
		
		
		
	}

}
