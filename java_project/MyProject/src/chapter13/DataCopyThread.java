package chapter13;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataCopyThread extends Thread{
	// 데이터의 복사 쓰레드

	String originFile; // 원본파일
	String copyPath; // 복사파일 넣을 경로
	
	DataCopyThread(String originFile,String copyPath){
		this.originFile = originFile;
		this.copyPath = copyPath;
	}

	@Override
	public void run() {//데이터 복사하기

		try {
			BufferedReader in = new BufferedReader(new FileReader(originFile));
			BufferedWriter out = new BufferedWriter(new FileWriter(copyPath+"copied"+originFile));// 원본파일에 copied붙여서 파일 이름

			//원본 데이터
			int data = 0;

			//카피할 데이터
			int copyData = -1;

			while(true) {
				copyData = in.read();

				//탈출
				if(copyData == -1) {
					break;
				}
				out.write(copyData);
				data ++;
			}
			//스트림 닫기
			in.close();
			out.close();

			System.out.println("복사가 완료되었습니다. ");

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}


}
