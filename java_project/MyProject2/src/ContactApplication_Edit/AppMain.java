package ContactApplication_Edit;

import java.util.Scanner;

public class AppMain {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// 프로젝트 -1
		Contact contact = new Contact("Lea","1111","lea1@google.com","America","970107","friend");

		//데이터를 수정
		contact.setName("지현");
		contact.setPhoneNum("010-1234-5678");

		//출력메소드를 다시 실행합니다.
		contact.showData();
		
		//프로젝트 -2
		
		
		
	}
}
