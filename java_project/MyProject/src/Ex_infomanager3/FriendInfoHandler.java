package Ex_infomanager3;

import java.util.ArrayList;
import java.util.Scanner;

public class FriendInfoHandler {
	ArrayList<Friend> friends;

	//생성자
	public FriendInfoHandler(int num) { //배열의 사이즈 -> 배열 인스턴스 생성
		//this.friends = new Friend[num];
		//this.numOfFriend = 0;
		friends = new ArrayList<Friend>(num);
	}
	// 데이터의 입력 처리
	// 사용자로부터 친구의 정보를 입력 받아서 -> 인스턴스를 생성 -> 배열에 저장한다. 

	public void addFriend(int choice) {// choice -> 1(고교) or 2(대학)
		Scanner s = new Scanner(System.in);

		System.out.println("이름을 입력해주세요 >> ");
		String name = s.nextLine();
		System.out.println("전화번호를 입력해주세요 >> ");
		String phoneNumber = s.nextLine();
		System.out.println("주소를 입력해주세요 >> ");
		String address = s.nextLine();

		if(choice == 1) {//1. 고교 친구
			System.out.println("직업을 입력해주세요 >>");
			String work = s.nextLine();
			addFriendInfo(new HighFriend(name, phoneNumber, address, work));
		}else {// 2.대학친구
			System.out.println("전공을 입력해주세요 >>");
			String major = s.nextLine();
			addFriendInfo(new UnivFriend(name, phoneNumber, address, major)); 
		}
	}
	//Friend 클래스를 상속하는 타입의 인스턴스를 받아 배열에 저장하기
	public void addFriendInfo(Friend f) {
		//friends[numOfFriend++] = f;
		//컬렉션: List에 요소 추가
		friends.add(f);
		System.out.println("정보가 저장되었습니다.");
	}
	// 모든 데이터를 출력하는 메소드

	public void showAllData() {
		System.out.println("친구의 모든 정보를 출력합니다.");
		System.out.println("=======================");
		
		// 2021-05-31: 수정
		// 요소의 저장방식이 배열->collection->반복문 수정
		if(friends.size() > 0) {
			for(int i =0 ; i < friends.size(); i++) {
				friends.get(i).showData();
				System.out.println("=======================");
			}
		}else {
			System.out.println("입력된 정보가 없습니다. ");
		}
		System.out.println("=======================");
	}
	public void showAllBasicData() {
		System.out.println("친구의 모든 기본 정보를 출력합니다.");
		System.out.println("=======================");
		
		// 2021-05-31: 수정
		// 요소의 저장방식이 배열->collection->반복문 수정
		if(!friends.isEmpty()) {// isEmpty(): 요소의 사이즈 0일때 true 반환 
			for(int i =0 ; i < friends.size(); i++) {
				friends.get(i).showBasicInfo();
				System.out.println("=======================");
			}
		}else {
			System.out.println("입력된 정보가 없습니다. ");
		}
		System.out.println("=======================");
	}
}
