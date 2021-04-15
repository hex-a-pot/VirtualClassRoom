<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="./css/welcome.css">
<script type="text/javascript"
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="./js/welcomeMain.js"></script>
<script type="text/javascript" src="./ControllerJs/welcomeController.js"></script>
<meta charset="ISO-8859-1">
<title>Mindtree Classroom</title>
</head>
<body>

	<div class="nav-btn">Menu</div>
	<div class="container">

		<div class="sidebar">
		<nav>
			<a href="#">e-<span>School</span></a><br>
			<ul>
				<br>
				<li><a class="addStudent" href="insertForm.html">Add
						Student</a></li>
				<li><a class="deleteStudent" href="deleteStudent.html">Delete
						Student</a></li>
				<li><a class="editStudent" href="editStudent.html">Edit
						Student</a></li>
				<li><a class="viewStudents" href="viewStudents.jsp">View
						Students</a></li>
				<li><a class="addStaff" href="insertStaff.html">Add Staff</a></li>
				<li><a class="deleteStaff" href="deleteStaff.html">Delete
						Staff</a></li>
				<li><a class="editStaff" href="editStaff.html">Edit Staff</a></li>
				<li><a class="addAnswer" href="insertAnswer.html">Add
						Answer</a></li>
				<li><a class="viewAnswers" href="viewAnswers.jsp">View
						Answers</a></li>
				<li><a class="editAnswer" href="editAnswer.html">Edit Answer</a></li>
				<li><a class="addMarks" href="insertMarks.html">Add Marks</a></li>
				<li><a class="viewMarks" href="viewMarks.jsp">View Marks</a></li>
				<li><a class="addDoubt" href="insertDoubt.jsp">Add Doubt</a></li>
				<li><a class="viewDoubts" href="viewDoubts.jsp">View Doubts</a></li>
				<li><a class="editDoubt" href="editDoubt.html">Edit Doubt</a></li>
				<li><a class="viewStaffs" href="viewStaff.jsp">View Staffs</a></li>
				<li><a class="addVideo" href="addVideo.html">Add Video/File</a></li>
				<li><a class="addNews" href="insertNews.html">Add News</a></li>
				<li><a class="seeNews" href="viewNews.jsp">see News</a></li>
				<li><a class="aboutUs" href="aboutUs.html">About Us</a></li>
				<li><a class="contactUs" href="contactUs.html">Contact Us</a></li>
				<li><a class="LogOut" href="thankyou.jsp">LogOut</a></li>
			</ul>
		</nav>
		</div>

		<div class="main-content">
			<%
			HttpSession sess = request.getSession();
			String userName = String.valueOf(sess.getAttribute("userName"));
			String userType = String.valueOf(sess.getAttribute("userType"));
			out.println("<h2> Welcome, " + userName + ",</h2>");
			out.print("<h3 id = \"userControl\" >" + userType.toUpperCase() + "" + "</h1>");
			%>

			<p>Here you can stuff!</p>
			<div class="panel-wrapper">
				<div class="panel-head">DrawBoard <button onClick="history.go(0);">Erase Board</button></div>
				<div class="panel-body">
					<canvas id="myCanvas">
					
		Sorry, your browser does not support HTML5 canvas technology.
	</canvas>
				</div>
			</div>
			<div class="panel-wrapper">
				<div class="panel-head">Videos</div>
				<div class="panel-body">
					<video width="320" height="240" controls>
						<source src="./media/mindtreeWelcome.mp4" type="video/mp4">
						
						Your browser does not support the video tag.
					</video>
				</div>
			</div>
			<div class="panel-wrapper">
				<div class="panel-head">Welcome to possible!!</div>
				<div class="panel-body"></div>
			</div>
		</div>
	</div>
</body>
</html>