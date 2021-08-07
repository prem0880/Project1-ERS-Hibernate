<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<title>Employee Home</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
	<style>
	body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}
	</style>
</head>
<body>
<%
HttpSession session1 = request.getSession(true);
Integer user = (Integer) session1.getAttribute("uname");
String pass = (String) session1.getAttribute("upass");
out.println(user+" "+pass);
HttpSession session2=request.getSession();
session.setAttribute("uname",user);
%>

  <h2>Employee Home</h2>
  <form action="http://localhost:8080/ERSApp/EmployeeViewDetails" method="get">
  <input type="submit" class="btn btn-primary btn-lg btn-block" value="View Your Information"/>
  </form>
  <form action="http://localhost:8080/ERSApp/UpdateDetails.jsp" method="get">
   <input type="submit" class="btn btn-primary btn-lg btn-block" value="Update Your Information"/>
  </form>
  <form action="" method="get">
   <input type="submit" class="btn btn-primary btn-lg btn-block" value="Submit a Reimbursement Request"/>
  </form>


</body>
</html>