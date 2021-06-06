package chapter10;

import java.util.Scanner;

public class IdCheckTest {
	//	1.콘솔에서 사용자 아이디를 입력 받아 정상적인 영문자와 숫자로만 이루어진 값을 입력했는지 확인하는 프로그램을 만들어봅시다.
	//	  ①사용자 예외 클래스를 정의해서 예외를 발생 시켜 봅시다.
	//	  ②예외 클래스 이름은 BadIdInputException이라고 정의합시다.

	public static void idTest(String id) throws BadIdInputException {
		try {
			for(int i = 0; i < id.length(); i++) {
				char idChar = id.charAt(i);
				if(!('a'<= idChar && idChar <= 'z' || 'A' <= idChar && idChar <='Z' || 
						'0' <= idChar && idChar <= '9')) {
					throw new BadIdInputException("사용자 아이디가 잘못 입력 되었습니다.");
				}
			}
		}catch(BadIdInputException ex) {
			System.out.println(ex.getMessage());
		}

	}

	public static void main(String[] args) throws BadIdInputException {

		Scanner scanner = new Scanner(System.in);
		System.out.println("영문자와 숫자로만 이루어진 아이디를 입력해주세요.");
		String personId = scanner.nextLine();
		IdCheckTest.idTest(personId);

	}
}
class BadIdInputException extends Exception{
	BadIdInputException(String msg){
		super(msg);
	}
}
