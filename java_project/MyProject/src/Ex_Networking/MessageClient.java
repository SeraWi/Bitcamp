package Ex_Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MessageClient {
	public static void main(String[] args) {
		
		Socket socket = null; //연결
		
		DataInputStream din = null; // 받기
		DataOutputStream dout = null; // 보내기
		
		try {
			socket = new Socket("localhost",8888);
			
			din = new DataInputStream(socket.getInputStream());
			dout = new DataOutputStream(socket.getOutputStream());
			
			Scanner sc = new Scanner(System.in);
			
			String str1 = null; // 받는 데이터
			String str2 = ""; // 보내는 데이터
			
			while(!str2.equals("exit")) {
				
				//데이터 전송, 메시지 보내기
				str2 = sc.nextLine(); 
				dout.writeUTF(str2);
				
				str1 = din.readUTF();
				System.out.println("Server Messager : " + str1 );
			
			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			Util.close(socket);
		}
		
	}
}
