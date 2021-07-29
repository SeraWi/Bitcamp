package service;

import java.sql.Connection;
import java.sql.SQLException;

import dao.MemberDao;
import util.ConnectionProvider;

public class IdCheckService {
	
	//싱글톤
	private IdCheckService() {}
	private static IdCheckService service = new IdCheckService();
	public static IdCheckService getInstance() {
		return service;
	}
	
	
	public String idCheck(String memberid) {
		//String result = "N";
		int cnt = 0;
		Connection conn = null;
		MemberDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			
			//db에 memberid 전달하고 결과값 받기
			cnt = dao.selectById(conn,memberid);
			
			//result = cnt>0? "N" : "Y";
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cnt>0 ? "N" :"Y";
		
	}
}
