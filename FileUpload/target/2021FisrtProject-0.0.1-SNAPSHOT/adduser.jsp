<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.javatpoint.dao.UserDao"%>
<jsp:useBean id="u" class="com.javatpoint.bean.User"></jsp:useBean>
<jsp:setProperty property="*" name="u"/>

<%
UserDao uDao = new UserDao();
int i = uDao.save(u);

if(i>0){
response.sendRedirect("list.jsp");
}else{
response.sendRedirect("add_error.jsp");
}
%>