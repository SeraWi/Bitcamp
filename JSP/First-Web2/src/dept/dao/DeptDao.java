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
	
	private DeptDao() {}
	
	private static DeptDao dao = new DeptDao();
	
	public static DeptDao getInstance() {
		return dao;
	}
	
	public List<Dept> getDeptList(Connection conn){
		List<Dept> list = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		
		try {
			
			stmt= conn.createStatement();
			String sqlSelect ="select * from dept";
			
			//쿼리 받아오기
			rs=stmt.executeQuery(sqlSelect);
			list= new ArrayList<Dept>();
			
			while(rs.next()) {
				list.add(new Dept(
						rs.getInt("deptno"),
						rs.getString("dname"),
						rs.getString("loc")
						)
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			
			JdbcUtil.close(rs);
			JdbcUtil.close(stmt);
		}
		
		return list;
	}
	
	public int insertDept(Connection conn, Dept dept) {
		int resultCnt =0;
		PreparedStatement pstmt = null;
		String sqlInsert ="insert into dept values(?,?,?)";
		try {
			pstmt = conn.prepareCall(sqlInsert);
			
			pstmt.setInt(1,dept.getDeptno());
			pstmt.setString(2,dept.getDname());
			pstmt.setString(3,dept.getLoc());
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
				
				
		return resultCnt;
	}
	
	public  int updateDept(Connection conn, Dept dept) {
		int resultCnt = 0;
		PreparedStatement pstmt = null;
		
		String sqlUpdate ="update dept set dname=?, loc=? where deptno=?";
		try {
			pstmt = conn.prepareStatement(sqlUpdate);
			pstmt.setString(1,dept.getDname());
			pstmt.setString(2,dept.getLoc());
			pstmt.setInt(3, dept.getDeptno());
			
			resultCnt = pstmt.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	public int deleteDept(Connection conn, int deptno) {
		int resultCnt =0;
		PreparedStatement pstmt = null;
		
		
		String sqlDelete = "delete form dept where deptno=?";
		try {
			pstmt =conn.prepareStatement(sqlDelete);
			
			pstmt.setInt(1, deptno);
			
			resultCnt = pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return resultCnt;
	}
	
	
	public Dept selectByDeptno(Connection conn, int deptno) {
		Dept dept = null;
		PreparedStatement pstmt= null;
		ResultSet rs = null;
		
		String sqlSelect ="select * from dept where deptno =?";
		
		try {
			pstmt = conn.prepareStatement(sqlSelect);
			pstmt.setInt(1, deptno);
			
			rs= pstmt.executeQuery();
			
			if(rs.next()) {
				dept = new Dept();
				dept.setDeptno(rs.getInt("detpno"));
				dept.setDname(rs.getString("dname"));
				dept.setLoc(rs.getNString("loc"));
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
	
}
