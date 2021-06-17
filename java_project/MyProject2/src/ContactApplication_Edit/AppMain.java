package ContactApplication_Edit;

import java.util.Scanner;

public class AppMain {
	
	
	public static int menuCheck(int menuNum) {
		//1~8번외에 입력시 다시 예외처리한다.
		// 그외에 메뉴 입력시 발생할 수 있는 예외 : 영문자 입력, 한글 입력, 특수기호 입력, 숫자 두개 입력...등
		
		try {
			if( menuNum <= 0 || menuNum > 8) {//잘못 입력한 경우
				throw new Exception("메뉴를 잘못 입력했습니다.");
			}
			
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
		return menuNum;
	}
		
	
	public static void main(String[] args) throws NameNotFindException, PhoneNumException {

		Scanner scanner = new Scanner(System.in);
		SmartPhone smart = new SmartPhone(); //스마트폰 생성
		while(true) {
			//메뉴 입력 시 발생할 수 있는 예외 처리
			System.out.println("================================");
			System.out.println("연락처 관리프로그램");
			System.out.println("1. 연락처 입력");
			System.out.println("2. 연락처 검색");
			System.out.println("3. 연락처 수정");
			System.out.println("4. 연락처 삭제");
			System.out.println("5. 연락처 전체 리스트 보기");
			System.out.println("6. 파일 저장");
			System.out.println("7. 파일 로드");
			System.out.println("8. 종료");
			System.out.println("================================");

			int choice = Integer.parseInt(scanner.nextLine());
			menuCheck(choice);
			// 메뉴 입력시 발생할 수 있는 예외에 대하여 예외 처리하기
			switch(choice) {
			case 1:
				smart.saveContact();
				break;
			case 2:
				smart.searchContact();
				break;
			case 3:
				smart.editContact();
				break;
			case 4:
				smart.deleteContact();
				break;
			case 5:
				smart.showList();
				break;
			}

		}
	}
}