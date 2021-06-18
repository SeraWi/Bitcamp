package jdbc;

public class JDBCTest {

	public static void main(String[] args) {
		
		//1. 드라이버 로드
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("드라이버 클래스를 찾지못함!");
			e.printStackTrace();
		}
		//2. 연결
		//3. sql처리
		//4. close
		
		

	}

}
