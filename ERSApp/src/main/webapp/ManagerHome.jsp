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
String user = (String) session1.getAttribute("mail");
String pass = (String) session1.getAttribute("pass");
out.println(user+" "+pass);
HttpSession session2 = request.getSession(true);
session2.setAttribute("mail",user);
%>

  <h2>Manager Home</h2>
 <form action="http://localhost:8080/ERSApp/ManagerReimbursementActions" method="get">
  <input type="submit" class="btn btn-primary btn-lg btn-block" value="Approve/Deny Pending Reimbursement Requests"/>
  </form>
<form action="http://localhost:8080/ERSApp/ManagerPendingRequests" method="get">
  <input type="submit" class="btn btn-primary btn-lg btn-block" value="View All Pending Requests of Employees"/>
  </form>
  <form action="http://localhost:8080/ERSApp/ManagerResolvedRequests" method="get">
  <input type="submit" class="btn btn-primary btn-lg btn-block" value="View All Resolved Requests of Employees"/>
  </form>
  <form action="http://localhost:8080/ERSApp/Manager" method="get">
  <input type="submit" class="btn btn-primary btn-lg btn-block" value="View Reimbursement Requests of Specific Employee"/>
  </form>
 <form action="http://localhost:8080/ERSApp/ManagerViewDetails" method="get">
  <input type="submit" class="btn btn-primary btn-lg btn-block" value="View All Employees"/>
  </form>
 
</body>
</html>