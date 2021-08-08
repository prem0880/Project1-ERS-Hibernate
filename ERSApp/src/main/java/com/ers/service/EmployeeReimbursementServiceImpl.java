package com.ers.service;

import com.ers.dao.EmployeeReimbursementDaoImpl;
import com.ers.model.EmployeeReimbursement;

public class EmployeeReimbursementServiceImpl implements EmployeeReimbursementService {

	
	EmployeeReimbursementDaoImpl erd= new EmployeeReimbursementDaoImpl();
	@Override
	public void addRequest(EmployeeReimbursement er) {
	
		erd.addRequest(er);
		
		
	}
}
