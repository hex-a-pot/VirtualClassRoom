<html>

<head>
<link rel="stylesheet" href="./css/login.css">
<link href="https://fonts.googleapis.com/css?family=Ubuntu"
	rel="stylesheet">
<meta name="viewport" content="width=device-width, initial-scale=1" />
<link rel="stylesheet"
	href="path/to/font-awesome/css/font-awesome.min.css">
<title>Mindtree Classroom</title>
</head>

<body>
	<div class="main">

		<form class="mainForm" method="post" action="authenticateUser">
			<p class="sign" align="center">
				<label for="userType">Sign in as :</label> <select
					name="userType" id="userType">
					<option value="student">Student</option>
					<option value="administrator">Administrator</option>
					<option value="staffMember">Staff Member</option>
					
				</select>
			</p>
			<input class="userName" type="text" align="center"
				placeholder="Username" name="userName"> <input
				class="password" type="password" align="center"
				placeholder="Password" name="password"> <input
				class="submit" align="center" type="submit" value="Sign in">
			<p>
				<br> <a class="register" allign="center"
					href="registerNewUser.jsp">Register here</a>
			</p>
			<p class="forgot" align="center">
				<a href="forgotPassword.jsp">Forgot Password?
			</p>
	</div>

</body>

</html>