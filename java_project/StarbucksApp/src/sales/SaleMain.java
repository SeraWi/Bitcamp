package sales;

import java.util.Scanner;

public class SaleMain {
	public static void main(String[] args) {
		
		SaleManager manager = new SaleManager(SaleDao.getInstance());
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("1. 주문하기  2. 내 포인트 확인하기 3. 내 정보 보기");
		System.out.println(" 주문하기 입니다. ");
		//order 인스턴스 생성해서 쓰기
		
		
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			
			System.out.println("관리자가 판매 테이블을 조회합니다. ");
			manager.saleList();
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
	}
}
