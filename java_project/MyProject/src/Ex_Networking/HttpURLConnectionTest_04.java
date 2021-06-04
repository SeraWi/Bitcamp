package Ex_Networking;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpURLConnectionTest_04 {
	public static void main(String[] args) {
		String urlStr ="https://news.naver.com/main/read.nhn?mode=LSD&mid=shm&sid1=102&oid=011&aid=0003919023";
	
		try {
			URL url = new URL(urlStr);
			
			//HttpUrlConnection: url.openConnection();
			
			HttpURLConnection hcon = (HttpURLConnection) url.openConnection();
			
			for(int i = 1; i <=8; i++) {
				System.out.print(hcon.getHeaderFieldKey(i));
				System.out.println(" : "+ hcon.getHeaderField(i));
				
//				date : Fri, 04 Jun 2021 04:05:42 GMT
//				cache-control : no-cache
//				expires : Thu, 01 Jan 1970 00:00:00 GMT
//				set-cookie : JSESSIONID=7347E8F41BA5F04F6B825E3885B04F0C; Path=/main; HttpOnly
//				content-language : ko-KR
//				vary : Accept-Encoding
//				transfer-encoding : chunked
//				content-type : text/html;charset=EUC-KR
				
			}
			hcon.disconnect();
			
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
}
