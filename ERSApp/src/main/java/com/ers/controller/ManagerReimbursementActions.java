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

import com.ers.entity.EmployeeReimbursementEntity;
import com.ers.service.EmployeeReimbursementServiceImpl;

public class ManagerReimbursementActions extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session1 = request.getSession(true);
		String mail=(String)session1.getAttribute("mail");
		
		
		out.println(mail);
		
		EmployeeReimbursementServiceImpl ers = new EmployeeReimbursementServiceImpl();
	
		List<Integer> ere=ers.requestAction();
	
		
		request.setAttribute("alist", ere);
		HttpSession session2 = request.getSession(true);
		session2.setAttribute("mail", mail);
		RequestDispatcher rd=request.getRequestDispatcher("ViewReimbursementAction.jsp");  
        rd.forward(request,response);
		
		
	}

}
