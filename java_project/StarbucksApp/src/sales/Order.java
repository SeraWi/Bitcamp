package sales;

import java.nio.charset.MalformedInputException;
import java.util.Scanner;

public class Order {
	
	static Scanner scanner = new Scanner(System.in);
	

		public static void main(String[] args) {
			
			int americano = 4100;
			int latte = 4600;
			int sandwich =6200;
			int salad = 5000;
			int cake= 5500;
			
			
			System.out.println("주문하기");
			System.out.println("메뉴 입니다.");
			System.out.println("------------------------------------");
			System.out.println("1. Amerciano : 4100");
			System.out.println("2. Latter : 4600");
			System.out.println("3. Sandwich : 6200");
			System.out.println("4. salad : 5000");
			System.out.println("5. cake : 5500");
			System.out.println("------------------------------------");
			
			System.out.println("메뉴의 수량을 입력해주세요.");
			System.out.print("1. Amerciano > ");
			int ameNum = Integer.parseInt(scanner.nextLine());
			System.out.print("2. Latter > ");
			int latteNum = Integer.parseInt(scanner.nextLine());
			System.out.print("3. Sandwich > ");
			int sandNum = Integer.parseInt(scanner.nextLine());
			System.out.print("4. salad > ");
			int saladNum = Integer.parseInt(scanner.nextLine());
			System.out.print("5. cake > " );
			int cakeNum = Integer.parseInt(scanner.nextLine());
			
			System.out.println("------------------------------------");
			System.out.println(" 주문 내역 및  포인트 적립");
			int totalPrice = americano * ameNum + latte * latteNum + sandwich * sandNum + salad * saladNum + cake * cakeNum;
							
			System.out.println(" 총 결제 금액: " +totalPrice);
			
			int point = (int)(totalPrice * 0.01);
			System.out.println("예상 적립 포인트: " + point);
			
			
			System.out.println("------------------------------------");
			System.out.println("결제합니다.");
			System.out.println("현재 사용가능한 포인트: ");
			// 회원 DB에서 point를 read하기

			System.out.println("포인트를 사용하시겠습니까?(포인트를 사용시 현재 결제하시는 상품의 포인트는 적립이 되지 않습니다.)");
			// 회원이 point 사용할시 회원 DB에서 point update하기 
			
			System.out.println("------------------------------------");
			System.out.println("결제완료되었습니다.");
			
			System.out.println("포인트가 A점 적립되었습니다.");
			//회원이 포인트 사용하지 않고 결제 할 경우
			//회원 DB에서 point update하기
			//결제 한후, 회원이 산거 판매DB에 저장하기

			

			
			
	
		}
}
