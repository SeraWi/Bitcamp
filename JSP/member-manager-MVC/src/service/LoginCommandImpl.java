package service;

import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.dao.MemberDao;
import member.domain.LoginInfo;
import member.domain.Member;
import member.util.ConnectionProvider;
import member.util.JdbcUtil;

public class LoginCommandImpl implements Command {
	
	//로그인 처리,확인
	//아이디와 패스워드 가져와서 db와 비교(dao메소드 호출)
	//마지막으로 로그인 후 가야할 view지정 ->login_view.jsp
	
	LoginInfo loginInfo = null;
	
	//로그인 처리->db에 아이디와 패스워드 맞는지 확인한다. ->LoginInfo반환
		public LoginInfo login(HttpServletRequest request) {
			
			//boolean LoginChk = false;
			
			Connection conn = null;
			MemberDao dao = null;
			Member member = null;
			
			
			String memberid = request.getParameter("memberid");
			String password= request.getParameter("password");
			
			if(memberid !=null && password != null && memberid.trim().length()>0) {
				try {
					
					System.out.println("진입");
					conn= ConnectionProvider.getConnection();
					dao = MemberDao.getInstance();
					
					member = dao.selectByIdPw(conn,memberid, password);
					
					if(member != null) {
						//로그인 성공
						//member객체에서 필요한 정보만 loginInfo로 만들어서 session에 저장
						 loginInfo= member.toLoginInfo();
						 System.out.println("저장");
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					JdbcUtil.close(conn);
				}
				
			}
			return loginInfo;
		}
	
	
	@Override
	public String getPage(HttpServletRequest request,HttpServletResponse reponse) {
		login(request);
		//request.setAttribute("loginInfo", loginInfo);
		request.getSession().setAttribute("loginInfo", loginInfo);
		return "/WEB-INF/views/login_view.jsp";
	}

}
