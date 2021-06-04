package Ex_Networking;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {// 특정 호스트에서 IP얻어온다
	public static void main(String[] args) {
		
		
		String urlStr = "www.naver.com";
		
		try {
			InetAddress ip = InetAddress.getByName(urlStr);
			System.out.println("호스트의 이름:"+ip.getHostName());//호스트의 이름:www.naver.com
			System.out.println("IP address : "+ ip.getHostAddress()); //IP address : 223.130.195.95
		} catch (UnknownHostException e) {// 등록되지 않은 도메인일 경우 에러 발생
			e.printStackTrace();
		}
	}
}
