package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.util.ConnectionProvider;

public class IdCheckCommandImpl implements Command {

	//id중복체크
	public String idCheck(HttpServletRequest request) {
		int cnt = 0;
		Connection conn = null;
		MemberDao dao = null;
		
		try {
			conn = ConnectionProvider.getConnection();
			dao = MemberDao.getInstance();

			//db에 memberid 전달하고 결과값 받기
			String memberid = request.getParameter("memberid");
			cnt = dao.selectById(conn,memberid);
			System.out.println(cnt);

		} catch (SQLException e) {
			e.printStackTrace();
		}
		//N:중복- 사용불가 Y: 중복 안됨- 사용가능
		return cnt>0 ? "N" :"Y";
	}



	@Override
	public String getPage(HttpServletRequest request, HttpServletResponse reponse) {
		request.setAttribute("result",idCheck(request));
		return "/WEB-INF/views/idChk.jsp";
	}

}
