package chapter09;

import java.util.Scanner;

public class NameTest {
	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		System.out.print("이름을 공백 없이 입력해주세요 >");
		String name = scanner.nextLine();

		if(name.isEmpty()) { 
			System.out.println("이름을 입력하지 않았습니다.");
		}else if(!(name.trim() == name)) {
			System.out.println("공백이 입력되었습니다.");
		}else {
			System.out.println("이름이 정확히 입력되었습니다.");
			System.out.println("이름은 "+ name+" 입니다.");
		}
	}
}

