package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.LoginInfo;
import member.util.ConnectionProvider;

public class WithdrawMemCommandImpl implements Command {
	
	
	//회원탈퇴할때
	//session에 저장된 idx로 삭제하기
	//view 지정
	
	public int deleteMember(HttpServletRequest request) {
		int resultCnt =0;
		MemberDao dao = null;
		Connection conn = null;
		LoginInfo loginInfo = null;
		
		//session정보 가져오기
		loginInfo = (LoginInfo) request.getSession().getAttribute("loginInfo");
		//session에 있는 idx
		int idx = loginInfo.getIdx();
		
		
		try {
			conn= ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();
			resultCnt = dao.deleteMember(conn, idx);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resultCnt;
	}
	
	
	
	
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse reponse) {
		//결과를 전달
		request.setAttribute("result",deleteMember(request));
		return "/WEB-INF/views/withdrawMemView.jsp";
	}

}
