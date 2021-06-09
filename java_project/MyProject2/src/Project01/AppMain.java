package Project01;

import java.util.Scanner;

public class AppMain {
	//	main()메소드를 정의합니다.
	//	연락처 데이터를 저장하는 인스턴스를 생성합니다.
	//	변수 값을 반환하는 각각의 메소드를 호출해서 각 데이터를 출력문으로 출력합니다.
	//	생성된 인스턴스의 정보 출력 메소드를 호출합니다.
	//	인스턴스의 각 변수에 값을 바꾸는 메소드를 이용해서 데이터를 수정합니다.
	//	인스턴스의 출력메소드를 다시 실행합니다

	public static void main(String[] args) {
		// 1. 연락처 저장
		// 2. 연락처 이름 리스트( 연락처 없는 경우 에러 메시지) 
		// 3. [1] 위세라  010 3524 8600 형식의 리스트 ( 연락처 저장 없는 경우 에러 메시지)
		// 4. 전체 정보보기는 리스트 보기를 한뒤 -> 리스트 번호를 입력하면 전체 정보를 보여주기 ( 연락처 저장 없는 경우 에러 메시지)
		// 5. 데이터 수정하기

		ContactHandler  handler = new ContactHandler();
		Scanner scanner = new Scanner(System.in);
		while(true) {
			System.out.println("--------- Contact Application------------- ");
			System.out.println("1. 연락처 저장       2. 리스트 보기     3. 간략 정보 보기(이름과 번호) ");
			System.out.println("4. 전체 정보 보기  5. 수정하기    6. 종료");
			System.out.println("원하시는 번호를 입력하세요.");
			System.out.println("------------------------------------------- ");
			int choice = Integer.parseInt(scanner.nextLine());


			switch(choice) {
			case Menu.SAVE:
				handler.saveContact();
				break;
			case Menu.LIST:
				handler.showList();
				break;
			case Menu.BASICINFO:
				handler.showBasicInfo();
				break;
			case Menu.ALLINFO:
				handler.showAllInfo();
				break;
			case Menu.EDIT:
				break;
			case Menu.EXIT:
				break;
			}
		}
	}
}
interface Menu{
	int SAVE = 1;
	int LIST = 2;
	int BASICINFO =3;
	int ALLINFO = 4;
	int EDIT = 5;
	int EXIT = 6;
}