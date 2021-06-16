package ContactApplication_Edit;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;


//연락처 정보 관리 클래스

//1. 연락처 입력
//2. 연락처 검색
//3. 연락처 수정
//4. 연락처 삭제
//5. 연락처 전체 리스트 보기
//6. 파일 저장
//7. 파일 로드
//8. 종료

// 예외처리- 메뉴 입력시 발생, 연락처 이름 입력시 공백에 대한 예외처리, 영문자와 한글만 허용 예외처리
// 전화번호 형식에 맞지 않을 때 예외처리, 중복될 때 예외 상황 발생

public class SmartPhone {
	ArrayList<Contact> contacts ; // ArrayList에 contact저장하기
	Scanner scanner;
	int numOfContact;

	SmartPhone() {
		contacts = new ArrayList<>();
		scanner = new Scanner(System.in);
		this.numOfContact = 0;
	}

	public static boolean nameTypeCheck(String name) {// 이름 타입 체크!
		//문자의 영문, 한글 여부를 리턴한다.
		//단어에 영문, 한글이 들어갈 경우 true리턴한다. 
		return Pattern.matches("^[a-zA-Z가-힣]*$", name);
	}

	public static String nameCheck(String name) throws NameNotFindException{
		// 연락처에 이름 입력시 공백에 대한 예외처리 -> 다시 입력받기
		// 영문자와 한글만 허용하는 예외처리
		try {
			if(name != null && !name.trim().isEmpty()) {
				if(nameTypeCheck(name)) {
					//true ->이름 제대로 입력됨
					
				}else {//이름 제대로 입력되지 않음
					throw new NameNotFindException("이름에 한글과 영어 이외의 글자가 입력되었습니다.");
				}
			}else {
				System.out.println("이름이 입력되지 않았습니다.");
			}
		}catch(NameNotFindException ex) {
			System.out.println(ex.getMessage());
		}

		return name;
	}


	public static boolean phoneNumTypeCheck(String phoneNum) {
		//핸드폰 번호가 형식에 맞지 않으면 false리턴한다.
		//핸드폰 번호는 : 000-0000-0000형식
		return Pattern.matches("^01([0|1|6|7|8|9])-?([0-9]{3,4})-?([0-9]{4})$" , phoneNum);
	}


	public static String phoneNumCheck(String phoneNum) throws PhoneNumException {
		// 전화번호가 형식에 맞지 않을 때 예외처리
		// 전화번호가 동일할 경우 예외처리 -> 입력되지 않도록 처리
		try {
			if(phoneNum != null ) {
				if(phoneNumTypeCheck(phoneNum)) {
					//true ->제대로 입력됨
				}else {
					throw new PhoneNumException("전화번호 입력이 형식에 맞지않습니다.");
				}
			}else {
				System.out.println("전화번호가 입력되지 않았습니다.");
			}
		}catch(PhoneNumException ex) {
			System.out.println(ex.getMessage());
		}
		return phoneNum;
	}


	public void saveContact() throws NameNotFindException, PhoneNumException {////1. 연락처 입력


		System.out.println("-----------연락처를 저장합니다.-----------");

		System.out.print("이름을 입력해주세요 >");
		String name = scanner.nextLine();
		// 연락처에 이름 입력시 공백에 대한 예외처리 -> 다시 입력받기
		// 영문자와 한글만 허용하는 예외처리
		nameCheck(name);//예외처리 하는 메서드 호출-> NameNotFindException

		System.out.print("전화번호를 입력해주세요(형식: 000-0000-0000/01000000000) >");
		String phoneNum = scanner.nextLine();
		// 전화번호 형식에 맞지 않을 때 예외처리
		// 전화번호가 동일할 경우 예외처리-> 입력되지 않도록 처리
		phoneNumCheck(phoneNum);

		System.out.print("이메일을 입력해주세요>");
		String email = scanner.nextLine();
		System.out.print("주소를 입력해주세요>");
		String address = scanner.nextLine();
		System.out.print("생일을 입력해주세요>");
		String birthday = scanner.nextLine();
		System.out.print("그룹을 입력해주세요. (회사,고객, 기타) >");
		String group = scanner.nextLine();
		//그룹에 해당하는 정보-> companyContact or customerConatct

		if(group == "회사") {
			System.out.print("회사 이름을  입력해주세요 >");
			String comName = scanner.nextLine();
			System.out.println("부서 이름을 입력해주세요 >");
			String deptName = scanner.nextLine();
			System.out.println("직급을 입력해주세요 >");
			String position = scanner.nextLine();

			contacts.add(new CompanyContact(name,phoneNum,email,address,birthday,group,comName,deptName,position));
			System.out.println("------------저장 완료 되었습니다.-----------");

		}else if(group == "고객"){// 고객 일때
			System.out.print("회사 이름을  입력해주세요 >");
			String comName = scanner.nextLine();
			System.out.print("거래품목을 입력해주세요 >");
			String product = scanner.nextLine();
			System.out.print("직급을 입력해주세요 >");
			String position = scanner.nextLine();
			contacts.add(new CustomerContact(name,phoneNum,email,address,birthday,group,comName,product,position));
			System.out.print("------------저장 완료 되었습니다.-----------");
		}else { //기타
			contacts.add(new Contact(name, phoneNum,email,address,birthday,group));
		}

	}


