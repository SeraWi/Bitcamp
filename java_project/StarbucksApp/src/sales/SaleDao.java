package sales;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class SaleDao {
	//sale을 조회, 관리한다. 
	
	// 1. 관리자가 전체 판매 리스트를 확인 할 수 있다. read, select
	// 2. 회원이 산 메뉴를 판매 DB에 저장한다. create: read

	// 싱글톤 패턴
	private SaleDao() {

	}
	static private SaleDao dao = new SaleDao();

	public static SaleDao getInstance() {
		return dao;
	}

	//1.관리자가 전체 데이터 확인 가능하다.
	
	// 반환 타입은 List<Sale>
	// 매개 변수 - Connection 객체 :Statement
	ArrayList <Sale> getSaleList(Connection conn){
		ArrayList<Sale> list = null;
		Statement stmt = null;
		ResultSet rs = null;


		//데이터 베이스의 Sale테이블에서 select한 결과를  ->list에 저장한다.


		try {
			stmt = conn.createStatement();

			String sql = "select * from sale order by salecode";


			//결과 받아오기
			rs = stmt.executeQuery(sql);
			list = new ArrayList<>();

			//받아온 데이터를 sale 객체로 생성 ->list에 저장
			while(rs.next()) {
				list.add(new Sale(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4)));
			}


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {


			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if( stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		return list;
	}

	// 2. 회원이 산 메뉴를 판매 DB에 저장한다. create: read
	
	
	
	
	
	
	
	
	

}
