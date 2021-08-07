package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.Employee;
import com.ers.service.EmployeeLoginService;
import com.ers.service.EmployeeLoginServiceImpl;

public class EmployeeViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(true);
		Integer id = (Integer) session.getAttribute("uname");
		//out.println(user);
		
		Employee employee = new Employee();
		
		employee.setId(id);
	
		EmployeeLoginService elogin = new EmployeeLoginServiceImpl();
		
		
		Employee eview=elogin.ViewDetails(employee);
	
		ArrayList<Employee> eview1 = new ArrayList();
		
		eview1.add(eview);
		request.setAttribute("view",eview1);
		
		RequestDispatcher rd=request.getRequestDispatcher("ViewYourInformation.jsp");  
        rd.forward(request,response);
	}

}
