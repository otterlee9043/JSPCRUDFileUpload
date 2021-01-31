<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.javatpoint.bean.User, com.javatpoint.dao.UserDao"%>
<%@ page import ="java.io.File" %>
<%@ page import ="com.oreilly.servlet.*" %>
<%@ page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy" %>


<%

String filepath = "";
int sizeLimit = 15 * 1024 * 1024;

String realPath = request.getServletContext().getRealPath("upload");
System.out.println(realPath);

File dir = new File(realPath);
if(!dir.exists()) dir.mkdirs();
	
MultipartRequest multpartRequest = null;
multpartRequest = new MultipartRequest(request, realPath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());


String id = multpartRequest.getParameter("id");
String title = multpartRequest.getParameter("title");
String author = multpartRequest.getParameter("author");
String comment = multpartRequest.getParameter("comment");
String regdate = multpartRequest.getParameter("regdate");


filepath = multpartRequest.getFilesystemName("photo");
System.out.println(filepath);
User u = new User();

u.setId(Integer.parseInt(id));
u.setPhoto(filepath);
u.setTitle(title);
u.setAuthor(author);
u.setComment(comment);
u.setRegdate(regdate);

UserDao uDao = new UserDao();
int i=uDao.update(u);

System.out.println("Edituser - id: "+u.getId());
System.out.println("Edituser - title: "+u.getTitle());
System.out.println("Edituser - author: "+u.getAuthor());


if(i>0){
response.sendRedirect("list.jsp");
}else{
response.sendRedirect("add_error.jsp");
}
%>