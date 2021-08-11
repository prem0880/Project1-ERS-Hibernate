<%@page import="com.ers.entity.EmployeeReimbursementEntity"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>

<style>

table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 50%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}


</style>
</head>
<body>

<%HttpSession session1 = request.getSession(true);%>
<%String mail=(String)session1.getAttribute("mail");%>



<h2>Pending Reimbursement Requests</h2>
 <%List<Integer> e =(List<Integer>)request.getAttribute("alist");%>
      <form action="http://localhost:8080/ERSApp/ManagerApproveAction" method="get">
  		  <label for="id">Reimbursement ID:</label>
           <select name="id">
         
      <%  for(Integer ere:e){%>
        
          <option value="<%=ere%>"><%=ere%></option>
        	<% }%>

  			</select>           
           
        	 <input type="submit" class="btn btn-success" name="type" value="Approve"/>
  		   <input type="submit" class="btn btn-success" name="type" value="Deny"/>
  		   </form>
             
   		

</body>
</html>