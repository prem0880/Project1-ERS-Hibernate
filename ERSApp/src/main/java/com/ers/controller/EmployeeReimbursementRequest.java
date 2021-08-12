package com.ers.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.ers.entity.EmployeeEntity;
import com.ers.model.EmployeeReimbursement;
import com.ers.service.EmployeeReimbursementServiceImpl;


public class EmployeeReimbursementRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session1 = request.getSession(true);
		String mail=(String)session1.getAttribute("mail");
		
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		
		Integer rid=(Integer.parseInt(request.getParameter("rid")));
		String type=request.getParameter("expensetype");
		Integer amount=(Integer.parseInt(request.getParameter("amount")));
		String tdate=request.getParameter("tdate");
		String ddate=request.getParameter("ddate");
		String status=request.getParameter("status");
		
		EmployeeReimbursement er = new EmployeeReimbursement();
		
		EmployeeEntity ee = new EmployeeEntity(mail);
		
	System.out.println(ee.getMail());
		er.setEmployeeEntity(ee);
		er.setId(rid);
		er.setExpenseType(type);
		er.setExpenseAmount(amount);
		er.setTransactionDate(tdate);
		er.setDateOfSubmission(ddate);
		er.setStatusOfApplication(status);
		
		
		EmployeeReimbursementServiceImpl ers = new EmployeeReimbursementServiceImpl();
		
		Integer stat=ers.addRequest(er);
		
		
		if(stat!=0) {
			
			System.out.println("Reimbursement Request has been recorded successfully!!!");
		 	RequestDispatcher rd=request.getRequestDispatcher("EmployeeHome.jsp");  
	        rd.forward(request,response);
			
		}
		else
		{
			
			out.println("Reimbursement Request has not been recorded successfully!!!");
		 	RequestDispatcher rd=request.getRequestDispatcher("ReimbursementRequest.jsp");  
	        rd.forward(request,response);
			
			
			
		}
		
		
		ers.viewPendingRequest(er);
		
	
	}

}
