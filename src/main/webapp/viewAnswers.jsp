<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>See Answers</title>
<link href='http://fonts.googleapis.com/css?family=Oxygen' rel='stylesheet' type='text/css'>
<style type="text/css">
table, td, th
{
border:1px solid green;
font-family: 'Oxygen', sans-serif;
}
th
{
background-color:green;
color:white;
}
body
{
	text-align: center;
}
.container
{
	margin-left: auto;
	margin-right: auto;
	width: 40em;
}
h4
{
	font-family: 'Oxygen', sans-serif;
	color:#1E90FF;
}
</style>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<script type="text/javascript">
$(document).ready(function() {
	$("#tablediv").hide();
     $("#showTable").click(function(event){
           $.get('dataToTable',function(responseJson) {
        	   if(responseJson!=null){
            	   $("#staffTable").find("tr:gt(0)").remove();
            	   var table1 = $("#staffTable");
	               $.each(responseJson, function(key,value) { 
	               		   var rowNew = $("<tr><td></td><td></td></tr>");
	             
	                       rowNew.children().eq(0).text(value['doubtId']); 
	                       rowNew.children().eq(1).text(value['answer']); 
	                       rowNew.appendTo(table1);
	               });
                }
    
            });
            $("#tablediv").show();          
	 });      
});
</script>
</head>
<body class="container">
<%

	session.setAttribute("viewMode", "answers");
%>
<h4>Please Click below to get Answers Details -</h4>
<input type="button" value="Show Answers" id="showTable"/>
<br/>
<br/>
<input type="button" value="Click to get back!!" onclick = "history.back()">
<br/>
<br/>
<div id="tablediv">
<table cellspacing="0" id="staffTable"> 
    <tr> 
        <th scope="col">Doubt Id </th> 
        <th scope="col">ANSWER</th> 
    
                
    </tr> 
</table>
</div>
</body>
</html>