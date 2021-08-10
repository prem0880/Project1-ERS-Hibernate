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
		
		String mail=request.getParameter("mailid");
		String name=request.getParameter("ename");
		String pwd=request.getParameter("pass");
		String des=request.getParameter("designation");
		String dep=request.getParameter("department");
		String contact=request.getParameter("phone");
		String type=request.getParameter("type");
	
		
		System.out.println(mail+" "+name+" "+pwd+" "+des+" "+dep+" "+contact+" "+type);
		
		Employee employee = new Employee();
		employee.setMail(mail);
		employee.setName(name);
		employee.setPassword(pwd);
		employee.setDesignation(des);
		employee.setDepartment(dep);
		employee.setContact(contact);
		employee.setType(type);
		
		
		EmployeeRegisterServiceImpl eregister = new EmployeeRegisterServiceImpl();
	
		eregister.addEmployee(employee);
		
		
	}

}
