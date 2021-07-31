package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.Member;
import member.util.ConnectionProvider;

public class MemberListCommandImpl implements Command {
	
	//select 해서 가져오기 -> result로 저장해서 전달
	//view 지정하기
	
	public void list(HttpServletRequest request) {
		Connection conn = null;
		MemberDao dao = MemberDao.getInstance();
		List<Member> list = null;
		
		try {
			conn= ConnectionProvider.getConnection();
			 list =  dao.selectList(conn);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//회원 리스트 정보 request에 저장 전달
		request.setAttribute("result", list);
	}
	
	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse reponse) {
		list(request);
		return "/WEB-INF/views/memberListView.jsp";
	}

}
