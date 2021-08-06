package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.service.EmployeeLoginService;
import com.ers.service.EmployeeLoginServiceImpl;

public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Integer id=Integer.parseInt(request.getParameter("uname"));
		String pwd=request.getParameter("pass");
		
		Employee employee = new Employee();
	
		employee.setId(id);
		employee.setPassword(pwd);
		
		EmployeeLoginService elogin = new EmployeeLoginServiceImpl();
		
		Boolean loginstat = elogin.checkLogin(employee);
		
		
		if(loginstat == true) {
			
	     			System.out.println("Username and Password are matched!!!");
				 	RequestDispatcher rd=request.getRequestDispatcher("LoginSuccess.html");  
			        rd.forward(request,response);
			
		}
		else
		{
	     			System.out.println("Username and Password are not  matched!!!");
				 	RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
			        rd.forward(request,response);
		}
	
	}

}
