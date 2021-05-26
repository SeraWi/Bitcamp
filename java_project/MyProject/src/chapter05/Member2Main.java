package chapter05;

public class Member2Main {

	public static void main(String[] args) {
		Member2 member1 = new Member2("철수",
				"010-0000-000",
				"음악",
				4,
				"ch@gmail.com",
				"2000-10-01",
				"서울");
		//member.name = "영희"; 에러 not visible
		member1.setName("영희");
		member1.showInfo(); // default메서드:같은 패키지 안에서 접근 가능
		
		//System.out.println(member1.name); //가져와서 읽고 싶은데 에러
		System.out.println(member1.getName()); //데이터 가져오기 가능
	}
}
