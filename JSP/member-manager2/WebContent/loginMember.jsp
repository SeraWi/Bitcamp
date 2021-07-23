<%@page import="util.JdbcUtil"%>
<%@page import="java.sql.SQLException"%>
<%@page import="util.CookieBox"%>
<%@page import="domain.Member"%>
<%@page import="util.ConnectionProvider"%>
<%@page import="java.sql.Connection"%>
<%@page import="dao.MemberDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//사용자가 전달한 데이터 받고
	//db에서 확인
	//로그인 처리
	
	//로그인 처리 ->session 객체에 사용자 정보를 저장
	
	//reid 확인하고 값을 받아오면 쿠키 설정
	
	String memberId =request.getParameter("memberid");
	String password =request.getParameter("password");
	String reid= request.getParameter("reid");
	
	
	boolean loginChk =false;
	
	Connection conn= null;
	MemberDao dao = null;
	
	if(memberId !=null && password !=null && memberId.trim().length()>0){
		
		try{
		conn= ConnectionProvider.getConnection();
		dao = MemberDao.getInstance();
		
		Member member= dao.selectByIdPw(conn,memberId, password);
		
		//member가 있다 ->아이디 패스워드 일치하는 회원 정보 있다.
		
		if(member !=null){
			//회원 정보 session객체에 저장
			session.setAttribute("loginInfo", member.toLoginInfo());
			loginChk= true;
		}
		
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			JdbcUtil.close(conn);
		}
	}
	
	
	
	if(reid!=null &&reid.equals("on")){
		//쿠키 저장:사용자 Id저장
		response.addCookie(CookieBox.makeCookie("reid",memberId,"/",60*60*24*365));
	}else{
		//체크 안하면 저장안하기, 쿠키값을 저장하지 않는다. --->시간을 0으로 만들기
		response.addCookie(CookieBox.makeCookie("reid",memberId,"/",0));
	}
	
	
	if(loginChk){
		//로그인 성공
		response.sendRedirect("main.jsp");
		
	}else{
		//로그인 실패
		%>
		<script>
		
		alert('아이디 또는 비밀번호가 일치하지 않습니다.');
		history.go(-1);
		
		
		</script>
		<%
	}

%>