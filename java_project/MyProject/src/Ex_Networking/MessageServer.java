package Ex_Networking;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MessageServer {
	// 서버에서 먼저 메시지 보내고 -> client가 답변

	public static void main(String[] args) {
		Socket s = null; 
		ServerSocket ss = null;
		DataInputStream din = null;
		DataOutputStream dout = null;

		try {
			ss = new ServerSocket(8888);
			System.out.println("서버실행");
			System.out.println("--------------------------");
			s = ss.accept();
			System.out.println("Client 접속");
			System.out.println("--------------------------");
			
			
			din = new DataInputStream(s.getInputStream());
			dout = new DataOutputStream(s.getOutputStream());

			Scanner sc = new Scanner(System.in);
			String str1 = null; // 받는 메시지
			String str2 = ""; // 보내는 메시지


			while(str2 .equals("exit")) {
				str1 = din.readUTF();
				System.out.println("client Message: "+ str1);
				
				str2 = sc.nextLine();
				dout.writeUTF(str2);
				dout.flush();

			}

		} catch (IOException e) {

			e.printStackTrace();
		}finally {

			Util.close(dout);
			Util.close(din);
			Util.close(s);
			Util.close(ss);
		}
	}
}

