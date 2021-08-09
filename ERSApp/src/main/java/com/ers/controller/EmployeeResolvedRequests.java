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
import com.ers.entity.EmployeeReimbursementEntity;
import com.ers.model.EmployeeReimbursement;
import com.ers.service.EmployeeReimbursementServiceImpl;


public class EmployeeResolvedRequests extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		HttpSession session1 = request.getSession(true);
		Integer eid=(Integer)session1.getAttribute("uname");
		
		EmployeeReimbursement er= new EmployeeReimbursement();
		
		EmployeeEntity ee = new EmployeeEntity(eid);
		
		er.setEmployeeEntity(ee);
		
		
		EmployeeReimbursementServiceImpl ers = new EmployeeReimbursementServiceImpl();
		
		List<EmployeeReimbursementEntity> ere=ers.viewResolvedRequest(er);
	
		request.setAttribute("plist", ere);
		
		RequestDispatcher rd=request.getRequestDispatcher("ViewResolvedRequests.jsp");  
        rd.forward(request,response);
	
		
	
	
	}

}
