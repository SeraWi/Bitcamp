package Ex_IO;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

public class FileReaderStream05 {

	public static void main(String[] args) {
		
		try {
			// 문자 단위로 읽어올 스트림 생성
			// Reader -> FileReader
			
			Reader in = new FileReader("hyper.txt");
			
			char[] cbuf = new char[10];
			int readLen = 0; //초기화
			
			readLen = in.read(cbuf,0,cbuf.length);
			
//			for(int i = 0; i< readLen; i++) {
//				System.out.println(cbuf[i]);
//			}
			System.out.println(new String(cbuf));//문자열로 출력하기, toString()을 반환함
			
			
			in.close();
			System.out.println("읽기 완료");
			
		} catch (FileNotFoundException e) { //파일 읽어와야 하는데 없으면 에러 발생
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
