<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Course</title>
</head>
<body>
<h4>New Course</h4>


<form method="post" action="CourseController">
Course Code : 
<input type="text" name="code"/>
<br>
Course Name : 
<input type="text" name="courseName"/>
<br><br>

<input type="submit" value="Submit"/>

</form>

</body>
</html>