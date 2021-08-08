package com.ers.service;

import java.util.List;

import com.ers.dao.EmployeeReimbursementDaoImpl;
import com.ers.entity.EmployeeReimbursementEntity;
import com.ers.model.EmployeeReimbursement;

public class EmployeeReimbursementServiceImpl implements EmployeeReimbursementService {

	
	EmployeeReimbursementDaoImpl erd= new EmployeeReimbursementDaoImpl();
	@Override
	public void addRequest(EmployeeReimbursement er) {
	
		erd.addRequest(er);
		
		
	}
	
	@Override
	public List<EmployeeReimbursementEntity>  viewPendingRequest(EmployeeReimbursement er) {
	
		
		return erd.viewPendingRequest(er);
		
	}
	@Override
	public List<EmployeeReimbursementEntity> viewResolvedRequest(EmployeeReimbursement er) {

		return erd.viewResolvedRequest(er);
		
	}
	
	
}

