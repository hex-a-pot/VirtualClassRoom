<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<title>Registration form</title>
	<link rel="stylesheet" href = "./css/regStyle.css">
	<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script type="text/javascript" src = "./js/regMain.js"></script>
</head>
<body>

	<div id = "mainForm">
	<form name="regForm" onsubmit="checkValidations()" action = "saveForm" method = "post">
		<p> Name :<br>
		<input type="text" name="name"/>
		</p>
		<p> Username :<br>
		<input type="text" name="userName"/>
		</p>
		<div id = "passwordCheckBox">
		<p> Password :<br>
		<input type="Password" name="password" id = "password" onkeyup="checkPasswordStrength()"/>
		</p>
		</div>
		<div id = "passwordStrengthStatus"></div>
		<p> Confirm Password :<br>
		<input type="Password" name="confirmPassword"/>
		</p>
		<p> Age :
		<input type="text" name="age"/>
		</p>
		
		<p> Email Id :
		<input type="email" name="email"/>
		</p>
		<label for = "address">Address:</label>
		<textarea name="address" rows="5" cols="70" >
		</textarea>
		<p> City :
		<input type="text" name="city"/>
		</p>
		<p> Pincode :
		<input type="text" name="pincode"/>
		</p>
		<p> State :
		<input type="text" name="state"/>
		</p>
		<p> Country :
		<input type="text" name="country"/>
		</p>
  		<br><br><br>
  		<input type="submit" value="Submit Form">
  		<br><br><br>
  		<input type="reset" value="Reset Form">
	</form>
	</div>

</body>
</html>