package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.model.Employee;
import com.ers.service.EmployeeLoginService;
import com.ers.service.EmployeeLoginServiceImpl;

public class EmployeeUpdateDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session1 = request.getSession(true);
		Integer id = (Integer) session1.getAttribute("user");
		out.println(id);
		
		String name=request.getParameter("name");
		String des=request.getParameter("designation");
		String dep=request.getParameter("department");
		String email=request.getParameter("email");
		
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setDesignation(des);
		employee.setDepartment(dep);
		employee.setEmail(email);
		
		EmployeeLoginService elogin = new EmployeeLoginServiceImpl();
		
		elogin.UpdateDetails(employee);
		
		
		
	}

}
