package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.entity.EmployeeEntity;
import com.ers.service.EmployeeLoginService;
import com.ers.service.EmployeeLoginServiceImpl;

public class ManagerViewDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session = request.getSession(true);
		Integer id = (Integer) session.getAttribute("uname");
		
		EmployeeLoginService elogin = new EmployeeLoginServiceImpl();
		
		List<EmployeeEntity> e = elogin.ViewAllDetails();
		
		request.setAttribute("viewall",e);
		
		RequestDispatcher rd=request.getRequestDispatcher("ViewAllInformation.jsp");  
        rd.forward(request,response);
		
		
	
	}

}
