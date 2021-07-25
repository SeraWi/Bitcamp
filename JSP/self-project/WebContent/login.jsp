<%@page import="util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="dao.MemberDao"%>
<%@page import="java.sql.Connection"%>
<%@page import="domain.Member"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- login.jsp

-- 사용자가 전달한 데이터를 받고 ->db에서 확인한후 ->로그인 처리한다
--로그인 처리 ->session 객체에 사용자 정보를 저장
-->



<%
	//DB에서 member가 존재하는지 확인하고
	//아이디와 비번 틀리면 알려줘야 한다.
	
	//reid확인하고 값을 받아오면 쿠키 설정
	String memberId = request.getParameter("memberId");
	String password = request.getParameter("password");
	String rememberId = request.getParameter("rememberId");

	boolean loginChk = false;

	Connection conn = null;
	MemberDao dao = null;

	if(memberId != null && password != null && memberId.trim().length()>3){
		//아이디 길이가 3글자보다 길어야 한다. 
		try{
		conn= ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		
		Member member = dao.selectByIdPw(conn,memberId, password);
		
		//member가 있다.=== 아이디 패스워드 일치하는 회원 정보 있다
		if(member != null){
			//회원의 정보를 session 객체에 저장한다.
			//session.setAttribute("member",member);
			session.setAttribute("loginInfo",member.toLoginInfo());
			loginChk = true;
		}
		
		
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			JdbcUtil.close(conn);
		}
	}

	//id 저장을 위한 쿠키 설정
	//rememberId 값의 유무 체크
	// checkbox에 체크 안되면 name=rememberId값 null이다
	if (rememberId != null && rememberId.equals("on")) {
		//사용자가 아이디 기억하기 check하면
		//쿠키 저장하기(name, value, path, 시간)
		response.addCookie(CookieBox.makeCookie("rememberId", memberId, "/", 60 * 60 * 24 * 365)); //1년 저장
	} else {
		//체크 풀면 시간 0으로 만든다.-> 쿠키 소멸시키기
		response.addCookie(CookieBox.makeCookie("rememberId", memberId, "/", 0));
	}
	
	
	if(loginChk){
		//로그인 성공하면 메인 페이지로 넘어가기
		response.sendRedirect("main.jsp");
	}else{
		//로그인 실패하면 이전페이지 넘어가기
		%>
	
	<script>
		alert('아이디 또는 비밀번호가 일치하지 않습니다.');
		history.go(-1);
	</script>
	
<%
	}

%>