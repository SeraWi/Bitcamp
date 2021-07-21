package dept.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dept.domain.Dept;
import jdbc.util.JdbcUtil;

public class DeptDao {
	
	// 싱글톤 패턴
	// 1. 인스턴스 생성을 막는다!
	private DeptDao(){}
	// 2. 클래스 내부에서 인스턴스를 생성!
	private static DeptDao	dao = new DeptDao();
	// 3. 외부에서 반환 받을 수 있는 메소드 필요
	public static DeptDao getInstance() {
		//return dao;
		return dao==null? new DeptDao() : dao  ;
	}
	
	public List<Dept> getDeptList(Connection conn){
		

		
		Statement stmt = null;
		ResultSet rs = null;
		List<Dept> list =null; //null로 초기화
		
		
		
		try {
			stmt = conn.createStatement();
			String sql = "select * from dept";
			
			//쿼리로 받아오기
			rs = stmt.executeQuery(sql);
			list = new ArrayList<Dept>();

			
			//쿼리에서 데이터 받아서 dept객체 하나씩 생성 ->배열에 넣기

			while (rs.next()) {
			//	list.add(new Dept(rs.getInt(1), rs.getString(2), rs.getString(3)));
				list.add(makeDept(rs));
			}
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} finally {
			//close해주기
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		
		
		//list 반환
		return list;
		
	}
	
	
	//dept 추가하기
	public int insertDept(Connection conn, Dept dept) {
		//dml 실행
		int resultCnt = 0;
		PreparedStatement pstmt =null;
		
		//sql 작성
		String sql ="insert into dept values(?,?,?)";
		
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//?에 세팅해주기 , 받아온 dept객체안의 정보로
			pstmt.setInt(1, dept.getDeptno());
			pstmt.setString(2,dept.getDname());
			pstmt.setString(3,dept.getLoc());
			
			//실행 후 반환
			resultCnt = pstmt.executeUpdate();
			
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt); //prepared는 statement 상속한다. 
			
		}
		
		
		return resultCnt;
	}
	
	
	//dept 삭제하기
	public static int deleteDept(Connection conn,int deptno ) {
		int resultCnt = 0;
		
		PreparedStatement pstmt = null;
		
		String sql = "delete from dept where deptno=?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//setting
			pstmt.setInt(1, deptno); //전달받은 deptno 넣어주기
			
			//실행 후 반환
			resultCnt = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			JdbcUtil.close(pstmt);
		}
		
		
		
		return resultCnt;
	}
	
	//deptno에 맞는 부서정보만 select하기
	public Dept selectByDeptno(Connection conn, int deptno) {
		Dept dept = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//sql만들기
		String sql = "select * from dept where deptno =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			//setting
			pstmt.setInt(1, deptno);
			
			//결과 ->쿼리 
			rs = pstmt.executeQuery(); //행이 0개이거나 단 1개
			
			if(rs.next()) { //있으면
//				dept = new Dept(rs.getInt(1),rs.getString(2),rs.getString(3)); 
				dept = makeDept(rs);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
			JdbcUtil.close(rs);
			
		}
		return dept;
	}
	
	
	
	
	
	
	public static int updateDept(Connection conn, Dept dept) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		//sql 작성
		String sql = "update dept set dname =?, loc=? where deptno =?";
		
		try {
			pstmt = conn.prepareStatement(sql);
			
			//setting
			pstmt.setString(1, dept.getDname());
			pstmt.setString(2, dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			
			//실행 하고 반환값 
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		return resultCnt;
	}
	
	//내부에서만 쓰는거, 결과를 받아와서 dept 객체 만들어주기
	private Dept makeDept(ResultSet rs) throws SQLException {
		
		Dept dept = new Dept();
		dept.setDeptno(rs.getInt("deptno"));
		dept.setDname(rs.getString("dname"));
		dept.setLoc(rs.getString("loc"));
		
		
		return dept;
	}
	
	
	
	
	
	
	
	
	
}
