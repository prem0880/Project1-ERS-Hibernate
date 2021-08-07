<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
pageEncoding="ISO-8859-1" session="true"%>
<!DOCTYPE html>
<html>
<head>
<style>
body {font-family: Arial, Helvetica, sans-serif;}
* {box-sizing: border-box}

/* Full-width input fields */
input[type=text], input[type=password] {
  width: 100%;
  padding: 15px;
  margin: 5px 0 22px 0;
  display: inline-block;
  border: none;
  background: #f1f1f1;
}

input[type=text]:focus, input[type=password]:focus {
  background-color: #ddd;
  outline: none;
}

hr {
  border: 1px solid #f1f1f1;
  margin-bottom: 25px;
}

/* Set a style for all buttons */
button {
  background-color: #04AA6D;
  color: white;
  padding: 14px 20px;
  margin: 8px 0;
  border: none;
  cursor: pointer;
  width: 100%;
  opacity: 0.9;
}

button:hover {
  opacity:1;
}

/* Extra styles for the cancel button */
.cancelbtn {
  padding: 14px 20px;
  background-color: #f44336;
}

/* Float cancel and signup buttons and add an equal width */
.cancelbtn, .signupbtn {
  float: left;
  width: 50%;
}

/* Add padding to container elements */
.container {
  padding: 16px;
}

/* Clear floats */
.clearfix::after {
  content: "";
  clear: both;
  display: table;
}

/* Change styles for cancel button and signup button on extra small screens */
@media screen and (max-width: 300px) {
  .cancelbtn, .signupbtn {
     width: 100%;
  }
}
</style>
</head>
<body>

<%
HttpSession session1 = request.getSession(true);
Integer id = (Integer) session1.getAttribute("uname");
out.println(id);
HttpSession session2=request.getSession();
session.setAttribute("user",id);
%>





<form action="http://localhost:8080/ERSApp/EmployeeUpdateDetails" method="get">

<div class="container">
    <h1>Update Employee Information</h1>
    <hr>

    <label for="employeename"><b>Employee Name</b></label>
    <input type="text" placeholder="Enter Name" name="name" required>

    <label for="designation"><b>Designation</b></label>
    <input type="text" placeholder="Enter Designation" name="designation" required>

    <label for="department"><b>Department</b></label>
    <input type="text" placeholder="Enter Department" name="department" required>

    <label for="email"><b>Email</b></label>
    <input type="text" placeholder="Enter Email" name="email" required>
        
    <div class="clearfix">
    <button type="button" class="cancelbtn">Cancel</button>
   <button type="submit" class="signupbtn">Update</button>
    
    </div>
    
  </div>
</form>
</body>
</html>