<%@page import="util.JdbcUtil"%>
<%@page import="domain.Member"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.MemberDao"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="java.sql.SQLException"%>
<%@page import="util.CookieBox"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri ="http://java.sun.com/jsp/jstl/core"%>
<%
	//사용자가 전달한 데이터를 받고 ->DB에서 확인 -> 로그인 처리
	//로그인 처리 -> session 객체에 사용자 정보를 저장
	
	//reid 확인하고 값을 받아오면 쿠키 설정
	
	String memberId = request.getParameter("memberid");
	String password = request.getParameter("password");
	String reid = request.getParameter("reid");
	
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
			session.setAttribute("loginInfo",member.toLoginInfo());
			loginChk = true;
		}
		
		
		}catch(SQLException e){
			e.printStackTrace();
			
		}finally{
			JdbcUtil.close(conn);
		}
	}
	
	
	//ID저장을 위한 쿠키 설정
	// reid 값의 유무 체크
	
	if(reid!=null && reid.equals("on")){
		//쿠키 저장 : 사용자ID 저장
		response.addCookie(CookieBox.makeCookie("reid",memberId,"/", 60*60*24*365)); //1년
	}else{
		// 체크 안하면 저장안하기, 쿠키값을 저장하지 않는다. --->시간을 0으로 한다.
		response.addCookie(CookieBox.makeCookie("reid",memberId,"/", 0));
	}
	
	
	if(loginChk){
		//로그인 성공
		//response.sendRedirect("index.jsp");
		//로그인하면 자동으로 마이페이지로 보낸다.
		response.sendRedirect(request.getContextPath()+"/mypage/mypage.jsp");
		
	}else{
		//로그인 실패
		%>
		<script>
		alert('아이디또는 비밀번호가 일치하지 않습니다. ');
		history.go(-1);

		</script>
		
		<% 
	}
	


%>

