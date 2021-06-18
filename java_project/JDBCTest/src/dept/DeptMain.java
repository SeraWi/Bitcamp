package dept;

import java.io.DataOutput;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DeptMain {

	public static void main(String[] args) {
		
		Connection conn = null;
		
				
		try {
			//1. 드라이버 로드
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로드 성공!");

			//2. 연결
			String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:xe";
			String user = "hr";
			String pw = "tiger";

			conn= DriverManager.getConnection(jdbcUrl, user, pw);
			System.out.println("데이터베이스 연결 성공!!");
			
			DeptDao dao = DeptDao.getInstance(); // new DeptDao();
			
//--------------------------------------------------------------------------------------------
			//READ : SELECT
			
//			List<Dept> list = dao.getDeptList(conn);
//			
//			for(Dept dept : list ) {
//				System.out.println(dept);
//			}
//			*/
//
//---------------------------------------------------------------------------------------------			
			// CREATE: INSERT 
			
			Scanner sc = new Scanner(System.in);
//			System.out.println("부서입력을 시작합니다.");
//			System.out.println("부서번호  부서이름 부서위치 순으로 입력해주세요.");
//			System.out.println("예) 50 dev seoul");
//			String deptData = sc.nextLine();
//			String[] deptDatas = deptData.split(" "); // 공백 기준으로 잘라서 배열에 넣기
//			
//			// Dept 객체 생성하고 Dao 메소드 호출
//			Dept dept = new Dept(Integer.parseInt(deptDatas[0]), deptDatas[1], deptDatas[2]);
//			
//		    int result = dao.insertDept(conn,dept);
//		    if(result > 0) {
//		    	System.out.println("입력성공");
//		    }else {
//		    	System.out.println("입력 실패!!");
//		    }
//-----------------------------------------------------------------------------------------------
			
		    // UPDATE : UPDATE
		    		    
//			System.out.println("부서수정을 시작합니다.");
//			System.out.println("수정하고자 하는 부서번호  새로운 부서이름 새로운 부서위치 순으로 입력해주세요.");
//			System.out.println("예) 50 dev seoul");
//			String deptData = sc.nextLine();
//			String[] deptDatas = deptData.split(" "); // 공백 기준으로 잘라서 배열에 넣기
//			
//			// Dept 객체 생성하고 Dao 메소드 호출
//			Dept dept = new Dept(Integer.parseInt(deptDatas[0]), deptDatas[1], deptDatas[2]);
//			
//		    int result = dao.editDept(conn,dept);
//		    if(result > 0) {
//		    	System.out.println("수정성공");
//		    }else {
//		    	System.out.println("수정 실패!!");
//		    }
		    
		    
//------------------------------------------------------------------------------------------------		
			// DELETE : DELETE
			
			System.out.println("부서정보를 삭제합니다.");
			System.out.println("삭제할 부서번호를 입력해주세요.");
			String deptno = sc.nextLine();
			
			int result = dao.deleteDept(conn, Integer.parseInt(deptno));
			
			if(result > 0) {
				System.out.println("삭제 완료 ");
			}else {
				System.out.println("삭제 실패 : 해당 번호의 부서가 존재하지 않습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
	}

}
