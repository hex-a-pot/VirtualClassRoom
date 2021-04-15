<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.layers.dao.StudentDaoImpl" %>
<!DOCTYPE html>
<html>
<head>
	<title>Add Doubt</title>
	<link rel="stylesheet" href = "./css/regStyle.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>

	<div id = "mainForm">
	<form name="regForm" onsubmit="checkValidations()" action = "insert?entity=doubt" method = "post">
		<label for = "doubtDesc">Describe your doubt:</label>
		<textarea name="doubtDesc" rows="5" cols="70" >
		</textarea>
  		<br><br><br>
  		<input type="submit" value="Add Doubt">
  		<br><br>
  		<input type="reset" value="Reset Form"><br><br>
  		<input type="button" value="Click to get back!!" onclick = "history.back()">
	</form>
	</div>
			
			
	<%
	String userName = String.valueOf(session.getAttribute("userName"));
	String userType = String.valueOf(session.getAttribute("userType"));
	long id = StudentDaoImpl.getInstance().findIdByUserName(userName);
	session.setAttribute("id",id+"");
	%>
			
				
			
</body>

</body>
</html>