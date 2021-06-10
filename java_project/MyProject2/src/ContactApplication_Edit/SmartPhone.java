package ContactApplication_Edit;

import java.util.Scanner;


//연락처 정보 관리 클래스

//1. 연락처 입력
//2. 연락처 검색
//3. 연락처 수정
//4. 연락처 삭제
//5. 연락처 전체 리스트 보기
//6. 파일 저장
//7. 파일 로드
//8. 종료

public class SmartPhone {
	Contact[] contacts ;
	Scanner scanner;
	int numOfContact;

	SmartPhone() {
		this.contacts = new Contact[10];
		scanner = new Scanner(System.in);
		this.numOfContact = 0;
	}

	public void saveContact() {////1. 연락처 입력
		System.out.println("-----------연락처를 저장합니다.-----------");
		System.out.print("이름을 입력해주세요 > ");
		String name = scanner.nextLine();
		System.out.print("전화번호를 입력해주세요>");
		String phoneNum = scanner.nextLine();
		System.out.print("이메일을 입력해주세요>");
		String email = scanner.nextLine();
		System.out.print("주소를 입력해주세요>");
		String address = scanner.nextLine();
		System.out.print("생일을 입력해주세요>");
		String birthday = scanner.nextLine();
		System.out.print("그룹을 입력해주세요. (회사 혹은 고객) >");
		String group = scanner.nextLine();
		//그룹에 해당하는 정보-> companyContact or customerConatct
		
		if(group == "회사") {
			System.out.print("회사 이름을  입력해주세요 > ");
			String comName = scanner.nextLine();
			System.out.println("부서 이름을 입력해주세요 >");
			String deptName = scanner.nextLine();
			System.out.println("직급을 입력해주세요 > ");
			String position = scanner.nextLine();
		
			contacts[numOfContact++] = new CompanyContact(name,phoneNum,email,address,birthday,group,comName,deptName,position);
			System.out.println("------------저장 완료 되었습니다.-----------");
			
		}else {// 고객 일때
			System.out.print("회사 이름을  입력해주세요 > ");
			String comName = scanner.nextLine();
			System.out.println("거래품목을 입력해주세요 >");
			String product = scanner.nextLine();
			System.out.println("직급을 입력해주세요 > ");
			String position = scanner.nextLine();
			contacts[numOfContact++] = new CustomerContact(name,phoneNum,email,address,birthday,group,comName,product,position);
			System.out.println("------------저장 완료 되었습니다.-----------");
		}
		
		
		System.out.println("------------저장 완료 되었습니다.-----------");
		contacts[numOfContact++] = new Contact(name,phoneNum,email,address,birthday,group);
	}


	public void searchContact() { //2. 연락처 검색 -> 이름을 검색하면 전화번호가 나온다.\
		
		System.out.println("-------연락처를 검색합니다.--------------");
		System.out.print("이름을 입력하세요. > ");
		String searchName = scanner.nextLine();
		
		//equals
		
		for(int i = 0; i< contacts.length; i++) {
			if(searchName.equals(contacts[i].getName())) { //검색 이름과 비교!
				System.out.println(contacts[i].getName());
				break;
			}else {
				System.out.println("찾으시는 이름이 없습니다.");
			}
		}
	}



	public void showList() {//5. 연락처 전체 리스트 보기 (간략보기)
		// [1] 위세라 010 3524 8600 의 형식

		if(contacts.length >0 ) {
			for( int i = 0; i< contacts.length; i++ ) {
				int listNum = i+1;
				System.out.println("["+ listNum +"]"+contacts[i].getName()
						+contacts[i].getPhoneNum());
			}

		}else {
			System.out.println("연락처에 저장된 정보가 없습니다.");
		}
	}

	public void editContact() {////3. 연락처 수정
		System.out.println("-----------연락처를 수정합니다.-----------");
		showList(); //리스트 보기 먼저

		System.out.println("수정할 연락처의 번호를 선택하세요.");//[1] [2] [3] [4]....
		int selNum = Integer.parseInt(scanner.nextLine());

		System.out.println("수정할 연락처의 상세 보기 입니다.");
		contacts[selNum-1].showData();

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
			contacts[selNum-1].setName(name);
			System.out.println("변경되었습니다.");
			break;
		case 2:
			System.out.print("전화번호를 입력해주세요.");
			String phoneNum = scanner.nextLine();
			contacts[selNum-1].setPhoneNum(phoneNum);
			System.out.println("변경되었습니다.");
			break;

		case 3:
			System.out.print("이메일을 입력해주세요.");
			String email = scanner.nextLine();
			contacts[selNum-1].setEmail(email);
			System.out.println("변경되었습니다.");
			break;

		case 4:
			System.out.print("주소를 입력해주세요.");
			String address = scanner.nextLine();
			contacts[selNum-1].setAddress(address);
			System.out.println("변경되었습니다.");
			break;	
		case 5:
			System.out.print("생일을 입력해주세요.");
			String birthday = scanner.nextLine();
			contacts[selNum-1].setBirthday(birthday);
			System.out.println("변경되었습니다.");
			break;	
		case 6:
			System.out.print("그룹을 입력해주세요.");
			String group = scanner.nextLine();
			contacts[selNum-1].setGroup(group);
			System.out.println("변경되었습니다.");
			break;
		}		
	}
	public void deleteContact() {// 4. 연락처 삭제
		
	}





}
