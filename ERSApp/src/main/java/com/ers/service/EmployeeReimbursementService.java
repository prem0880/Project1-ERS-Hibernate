package com.ers.service;

import java.util.List;

import com.ers.entity.EmployeeReimbursementEntity;
import com.ers.model.EmployeeReimbursement;

public interface EmployeeReimbursementService {

	public void addRequest(EmployeeReimbursement er);
	
	public List<EmployeeReimbursementEntity>  viewPendingRequest(EmployeeReimbursement er);
	
	public List<EmployeeReimbursementEntity>  viewResolvedRequest(EmployeeReimbursement er);
	
	
	
	
}
