package dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DeptDao {

	// 싱글톤 패턴 : 여러개의 인스턴스를 생성하지 못하도록 하는 코딩 스타일, 디자인 패턴

	//1. 외부 클래스 또는 인스턴스에서 해당 클래스로 인스턴스를 생성하지 못하도록 처리
	
	private DeptDao(){
		
	}
	// 2. 클래스 내부(자기자신)에서 인스턴스를 만들고 , 외부에서 접근 못하도록 private
	
	static private DeptDao dao = new DeptDao();
	
	// 3. 메소드를 통해서 반환 하도록 처리, 외부에서 쓸 수 있는 방법
	public static DeptDao getInstance() {
		return dao;
	}
	
	
	// 1. 전체 데이터 검색 기능
	// 반환 타입은 List<Dept> 
	// 매개변수 - Connection 객체 : Statement

	ArrayList <Dept> getDeptList (Connection conn){

		ArrayList<Dept>list = null;

		//데이터 베이스의 Dept테이블 이용 select 결과를 -> list에 저장
		Statement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.createStatement();

			String sql ="select * from dept order by deptno";

			//결과 받아오기
			rs = stmt.executeQuery(sql);
			list = new ArrayList<>();

			// 데이터를 Dept객체로 생성 ->list에 저장
			while(rs.next()) {
				list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
			}


		} catch (SQLException e) {

			e.printStackTrace();
		}finally {

			if(rs != null) {
				try {
					rs.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}


			if(stmt != null) {
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

	// 2. DEPT 테이블에 데이터 저장하는 메소드
	// 반영 횟수 반환
	// 사용자로 부터 데이터 받기 -> dept 객체로

	int insertDept(Connection conn, Dept dept) {//dept 객체 전달 받기
		int result = 0;

		// 전달 받은 Dept 객체의 데이터로 Dept테이블에 저장 -> 결과 값을 반환
		PreparedStatement pstmt = null;


		try {
			//sql먼저 만들기
			String sql = "insert into dept values(dept01_deptno_seq.nextval, ?, ?)";
			pstmt = conn.prepareStatement(sql);

			// 세팅하기
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());

			//결과 받기
			result = pstmt.executeUpdate(); //실행 횟수로 int반환

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		return result;
	}

	// 3. Dept 테이블의 데이터 수정 메소드
	// 반영된 행의 개수 반환
	// 사용자로 부터 데이터를 받아서 처리 -> Dept 객체

	int editDept(Connection conn, Dept dept) {
		
		int result = 0;

		// 전달 받은 Dept 객체의 데이터로 Dept테이블에 저장 -> 결과 값을 반환
		PreparedStatement pstmt = null;


		try {
			String sql = "update dept set dname =?, loc = ? where deptno = ?";
			pstmt = conn.prepareStatement(sql);

			// ? 에 설정해주기
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());

			//메소드 호출 ->결과 

			result = pstmt.executeUpdate(); //실행 횟수로 int반환


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}


		return result;
	}

	// 4. DEPT 테이블의 데이터를 삭제
	// 삭제된 행의 개수를 반환
	// 사용자로부터 deptno를 받아서 처리한다. 
	
	int deleteDept(Connection conn, int deptno) {
		
		int result = 0;
		
		// 데이터 베이스 처리 sql 
		PreparedStatement pstmt  = null;
		
		
		try {
			String sql = "delete from dept where deptno = ? ";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setInt(1, deptno);
			
			result = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		return result;
		
	}
}




