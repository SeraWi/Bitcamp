package sales;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
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
			System.out.println("2. Latte : 4600");
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
			
							
			
//			//샀을 때 sale객체로 정보 넣기
//			ArrayList<Sale> list = new ArrayList<>();
//			
//			// 0개일때는 sale객체 넣을 필요 없다.
//			list.add(new Sale("americano", ameNum));
//			list.add(new Sale("latte", latteNum));
//			list.add(new Sale("sandwich", sandNum));
//			list.add(new Sale("salad", saladNum));
//			list.add(new Sale("cake", cakeNum ));
//			
			//DB에 insert하기
			
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			int result = 0;
						
			try {
				//1. 드라이버 로드
				Class.forName("oracle.jdbc.driver.OracleDriver");
				

				//2. 연결
				String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
				String user = "hr";
				String pw = "tiger";

				conn= DriverManager.getConnection(jdbcUrl, user, pw);
				
				String sql = "insert into sale (salecode, sname, price) values(sale_salecode_seq.nextval, ?, ?)";
				pstmt= conn.prepareStatement(sql);
				
				// 0이 입력되었을 때는 저장하지 않는다. 
				// 반복문 처리한다.
				if( ameNum != 0) {
				pstmt.setString(1, "americano");
				pstmt.setInt(2, americano* ameNum);
				result = pstmt.executeUpdate();
				}
				
				if(latteNum !=0) {
				pstmt.setString(1,"latte");
				pstmt.setInt(2, latte * latteNum);
				result = pstmt.executeUpdate();
				}
				
				if(sandNum != 0) {
				pstmt.setString(1, "sandwich");
				pstmt.setInt(2, sandwich* sandNum);
				result = pstmt.executeUpdate();
				}
				
				if(saladNum != 0) {
				pstmt.setString(1, "salad");
				pstmt.setInt(2, salad* saladNum);
				result = pstmt.executeUpdate();
				}
				if(cakeNum != 0) {
				pstmt.setString(1, "cake");
				pstmt.setInt(2, cake* cakeNum);
				result = pstmt.executeUpdate();
				}
				
				if(result > 0) {
					System.out.println("입력되었습니다.");
				}else {
					System.out.println("입력실패!");
				}
				
				
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
				
				System.out.println("포인트가 A점 적립되었습니다.");
				//회원이 포인트 사용하지 않고 결제 할 경우
				//회원 DB에서 point update하기
				//결제 한후, 회원이 산거 판매DB에 저장하기
				
				
				
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	
		}
}
