package Ex_IO;
// 6월 2일
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class ByteFileCopy {
	public static void main(String[] args) {
		
		try {
			//1. 파일을 바이너리 데이터를 읽어올 스트림 생성: FileInputStream
			FileInputStream in= new FileInputStream("origin.pdf");
			//2. 파일을 쓰기위한 스트림 생성: FileOutputStream
			FileOutputStream out = new FileOutputStream("copy.pdf");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
}
