package chapter09;

import java.util.Scanner;

public class NameTest {
	public static void main(String[] args) {
		// 사용자에게 이름 받기
		// 공백있는지 확인,이름 입력하지 않았으면, 잘못입력되었습니다. 
		Scanner scanner = new Scanner(System.in);
		System.out.print("이름을 공백 없이 입렵해주세요 >");
		String name = scanner.nextLine();
		
//		if(name에 공백이 없는 경우) {
//			System.out.println("이름이 정확히 입력되었습니다.");
//		}else {
//			System.out.println("공백이 입력되었습니다. 다시 입력해주세요");
//		}
				
	}
}
