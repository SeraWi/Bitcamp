package Ex_Networking;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerSocket_06 {

	public static void main(String[] args) {
		
		try {
			ServerSocket serverSocket = new ServerSocket(9999);
			System.out.println("서버실행!");
			Socket socket = serverSocket.accept(); // socket 반환, Socket에서 연결 요청이 올때까지 대기
			
			if(socket != null) {
				System.out.println("서버 접속 완료");
			}
			
			DataOutputStream dout = new DataOutputStream(socket.getOutputStream());
			
			dout.writeUTF("Hi~!!! Client Message");
			dout.flush();
			dout.close();
			socket.close();
			
		} catch (IOException e) {
			
			e.printStackTrace();
		}

	}

}
