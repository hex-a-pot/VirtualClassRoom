<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/forgotPasswordStyle.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
<title>Mindtree Classroom</title>
</head>

<body>
	<div class="main">

		<form class="mainForm" method="post" action="changePassword">
			<p class="resetPassword" align="center">Reset Password</p>
			<input class="userName" type="text" align="center"
				placeholder="Username" name="userName"> <input class="email"
				type="email" align="center" placeholder="Enter Email" name="email">
				<input class="newPassword" type="password" align="center"
				placeholder="Your new Password" name="newPassword">
				
			<input class="submit" align="center" type="submit"
				value="Reset Password">
			<p class="signAgain" align="center">
				<a href="index.jsp">Sign in 
			</p>
	</div>

</body>
</html>