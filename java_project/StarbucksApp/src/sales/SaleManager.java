package sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;



public class SaleManager {
	

	
	SaleDao dao;
	Scanner scanner;
	
	
	SaleManager(SaleDao dao){
		this.dao = dao;
		scanner= new Scanner(System.in);
	}

	// DB에 있는 sale table을 가져오도록 한다. 
	// 행단위로 sale 객체로 만들어서 전체를 arrayList로 만든다. 
	// 관리자가 이 table을 조회할 수 있도록 한다. 

	

	
	void saleList() {
		// Connection 객체 생성 
		Connection conn = null;

		// 연결
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
		String user = "hr";
		String pw = "tiger";

		try {
			conn= DriverManager.getConnection(jdbcUrl, user, pw);

			List<Sale> list = dao.getSaleList(conn);

			System.out.println("판매 정보 리스트");
			System.out.println("-------------------------------------");
			System.out.println("판매코드 \t 상품명  \t 가격  \t 판매 날짜");
			System.out.println("-------------------------------------");

			for(Sale sale : list) {
				System.out.printf("%d \t %s \t %d \t %s \n", 
						sale.getSalecode(), sale.getSname(), sale.getPrice(), sale.getSaledate()
						);
			}
			System.out.println("-------------------------------------");


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}




	}
	
	
	

	
	
	//2. 내 포인트 확인하기 ->회원 table에서 읽어오기
	
	//3. 내 정보 확인하기 ->회원Table에서 읽어오기

}
