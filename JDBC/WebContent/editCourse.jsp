<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.sql.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Course</title>
</head>
<body>


<h4>Edit Course</h4>


<form method="post" action="CourseController">
<input type="hidden" name="id" value="<%=request.getParameter("id") %>"/>
<%
	int id = Integer.parseInt(request.getParameter("id"));
	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/webapp?autoReconnect=true&useSSL=false","username","password");
	String sql = "SELECT * From courses WHERE course_id =?";
	PreparedStatement statement = con.prepareStatement(sql);
	statement.setInt(1,id);
	ResultSet resultset = statement.executeQuery();

	while(resultset.next()){
%>
Course Code : 
<input type="text" name="code" value="<%= resultset.getString("code")%>"/>
<br>
Course Name : 
<input type="text" name="courseName" value="<%= resultset.getString("course_name")%>"/>
<br><br>

<input type="submit" value="Submit"/>



<%} 
	statement.close();
	con.close();%>
</form>
</body>
</html>
