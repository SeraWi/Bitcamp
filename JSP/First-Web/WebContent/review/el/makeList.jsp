<%@page import="domain.Member"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	List<Member> members = new ArrayList<Member>();
	
	members.add(new Member("cool00","1110","COOL"));
	members.add(new Member("cool01","1111",null));
	members.add(new Member("cool02","1112","COOL"));
	members.add(new Member("cool03","1113",null));
	members.add(new Member("cool04","1114",null));
	members.add(new Member("cool05","1115","COOL"));
	members.add(new Member("cool06","1116","COOL"));
	members.add(new Member("cool07","1117",null));
	members.add(new Member("cool08","1118","COOL"));
	members.add(new Member("cool09","1119",null));
	
	session.setAttribute("members",members);
	
%>