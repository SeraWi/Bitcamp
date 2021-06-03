package chapter12;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Scanner;

public class MemoRead {
	// 메모리스트와 파일 읽기 기능
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		
		//System.out.println("메모를 읽겠습니까?");
		System.out.println("메모 리스트 입니다.");
		
		//메모 리스트 출력
		File f = new File("C:"+File.separator+ "Memo"); //Memo가있는 경로
		String[] filenames = f.list();
		for( int i = 0; i < filenames.length; i++) {
			System.out.println(filenames[i]);
		}
		
		System.out.println("읽으실 메모 파일을 입력해주세요.");
		String memoTitle = scanner.nextLine();
		
		//파일 읽어오기
		try {
			Reader in = new FileReader("C:"+File.separator+ "Memo"+File.separator+memoTitle);
			BufferedReader br = new BufferedReader(in);
			
			String str = null;
			while(true) {
				str = br.readLine();
				if(str == null) {
					break;
				}
				System.out.println(str);
			}
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
