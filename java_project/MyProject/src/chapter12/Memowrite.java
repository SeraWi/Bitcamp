package chapter12;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.Scanner;

public class Memowrite {

	// File클래스 이용해서 저장 폴더 생성
	// 문자기반 스트림을 이용해서 날짜와 제목, 메모를 파일에 저장-> Writer,FileWirter, out.write()
	// 파일의 이름은 날짜와 메모의 제목을 이용해서 생성
	

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);

		System.out.println("메모를 하시겠습니까?  1. Yes  2. No");
		int start = Integer.parseInt(scanner.nextLine());

		if(start == 1) {

			File newDir = new File("C:\\Memo");
			if(!newDir.exists()) {// 디렉토리 없다면 만들기
				newDir.mkdir();
				System.out.println("새 디렉토리, Memo 가 만들어졌습니다. ");
			}

			//메모장 기록하기

			System.out.println("메모장을 열었습니다.");

			System.out.print("메모를 작성하는 날짜를 입력해주세요:");
			String date = scanner.nextLine();

			System.out.print("메모의 제목을 입력하세요:");
			String memoTitle = scanner.nextLine();

			System.out.print("메모의 내용을 입력하세요:");
			String memoContent = scanner.nextLine();

			System.out.println("메모가 완료되었습니다.");

			//메모장 파일 이름 : 날짜 + 제목. txt
			String filename = date + memoTitle+ ".txt";

			try {
				//메모 파일 만들기
				Writer out = new FileWriter("C:"+File.separator+ "Memo"+File.separator+ filename);
				BufferedWriter br= new BufferedWriter(out);

				br.write("-----메모장-----");
				br.newLine();
				br.write("작성일" + date);
				br.newLine();
				br.write("제목" + memoTitle);
				br.newLine();
				br.write("메모 내용" + memoContent);
				br.newLine();

				br.close();

			} catch (IOException e) {

				e.printStackTrace();
			}

		}else {// 2.NO
			System.out.println("메모를 종료합니다.");
			System.exit(0);
		}
	}
}
