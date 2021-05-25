package chapter2;

//2021.05.25
//chapter2.Member
public class Member {
	
	int num; //인스턴스 변수

	public static void main(String[] args) {
		
		// 변수 선언
		// 데이터의 타입 식별 이름
		// 데이터 타입 -> 내가 다루어야 하는 데이터의 특징에의해서 결정
		// 기본형 타입 8가지-> 정수형, 실수형, boolean, 문자
		// byte나 short쓸필요 없이 int로 쓰기(입출력에 쓴다)
		
//		①String 타입의 이름을 저장할 수 있는 변수 name을 정의해봅시다.
		String name ="손흥민";
		
		// 메소드 안에 정의 되는 변수(지역변수)는 반드시 초기화 되어야 한다. 
//		②int 타입의 나이를 저장할 수 있는 변수 age를 정의해봅시다.
		int age = 27;
		
//		③double 타입의 키를 저장할 수 있는 변수 height를 정의해봅시다.
		double height = 185.3d;// 키,double형으로 저장
		float weight = 45.8f; // 몸무게
		// float weight = 45.8; 에러
		
//		④boolean 타입의 JAVA책의 보유 여부를 저장할 수 있는 변수 hasBook를 정의해봅시다.
		boolean hasBook = false;
//		⑤이름과 나이, 키, 책의 보유 여부를 출력해봅시다.
		System.out.println("저의 이름은 "+name); // String + String
		System.out.println("키는 "+ height+"cm 입니다"); 
		// String + double + String -> (String + String)+String -> String
		// String + any Type -> String + String
		System.out.println("제 나이는 "+ age+ "살 입니다.");// String  + int + String
		System.out.println("책의 보유 여부: "+ hasBook); //String + boolean
		
		if(hasBook) {
			System.out.println("책을 보유하고 있습니다.");
		}else {
			System.out.println("책을 보유하고 있지 않습니다.");
		}
	}
}
