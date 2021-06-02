package Ex_IO;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
// 6월 2일
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ByteBufferedFileCopy03 {
	public static void main(String[] args) {
		
		try {
			InputStream in= new FileInputStream("origin.pdf");//다형성
			OutputStream out = new FileOutputStream("copy3.pdf");
			
			//필터 스트림 생성 -> 기본 스트림이 필요 // 성능개선
			BufferedInputStream fin = new BufferedInputStream(in);
			BufferedOutputStream fout = new BufferedOutputStream(out);
			
			// 카피한 데이터의 크기
			int copyByte = 0;
			
			// 파일에서 읽어올 바이트 데이터
			int bData = -1; //초기화
			while(true) {// 무한반복, bData != -1 로도 가능
				bData = fin.read();
				
				//탈출의 조건: 파일의 모든 데이터를 읽은 경우
				if(bData == -1) {
					break;
				}
				// 출력: 파일에 데이터를 쓴다!
				fout.write(bData);
				copyByte++;
			}
			//스트림 닫기
			in.close();
			out.close();
			System.out.println("복사 완료!!!복사된 바이트 사이즈: "+copyByte +" byte 입니다.");
		
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
