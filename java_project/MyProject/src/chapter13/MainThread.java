package chapter13;

import java.io.File;
import java.util.Scanner;

public class MainThread {
	// 복사할 대상 파일의 경로와 복사해올 위치 경로를 받는 메인스레드
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.print("복사할 대상(원본파일)의 파일 경로를 입력해주세요 > ");
		String originFile = scanner.nextLine();// 원본파일
		
		System.out.println("복사해올 위치 경로를 입력해주세요 > ");
		String copyPath = scanner.nextLine(); //위치
		
		
		DataCopyThread t = new DataCopyThread(originFile, copyPath); // 원본파일 경로와 복사해올 위치 경로 인자로 넣기
		t.start();
		
	}
}
