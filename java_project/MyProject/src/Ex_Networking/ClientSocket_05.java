package Ex_Networking;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class ClientSocket_05 {

	public static void main(String[] args) {
		//SocektServer의 IP와 Port번호로 연결 신청:Socket 객체를 생성
		
		try {
			Socket socket = new Socket("localhost",9999);
			
			if(socket != null) {
				System.out.println("클라이언트의 접속 요청: Socket생성");
			}
			
			DataInputStream din = new DataInputStream(socket.getInputStream());
			
			String msg = din.readUTF();
			System.out.println(msg);
			
			din.close();
			socket.close();
			
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