	public void searchContact() { 
		// 2. 연락처 검색 -> 이름을 검색하면 전화번호가 나온다.
		// 검색 후 결과는
		// 위세라 : 010 3524 8600 의 형식으로 보여준다.

		System.out.println("-------연락처를 검색합니다.--------------");
		System.out.print("이름을 입력하세요. >");
		String searchName = scanner.nextLine();

		//equals

		for(int i = 0; i< contacts.size(); i++) {
			if(searchName.equals(contacts.get(i).getName())) { //검색 이름과 비교!
				System.out.println(contacts.get(i).getName()+" : "+contacts.get(i).getPhoneNum());
				return;
			}
		}
		System.out.println("찾으시는 이름이 없습니다.");
	}

	public void showList() {//5. 연락처 전체 리스트 보기 (간략보기)
		// [1] 위세라 010 3524 8600 의 형식으로 보여주기

		if(contacts.size() >0 ) {
			for( int i = 0; i< contacts.size(); i++ ) {
				int listNum = i+1;
				System.out.println("["+ listNum +"]"+contacts.get(i).getName()+" "
						+contacts.get(i).getPhoneNum());
			}

		}else {
			System.out.println("연락처에 저장된 정보가 없습니다.");
		}
	}

	public void editContact() {////3. 연락처 수정
		System.out.println("-----------연락처를 수정합니다.-----------");
		showList(); //리스트 보기 먼저

		System.out.println("수정할 연락처의 리스트 번호를 선택하세요.");
		//[1] [2] [3] [4]...., 리스트 번호든 이름이든 상관 없이 가능!?
		int selNum = Integer.parseInt(scanner.nextLine());

		System.out.println("수정할 연락처의 상세 보기 입니다.");
		contacts.get(selNum-1).showData();// 인덱스는 하나 작은 수!

		System.out.println("==========================");
		System.out.println("수정할 정보의 번호를 입력하세요.");
		System.out.println("1. 이름  2. 전화번호 3. 이메일");
		System.out.println("4. 주소  5. 생일    6. 그룹");
		int editNum = Integer.parseInt(scanner.nextLine());
		System.out.println("===========================");

		switch(editNum) {// 간략하게 바꾸기
		case 1:
			System.out.print("이름을 입력해주세요.");
			String name = scanner.nextLine();
			contacts.get(selNum-1).setName(name);
			System.out.println("변경되었습니다.");
			break;
		case 2:
			System.out.print("전화번호를 입력해주세요.");
			String phoneNum = scanner.nextLine();
			contacts.get(selNum-1).setPhoneNum(phoneNum);
			System.out.println("변경되었습니다.");
			break;

		case 3:
			System.out.print("이메일을 입력해주세요.");
			String email = scanner.nextLine();
			contacts.get(selNum-1).setEmail(email);
			System.out.println("변경되었습니다.");
			break;

		case 4:
			System.out.print("주소를 입력해주세요.");
			String address = scanner.nextLine();
			contacts.get(selNum-1).setAddress(address);
			System.out.println("변경되었습니다.");
			break;	
		case 5:
			System.out.print("생일을 입력해주세요.");
			String birthday = scanner.nextLine();
			contacts.get(selNum-1).setBirthday(birthday);
			System.out.println("변경되었습니다.");
			break;	
		case 6:
			System.out.print("그룹을 입력해주세요.");
			String group = scanner.nextLine();
			contacts.get(selNum-1).setGroup(group);
			System.out.println("변경되었습니다.");
			break;
		}		
	}

	public void deleteContact() {// 4. 연락처 삭제
		showList(); //리스트 먼저 보여주기

		System.out.println("삭제할 연락처 리스트 번호를 입력해주세요.");
		int selNum = Integer.parseInt(scanner.nextLine());

		contacts.remove(selNum-1); //인덱스 = 리스트 번호 -1
		System.out.println("연락처가 삭제되었습니다.");
	}


}
