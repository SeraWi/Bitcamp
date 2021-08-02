package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.LoginInfo;
import member.util.ConnectionProvider;

public class DeleteMemCommandImpl implements Command {
	
	
	//회원정보 삭제할 때 idx받아오기
	//view 지정하기
	//내정보(session)말고 회원리스트에서 다른 회원 삭제하기! 다른 회원 idx구해오기
	
	
	//회원탈퇴할떄
	
	
	public int deleteMember(HttpServletRequest request) {
		int resultCnt =0;
		MemberDao dao = null;
		Connection conn = null;
		
		//파라미터로 받은 idx가져오기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		try {
			conn= ConnectionProvider.getConnection();
			dao=MemberDao.getInstance();
			resultCnt = dao.deleteMember(conn, idx);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resultCnt;
	}
	
	
	
	
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse reponse) {
		request.setAttribute("result",deleteMember(request));
		return "/WEB-INF/views/deleteMemberView.jsp";
	}

}
