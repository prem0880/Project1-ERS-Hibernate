package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ers.model.Employee;
import com.ers.service.EmployeeRegisterServiceImpl;

@WebServlet("/EmployeeRegisterServlet")
public class EmployeeRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Integer id=(Integer.parseInt(request.getParameter("id")));
		String name=request.getParameter("name");
		String pwd=request.getParameter("pass");
		String des=request.getParameter("designation");
		String dep=request.getParameter("department");
		String email=request.getParameter("email");
		String type=request.getParameter("type");
	
		Employee employee = new Employee();
		employee.setId(id);
		employee.setName(name);
		employee.setPassword(pwd);
		employee.setDesignation(des);
		employee.setDepartment(dep);
		employee.setEmail(email);
		employee.setType(type);
		
		
		EmployeeRegisterServiceImpl eregister = new EmployeeRegisterServiceImpl();
	
		eregister.addEmployee(employee);
		
		
	}

}
