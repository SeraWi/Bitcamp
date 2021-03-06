package ContactApplication;

import java.util.ArrayList;
import java.util.Scanner;

public class ContactHandler {
	ArrayList <PersonInfo> contacts; 
	Scanner scanner;
	
	//생성자
	ContactHandler(){
		contacts = new ArrayList<>();
		scanner = new Scanner(System.in);
	}
	
	//연락처 저장 기능 메서드
	public void saveContact() {
		System.out.println("연락처 저장을 시작합니다.------------------");
		System.out.print("이름을 입력해주세요.");
		String name = scanner.nextLine();
		System.out.print("전화번호를 입력해주세요.");
		String phoneNum = scanner.nextLine();
		System.out.print("이메일을 입력해주세요.");
		String email = scanner.nextLine();
		System.out.print("주소를 입력해주세요.");
		String address = scanner.nextLine();
		System.out.print("생일을 입력해주세요.");
		String birthday = scanner.nextLine();
		System.out.print("그룹을 입력해주세요.");
		String group = scanner.nextLine();
		
		// 객체 생성후 ArrayList에 넣기
		contacts.add(new PersonInfo(name,phoneNum,email,address,birthday,group));
		System.out.println("정보가 저장되었습니다.");
	}
	
	// 연락처 이름 리스트 보기-> [1] Sam [2] Lea [3] smith 형식으로 
	// 연락처 저장하지 않았을 경우 에러 발생
	public void showList() {
		System.out.println("<LIST>-----------------------");
		
		if(contacts.size() >0 ) {
			for( int i = 0; i< contacts.size(); i++ ) {
				int listNum = i+1;
				System.out.println("["+ listNum +"]"+contacts.get(i).getName());
			}
			
		}else {
			System.out.println("연락처에 저장된 정보가 없습니다.");
		}
	}
	
	//3. 간략 보기 [1] 위세라  010 3524 8600 형식의 리스트 ( 연락처 저장 없는 경우 에러 메시지)
	public void showBasicInfo() {
		System.out.println("연락처 간략 간략보기--------------------------------");
		if(contacts.size() > 0 ) {
			for(int i = 0; i< contacts.size(); i++) {
				int listNum = i+1;
				System.out.println("["+listNum+"]"+contacts.get(i).getName()+
						", "+ contacts.get(i).getPhoneNum());
			}
		}else {
			System.out.println("연락처에 저장된 정보가 없습니다.");
		}
	}
	
	
	// 4. 전체 정보보기는 리스트 보기를 한뒤 -> 리스트 번호를 입력하면 ->전체 정보를 보여주기 
	public void showAllInfo() { // 연락처 상세 보기
		showList();// 리스트 보기 먼저!
		System.out.println("연락처 상세보기를 할 리스트의 번호를 입력하세요.");
		int sel = Integer.parseInt(scanner.nextLine());
		System.out.println("==========================");
		
		System.out.println("상세 정보를 출력합니다.");
		contacts.get(sel-1).showAllInfo();
		System.out.println("==========================");
	}
	
	// 5. 수정하기: 리스트 먼저 보기-> 수정할 번호 고르기-> 수정하기
	public void editInfo() {
		showList();// 리스트 보기 먼저!
		System.out.print("수정할 번호를 입력해주세요.");
		int sel = Integer.parseInt(scanner.nextLine());
		
		System.out.println("선택하신 연락처 상세 정보 입니다.");
		contacts.get(sel -1).showAllInfo();
		
		System.out.println("==========================");
		System.out.println("수정할 정보의 번호를 입력하세요.");
		System.out.println("1. 이름  2. 전화번호 3. 이메일");
		System.out.println("4. 주소  5. 생일       6. 그룹");
		int editNum = Integer.parseInt(scanner.nextLine());
		System.out.println("===========================");
		
		switch(editNum) {
		case 1:
			System.out.print("이름을 입력해주세요.");
			String name = scanner.nextLine();
			contacts.get(sel-1).setName(name);
			System.out.println("변경되었습니다.");
			break;
		case 2:
			System.out.print("전화번호를 입력해주세요.");
			String phoneNum = scanner.nextLine();
			contacts.get(sel-1).setPhoneNum(phoneNum);
			System.out.println("변경되었습니다.");
			break;
		
		case 3:
			System.out.print("이메일을 입력해주세요.");
			String email = scanner.nextLine();
			contacts.get(sel-1).setEmail(email);
			System.out.println("변경되었습니다.");
			break;
			
		case 4:
			System.out.print("주소를 입력해주세요.");
			String address = scanner.nextLine();
			contacts.get(sel-1).setAddress(address);
			System.out.println("변경되었습니다.");
			break;	
		case 5:
			System.out.print("생일을 입력해주세요.");
			String birthday = scanner.nextLine();
			contacts.get(sel-1).setBirthday(birthday);
			System.out.println("변경되었습니다.");
			break;	
		case 6:
			System.out.print("그룹을 입력해주세요.");
			String group = scanner.nextLine();
			contacts.get(sel-1).setGroup(group);
			System.out.println("변경되었습니다.");
			break;
		}
	}
}
