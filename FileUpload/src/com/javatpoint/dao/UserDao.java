package com.javatpoint.dao;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import com.javatpoint.bean.User;
public class UserDao {
public static Connection getConnection(){
	Connection con=null;
	try{
		Class.forName("com.mysql.jdbc.Driver");
		con=DriverManager.getConnection("jdbc:mysql://sql12.freemysqlhosting.net:3306/sql12389420?useSSL=false","sql12389420","VZKtalgVDK");
	}catch(Exception e){System.out.println(e);} 
	return con;
}
public static int save(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("insert into book2 (title, author, comment, regdate, photo) values(?,?,?,?,?)");
		ps.setString(1,u.getTitle());
		ps.setString(2,u.getAuthor());
		ps.setString(3,u.getComment());
		ps.setString(4,u.getRegdate());
		ps.setString(5,u.getPhoto());
		status=ps.executeUpdate();
		System.out.println(u.getPhoto());
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int update(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("update book2 set title=?,author=?,comment=?,regdate=?photo=?where id=?");
		ps.setString(1,u.getTitle());
		System.out.println(u.getTitle());
		ps.setString(2,u.getAuthor());
		ps.setString(3,u.getComment());
		ps.setString(4,u.getRegdate());
		ps.setString(5,u.getPhoto());
		ps.setInt(5,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}
	return status;
}
public static int delete(User u){
	int status=0;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("delete from book2 where id=?");
		ps.setInt(1,u.getId());
		status=ps.executeUpdate();
	}catch(Exception e){System.out.println(e);}

	return status;
}
public static List<User> getAllRecords(){
	List<User> list=new ArrayList<User>();
	
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from book2");
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			User u=new User();
			u.setId(rs.getInt("id"));
			u.setTitle(rs.getString("title"));
			u.setAuthor(rs.getString("author"));
			u.setComment(rs.getString("comment"));
			u.setRegdate(rs.getString("regdate"));
			u.setPhoto(rs.getString("photo"));
			list.add(u);
		}
	}catch(Exception e){System.out.println(e);}
	return list;
}
public static User getRecordById(int id){
	User u=null;
	try{
		Connection con=getConnection();
		PreparedStatement ps=con.prepareStatement("select * from book2 where id=?");
		ps.setInt(1,id);
		ResultSet rs=ps.executeQuery();
		while(rs.next()){
			u=new User();
			u.setId(rs.getInt("id"));
			u.setTitle(rs.getString("title"));
			u.setAuthor(rs.getString("author"));
			u.setComment(rs.getString("comment"));
			u.setRegdate(rs.getString("regdate"));
			u.setPhoto(rs.getString("photo"));
		}
	}catch(Exception e){System.out.println(e);}
	return u;
}
}
