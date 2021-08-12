package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.Employee;
import com.ers.service.EmployeeLoginService;
import com.ers.service.EmployeeLoginServiceImpl;

public class EmployeeLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		String mail=request.getParameter("mail");
		String pwd=request.getParameter("pass");
		Employee employee = new Employee();
	
		employee.setMail(mail);
		employee.setPassword(pwd);
	
		   
		EmployeeLoginService elogin = new EmployeeLoginServiceImpl();
		
		Boolean loginstat = elogin.checkLogin(employee);
		
		
		if(loginstat == true) {
				
	
					String logintype = elogin.checkLoginType(employee);
				
					System.out.println(logintype);
					if(logintype.equals("employee"))
					{
						HttpSession session=request.getSession();
						session.setAttribute("mail",mail);
					    session.setAttribute("pass",pwd);
						
	     			System.out.println("Username and Password are matched for Employee!!!");
				 	RequestDispatcher rd=request.getRequestDispatcher("EmployeeHome.jsp");  
			        rd.forward(request,response);
			        }
					else if(logintype.equals("manager"))
					{
						HttpSession session=request.getSession();
						session.setAttribute("mail",mail);
					    session.setAttribute("pass",pwd);
						
						request.setAttribute("mail",employee.getMail());
						System.out.println("Username and Password are matched for manager!!!");
					 	RequestDispatcher rd=request.getRequestDispatcher("ManagerHome.jsp");  
				        rd.forward(request,response);
					}
					
			
		}
		else
		{
	     			System.out.println("Username and Password are not  matched!!!");
				 	RequestDispatcher rd=request.getRequestDispatcher("Login.html");  
			        rd.forward(request,response);
		}
	
	}

}
